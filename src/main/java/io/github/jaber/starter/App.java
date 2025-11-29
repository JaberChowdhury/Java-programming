package io.github.jaber.starter;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.Styles;
import java.awt.TextArea;
import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(
            new CupertinoDark().getUserAgentStylesheet()
        );

        Text header = new Text("TASKS");
        header.getStyleClass().addAll(Styles.TITLE_2, "header-text");

        // Action layout
        TextArea msg_text_area = new TextArea();
        Button add_button = new Button("Add");
        HBox action_layout = new HBox(20, msg_text_area, add_button);

        VBox root = new VBox(20, header);
        root.setPadding(new Insets(30)); // Add breathing room around the edges
        root.setAlignment(Pos.TOP_CENTER);
        root.getStyleClass().add("app-root"); // Hook for CSS

        Scene scene = new Scene(root, 1920, 1080);
        loadCss(scene);

        stage.setTitle("Minimal Todo");
        stage.setScene(scene);
        stage.show();
    }

    private void loadCss(Scene scene) {
        try {
            String css = Objects.requireNonNull(
                getClass().getResource("/gruvbox.css")
            ).toExternalForm();
            scene.getStylesheets().add(css);
        } catch (Exception e) {
            System.err.println("CSS not found.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
