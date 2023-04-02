module fr.wowjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.wowjavafx to javafx.fxml;
    exports fr.wowjavafx;

    exports fr.wowjavafx.controllers;
    opens fr.wowjavafx.controllers to javafx.fxml;
}
