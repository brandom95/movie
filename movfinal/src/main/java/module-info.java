module com.example.movfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires okhttp3;
    requires org.json;
    requires gson;

    opens com.example.movfinal to javafx.fxml;
    exports com.example.movfinal;
}