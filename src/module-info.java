module capstone {
	requires javafx.controls;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
