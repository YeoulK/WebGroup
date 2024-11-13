module com.example.yeoulkang_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.yeoulkang_comp228lab4 to javafx.fxml;
    exports exercise1;
}