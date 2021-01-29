import urllib
import requests
from bs4 import BeautifulSoup
import selenium
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
import pandas as pd
import os



def getList(job_title, location, limit):    
    job_soup = load_indeed_jobs_div(job_title, location, limit)
    jobs_list, num_listings = extract_job_information_indeed(job_soup)
    #return jobs_list
    filename = location + "_Results"
    print(filename)
    save_jobs_to_excel(jobs_list, filename)
    print('{} new job postings retrieved from Indeed. Stored in {}.xlsx and {}.csv.'.format(num_listings, filename, filename))
    
def save_jobs_to_excel(list, filename):
    jobs = pd.DataFrame(list)
    jobs.to_excel(filename+".xlsx")
    jobs.to_csv(filename + ".csv")

def load_indeed_jobs_div(job_title, location, limit):
    getVars = {'q' : job_title, 'l' : location, 'limit' : limit, 'fromage' : 'last', 'sort' : 'date'}
    url = ('https://www.indeed.com/jobs?' + urllib.parse.urlencode(getVars))
    print(url)
    page = requests.get(url)
    soup = BeautifulSoup(page.content, "html.parser")
    job_soup = soup.find(id="resultsCol")
    if not job_soup:
        print(soup)
        
    return job_soup
    
def extract_job_information_indeed(job_soup):
    job_elems = job_soup.find_all('div', class_='jobsearch-SerpJobCard')
     
    cols = []
    extracted_info = []
    cols.append('titles')
    cols.append('companies')
    cols.append('links')
    cols.append('location')
    cols.append('summary')
    
    titles = []
    companies = []
    links = []
    location = []
    summary = []
    
    for job_elem in job_elems:
        titles.append(extract_job_title_indeed(job_elem))
        companies.append(extract_company_indeed(job_elem))
        links.append(extract_link_indeed(job_elem))
        location.append(extract_location_indeed(job_elem))
        summary.append(extract_summary_indeed(extract_link_indeed(job_elem)))
        
    extracted_info.append(titles) 
    extracted_info.append(companies) 
    extracted_info.append(links) 
    extracted_info.append(location) 
    extracted_info.append(summary) 
        
    jobs_list = {}
    
    for j in range(len(cols)):
        jobs_list[cols[j]] = extracted_info[j]
    
    num_listings = len(extracted_info[0])
    
    return jobs_list, num_listings


def extract_job_title_indeed(job_elem):
    title_elem = job_elem.find('h2', class_='title')
    if not title_elem:
        return ""
    title = title_elem.text.strip()
    return title

def extract_company_indeed(job_elem):
    company_elem = job_elem.find('span', class_='company')
    if not company_elem:
        return ""
    company = company_elem.text.strip()
    return company

def extract_link_indeed(job_elem):
    link = job_elem.find('a')['href']
    link = 'https://www.indeed.com' + link
    return link

def extract_location_indeed(job_elem):
    location_elem = job_elem.find('span', class_='location')
    if not location_elem:
        return ""
    location = location_elem.text.strip()
    
    return location

def extract_summary_indeed(link):
    page = requests.get(link)
    soup = BeautifulSoup(page.content, "html.parser")
    job_soup = soup.find(id="jobDescriptionText")
    if not job_soup:
        return ""
    description = job_soup.text.strip()
    return description
    

if __name__ == "__main__":
    #cities = [
            #'New York City', 'Chicago', 'Los Angeles', 'Houston', 'Pheonix', 'Philadelphia', 'San Antonio', 
            #'San Diego', 'Dallas', 'San Jose', 'Austin', 'Jacksonville', 'Fort Worth', 'Columbus', 
            #'Charlotte', 'San Francisco', 'Indianapolis', 'Seattle', 'Denver', 'Boston', 'El Paso', 
            #'Nashville', 'Richmond'
            #]
    #for city in cities:
    #    getList("cyber", city, 50)
     
    cities = [
        'New York City', 'Chicago', 'Los Angeles', 'Houston', 'Pheonix', 'Philadelphia', 'San Antonio', 
        'San Diego', 'Dallas', 'San Jose', 'Austin', 'Jacksonville', 'Fort Worth', 'Columbus', 
        'Charlotte', 'San Francisco', 'Indianapolis', 'Seattle', 'Denver', 'Boston', 'El Paso', 
        'Nashville', 'Richmond'
        ]
    cityFiles = []
    for city in cities: 
        try:
            cityFiles.append(pd.read_excel(city+"_Results.xlsx", engine='openpyxl'))
        except:
            print("duh")
        
    appended_df = pd.concat(cityFiles)
    del appended_df[appended_df.columns[0]]#.drop(appended_df.columns[0], axis=1)
    appended_df.to_excel("Results.xlsx", index=False)
    print('Results stored in Results.xlsx.')
