package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application {
	Stage primaryStage = new Stage();
	//buttons for interaction
	@FXML
	private Button showLesson;
	@FXML
	private Button showLogin;
	@FXML
	private Button showMessaging;
	@FXML
	private Button showProfile;
	@FXML
	private Button showRecruiterHome;
	@FXML
	private Button showRegistration;
	@FXML
	private Button showStudentHome;
	@FXML
	private Button showTeacherHome;
	@FXML
	private Button showTest;


	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		showLogin();		
	}

	private Parent replaceSceneContent(String fxml) throws Exception {
		System.out.println(fxml);
		Parent page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
//		Scene scene = primaryStage.getScene();
//		if (scene == null) {
//			Scene newScene = new Scene(page, 700, 450);
//			this.primaryStage.setScene(newScene);
//			this.primaryStage.show();
//		} else {
//			System.out.println("returning");
			this.primaryStage.setScene(new Scene(page));
			this.primaryStage.show();
//		}
		System.out.println(page);
		return page;
		
	}
	@FXML
	public void showLesson() throws Exception {replaceSceneContent("Lesson.fxml");}
	@FXML
	public void showLogin() throws Exception {replaceSceneContent("login.fxml");}
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
}
