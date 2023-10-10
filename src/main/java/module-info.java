module ademo.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens ademo.javafxtest to javafx.fxml;
    exports ademo.javafxtest;
}