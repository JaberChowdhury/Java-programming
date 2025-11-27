package io.github.jaber.starter;

import atlantafx.base.theme.CupertinoDark;
import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private int count = 0;
    private Text header;

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(
            new CupertinoDark().getUserAgentStylesheet()
        );
        TextArea text_data = new TextArea();
        text_data.setMaxSize(400, 100);
        text_data.setPromptText("Type something here...");

        Text text_area_text = new Text("Waiting for input...");
        text_area_text.setFill(Color.CYAN); // Make it visible

        text_data
            .textProperty()
            .addListener((observable, oldValue, newValue) -> {
                if (newValue.isEmpty()) {
                    text_area_text.setText("Waiting for input...");
                } else {
                    text_area_text.setText("You typed: " + newValue);
                }
            });

        header = new Text("Count: 0");
        header.setFill(Color.web("#ebdbb2"));
        header.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button btnPlus5 = createButton("+5");
        Button btnPlus1 = createButton("+1");
        Button btnMinus1 = createButton("-1");
        Button btnMinus5 = createButton("-5");

        Button reset = createButton("ZERO");

        HBox buttonLayout = new HBox(
            20,
            btnPlus5,
            btnPlus1,
            reset,
            btnMinus1,
            btnMinus5
        );
        buttonLayout.setAlignment(Pos.CENTER);

        btnPlus5.setOnAction(e -> updateCount(5));
        btnPlus1.setOnAction(e -> updateCount(1));
        btnMinus1.setOnAction(e -> updateCount(-1));
        btnMinus5.setOnAction(e -> updateCount(-5));

        reset.setOnAction(e -> updateCount(-count));

        VBox root = new VBox(
            20,
            header,
            buttonLayout,
            text_data,
            text_area_text
        );
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 1920, 1080);

        try {
            String css = Objects.requireNonNull(
                getClass().getResource("/gruvbox.css")
            ).toExternalForm();
            scene.getStylesheets().add(css);
        } catch (Exception e) {
            System.out.println(
                "Warning: gruvbox.css not found. Using default."
            );
        }

        stage.setTitle("Gruvbox Counter & Text Listener");
        stage.setScene(scene);
        stage.show();
    }

    private void updateCount(int change) {
        count += change;
        header.setText("Count: " + count);
    }

    private Button createButton(String label) {
        Button b = new Button(label);
        b.setPrefSize(100, 50);
        return b;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
