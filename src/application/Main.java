package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage primaryStage = new Stage();
	//buttons for interaction
	@FXML
	private Button login;


	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		showLogin();
		
	}

	private Parent replaceSceneContent(String fxml) throws Exception {
		Parent page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
		Scene scene = this.primaryStage.getScene();
		if (scene == null) {
			Scene newScene = new Scene(page, 700, 450);
			try{primaryStage.getScene().getWindow().hide();}catch(Exception e) {}
			primaryStage.setScene(newScene);
			primaryStage.show();
		} else {
			primaryStage.getScene().getWindow().hide();
			primaryStage.setScene(new Scene(page));
			primaryStage.show();
		}
		return page;
	}
	public void showLesson() throws Exception {replaceSceneContent("Lesson.fxml");}
	public void showLogin() throws Exception {replaceSceneContent("login.fxml");}
	public void showMessaging() throws Exception {replaceSceneContent("Messaging.fxml");}
	public void showProfile() throws Exception {replaceSceneContent("Profile.fxml");}
	public void showRecruiterHome() throws Exception {replaceSceneContent("RecruiterHome.fxml");}
	public void showRegistration() throws Exception {replaceSceneContent("Registration.fxml");}
	public void showStudentHome() throws Exception {replaceSceneContent("StudentHome.fxml");}
	public void showTeacherHome() throws Exception {replaceSceneContent("TeacherHome.fxml");}
	public void showTest() throws Exception {replaceSceneContent("Test.fxml");}


}
