package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Main extends Application {
	Stage primaryStage = new Stage();
	//buttons for interaction
	@FXML
	private Button showLogin;
	@FXML
	private Button showMessaging;
	@FXML
	private Button showProfile;
	@FXML
	private Button showSearchForJob;
	@FXML
	private Button showRecruiterHome;
	@FXML
	private Button showRegistration;
	@FXML
	private Button showStudentHome;
	@FXML
	private Button showTeacherHome;
	@FXML
	private Button showPostJob;
	@FXML
	private Button postJob;
	@FXML
	private Button showTest;
	@FXML
	private Button showAssignTest;
	@FXML
	private Button showLesson;
	@FXML
	private Button showSearchForStudent;
	@FXML
	private TextField username;
	@FXML
	private TextField password;


	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		showLogin();		
	}

	private Parent replaceSceneContent(String fxml) throws Exception {
		Parent page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
		this.primaryStage.setScene(new Scene(page));
		this.primaryStage.show();
		return page;
	}
	
	@FXML
	public boolean login() throws Exception{
		if(username.getText().equals("student")) {
			
				showStudentHome();
				return true;
			
		}
		else if(username.getText().equals("teacher")) {
			if(username.getText().equals(password.getText())) {
				showTeacherHome();
				return true;
			}
		}
		else if(username.getText().equals("recruiter")) {
			if(username.getText().equals(password.getText())) {
				showRecruiterHome();
				return true;
			}
		}
		
		return false;
	}
	
	@FXML
	public void showLesson() throws Exception {System.out.println("lesson");replaceSceneContent("Lesson.fxml");}
	@FXML
	public void showLogin() throws Exception {replaceSceneContent("Login.fxml");}
	@FXML
	public void showMessaging() throws Exception {replaceSceneContent("Messaging.fxml");}
	@FXML
	public void showProfile() throws Exception {replaceSceneContent("Profile.fxml");}
	@FXML
	public void showRecruiterHome() throws Exception {replaceSceneContent("RecruiterHome.fxml");}
	@FXML
	public void showRegistration() throws Exception {replaceSceneContent("Registration.fxml");}
	@FXML
	public void showStudentHome() throws Exception {replaceSceneContent("StudentHome.fxml");}
	@FXML
	public void showTeacherHome() throws Exception {replaceSceneContent("TeacherHome.fxml");}
	@FXML
	public void showTest() throws Exception {replaceSceneContent("Test.fxml");}
	@FXML
	public void showPostJob() throws Exception {replaceSceneContent("PostJob.fxml");}
	@FXML
	public void showAssignTest() throws Exception {replaceSceneContent("AssignTest.fxml");}
	@FXML
	public void showSearchForStudent() throws Exception {replaceSceneContent("SearchForStudent.fxml");}
	@FXML
	public void showSearchForJob() throws Exception {replaceSceneContent("SearchForJob.fxml");}
}
