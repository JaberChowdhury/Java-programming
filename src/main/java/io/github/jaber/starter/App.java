package io.github.jaber.starter;

import atlantafx.base.theme.CupertinoDark; // <--- Change to Dark base
import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        // 1. THEME: Start with a Dark Base (CupertinoDark or PrimerDark)
        Application.setUserAgentStylesheet(
            new CupertinoDark().getUserAgentStylesheet()
        );

        // --- VIEW SETUP ---
        header = new Text("Count: 0");
        // Changing text color to matches Gruvbox standard (cream/white)
        // or keep your pink if you prefer.
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

        // --- LOGIC SETUP ---
        btnPlus5.setOnAction(e -> updateCount(5));
        btnPlus1.setOnAction(e -> updateCount(1));
        btnMinus1.setOnAction(e -> updateCount(-1));
        btnMinus5.setOnAction(e -> updateCount(-5));
        reset.setOnAction(e -> updateCount(count * -1));

        VBox root = new VBox(20, header, buttonLayout);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 900, 600);

        // 2. CSS: Load your custom Gruvbox overrides
        // Ensure gruvbox.css is in src/main/resources/
        String css = Objects.requireNonNull(
            getClass().getResource("/gruvbox.css")
        ).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Gruvbox Counter");
        stage.setScene(scene);
        stage.show();
    }

    private void updateCount(int change) {
        count += change;
        header.setText("Count: " + count);
    }

    private Button createButton(String label) {
        Button b = new Button(label);
        b.setPrefSize(150, 80);
        return b;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
