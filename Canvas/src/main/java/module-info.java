module com.example.canvas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.canvas to javafx.fxml;
    exports com.example.canvas;
}