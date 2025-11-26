package io.github.jaber.starter;

import atlantafx.base.controls.ToggleSwitch; // <--- Import the Switch control
import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.Styles;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Default to Light Mode
        Application.setUserAgentStylesheet(
            new CupertinoLight().getUserAgentStylesheet()
        );
        String theme_name = "Dark mode";
        // 2. Create the Toggle Switch
        ToggleSwitch themeSwitch = new ToggleSwitch(theme_name);
        System.out.println("hi");
        // 3. Add the Logic (The "Listener")
        themeSwitch
            .selectedProperty()
            .addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    // Switch is ON -> Dark Mode
                    Application.setUserAgentStylesheet(
                        new CupertinoDark().getUserAgentStylesheet()
                    );
                } else {
                    // Switch is OFF -> Light Mode
                    Application.setUserAgentStylesheet(
                        new CupertinoLight().getUserAgentStylesheet()
                    );
                }
            });

        // 4. Create some UI to look at
        Label label = new Label("Hello, Cupertino!");
        label.getStyleClass().add(Styles.TITLE_1);

        VBox root = new VBox(20, label, themeSwitch);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 400);
        System.setProperty("glass.gtk.uiScale", "1.5");

        stage.setTitle("Theme Switcher");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
