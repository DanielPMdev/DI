module com.dpm.alumnosjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.dpm.alumnosjavafx to javafx.fxml;
    exports com.dpm.alumnosjavafx;
}