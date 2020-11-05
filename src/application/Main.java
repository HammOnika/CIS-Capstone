package application;
	
import java.awt.GraphicsConfiguration;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	static GraphicsConfiguration gc;
	//login scene
	private TextField tfUsername = new TextField();
	private TextField tfPassword = new TextField();
	private Button btlogin = new Button("Login");
	private String username;
	
	//home
		//header
	private Button btProfile = new Button("Profile");
	private Button logout = new Button("Log out");
		//menu
	private Button btQuizes = new Button("View Completed Quizes");
	private Button btTakeQuiz = new Button("Take Quizes");
	private Button btLesson = new Button("View Lessons");
	private Button jobSearch = new Button("Job Search");
		//feed(this needs to be made dynamic)
	Button takeTest = new Button("Take Test");
	Button takeTest2 = new Button("Take Test");
	Button takeTest3= new Button("Take Test");
	
	Button takeLesson = new Button("View Module");
	Button takeLesson2 = new Button("View Module");
	Button takeLesson3= new Button("View Module");

	//profile
	private Button home = new Button("home");

/* 
 	static GraphicsConfiguration gc;
	private TextField tfUsername = new TextField();
	private TextField tfPassword = new TextField();
	private Button btCalculate = new Button("Calculate");
	public static void main(String[] args) {
		JFrame frame= new JFrame(gc);    
        frame.setVisible(true);

	}
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Username"), 0, 3);
		gridPane.add(tfUsername, 1, 3);
		gridPane.add(new Label("Password"), 0, 4);
		gridPane.add(tfPassword, 1, 4);
		gridPane.add(btCalculate, 1, 5);
	}*/
	
	public void start(Stage primaryStage) {
		try {
			GridPane gridPane = new GridPane();
			gridPane.setHgap(20);
			gridPane.setVgap(10);
			BorderPane root = new BorderPane();

			
			gridPane.add(new Label("Username"), 0, 0);
			gridPane.add(tfUsername, 1, 0);
			gridPane.add(new Label("Password"), 0, 1);
			gridPane.add(tfPassword, 1, 1);
			gridPane.add(btlogin, 1, 2);
		
			
            //root.getChildren().addAll(gridPane);
			root.setCenter(gridPane);
			Scene loginscene = new Scene(root,400,400);
			
			
			//end login screen
			//---------------------------------------------------
			//start home scene
			//header (on top)
			HBox statusbar = new HBox();
			Label Name = new Label(tfUsername.getText()+"\t\t");
			Region region1 = new Region();
		    HBox.setHgrow(region1, Priority.ALWAYS);
		    Region region2 = new Region();
		    HBox.setHgrow(region2, Priority.ALWAYS);
		    statusbar.getChildren().addAll(btProfile, region1, Name, region2, logout);
			
			
			
			//menu (on left)
			VBox menu = new VBox(20);
			menu.setPadding(new Insets(20, 20, 20, 20));
			menu.getChildren().addAll(btQuizes, btTakeQuiz, btLesson, jobSearch);
			
			
			//feed (on center)
			VBox feed  = new VBox(10);
			Label description = new Label("This section of the UI will hold notifications such as \n"
					+ "recommended next modules/tests, assignments from instructors,\n notifications from recruiters, new tests scores");
			Label dummy = new Label ("\n\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, \nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \nUt enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"");
			Label sampleTest = new Label("\nRecommended next test on \"Reverse Engineering\"");
			Label sampleLesson = new Label("\nRecommended next module on \"Reverse Engineering\"");
			Button takeLesson = new Button("Next Lesson");
			feed.getChildren().addAll(region1, description,sampleLesson, takeLesson, sampleTest, takeTest, dummy);
			
			
			BorderPane homePane = new BorderPane();
			homePane.setTop(statusbar);
			homePane.setLeft(menu);
			homePane.setCenter(feed);
			Scene homescene = new Scene(homePane, 900, 600);

			//end home scene
			//---------------------------------------------------
			//Profile scene
			VBox userinformation = new VBox(20);
			Label uname = new Label("Username:\t"+username);
			Label email = new Label("Email:\tdummyEmail@gmail.com");
			Label location = new Label("Location:\t City/State");
			Label interests = new Label("Interests:\t Reversing, binary exploitation");
			Label about = new Label("About\tsome words about the student written by the student");
			userinformation.getChildren().addAll(uname, email, location, interests, about, home);
			
			
			BorderPane profile = new BorderPane();
			profile.setCenter(userinformation);
			Scene profilescene = new Scene(profile, 900, 600);
			//end profile scene
			//--------------------------------------------------
			//start test 
			VBox listTests = new VBox(20);
			VBox test1 = new VBox();
			test1.getChildren().addAll(new Label("test decription"), takeTest);
			
			VBox test2 = new VBox();
			test2.getChildren().addAll(new Label("for example: reverse engineering\nmodule 1, x86 basics"), takeTest2);
			
			VBox test3 = new VBox();
			test3.getChildren().addAll(new Label("for example: reverse engineering\\nmodule 2, x86 basics part 2"), takeTest3);
			
			listTests.getChildren().addAll(test1, test2, test3, home);
			
			BorderPane testList = new BorderPane();
			testList.setCenter(listTests);
			Scene listTestScene = new Scene(testList, 900, 600);
			
			//end test scene
			//--------------------------------------------------
			//start lesson 
			VBox listLessons = new VBox(20);
			VBox lesson1 = new VBox();
			lesson1.getChildren().addAll(new Label("lesson decription"), takeLesson);
			
			VBox lesson2 = new VBox();
			lesson2.getChildren().addAll(new Label("for example: reverse engineering\nmodule 1, x86 basics"), takeLesson2);
			
			VBox lesson3 = new VBox();
			lesson3.getChildren().addAll(new Label("for example: reverse engineering\\nmodule 2, x86 basics part 2"), takeLesson3);
			
			listLessons.getChildren().addAll(lesson1, lesson2, lesson3, home);
			
			BorderPane lessonList = new BorderPane();
			lessonList.setCenter(listLessons);
			Scene listlessonScene = new Scene(lessonList, 900, 600);
			
			//student UI
			
			
			
			primaryStage.setScene(loginscene);
			primaryStage.show();
			
			//buttons
			
			btlogin.setOnAction(a -> {
				try {
					//validate login
					username = tfUsername.getText();
					primaryStage.setScene(homescene);
				} catch (Exception e) {
					System.err.println(e);
				}
			
			});
			
			logout.setOnAction(a -> {
				try {
					primaryStage.setScene(loginscene);
				} catch (Exception e) {
					System.err.println(e);
				}
			});
			
			btLesson.setOnAction(a -> {
				try {
					primaryStage.setScene(listlessonScene);
				} catch (Exception e) {
					System.err.println(e);
				}
			});
			
			btProfile.setOnAction(a -> {
				try {
					primaryStage.setScene(profilescene);
				} catch (Exception e) {
					System.err.println(e);
				}
			});
			home.setOnAction(a -> {
				try {
					primaryStage.setScene(homescene);
				} catch (Exception e) {
					System.err.println(e);
				}
			});
			
			btTakeQuiz.setOnAction(a -> {
				try {
					primaryStage.setScene(listTestScene);
				} catch (Exception e) {
					System.err.println(e);
				}
			});
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
