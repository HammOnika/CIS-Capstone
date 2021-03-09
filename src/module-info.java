module capstone {
	requires javafx.controls;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	opens application to javafx.graphics, javafx.fxml;
}
