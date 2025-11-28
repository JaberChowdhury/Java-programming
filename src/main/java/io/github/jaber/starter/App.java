package io.github.jaber.starter;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.Styles;
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

    private final ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(
            new CupertinoDark().getUserAgentStylesheet()
        );

        // --- 1. UI Components ---

        // Header
        Text header = new Text("TASKS");
        header.getStyleClass().addAll(Styles.TITLE_2, "header-text");

        // Input Field
        TextField inputField = new TextField();
        inputField.setPromptText("What needs to be done?");
        // Allow the text field to grow horizontally
        HBox.setHgrow(inputField, Priority.ALWAYS);

        // Add Button
        Button addButton = new Button("Add");
        addButton.getStyleClass().add(Styles.ACCENT); // AtlantaFX style: Blue/Accent color
        addButton.setDefaultButton(true); // Pressing 'Enter' triggers this

        // Input Container (Field + Button)
        HBox inputBox = new HBox(10, inputField, addButton);
        inputBox.setAlignment(Pos.CENTER_LEFT);

        // Task List
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        VBox.setVgrow(listView, Priority.ALWAYS); // Fill available vertical space

        // Bottom Action Buttons
        Button deleteBtn = new Button("Delete Selected");
        deleteBtn.getStyleClass().add(Styles.DANGER); // AtlantaFX style: Red/Danger color

        Button printBtn = new Button("Print All");
        printBtn.getStyleClass().add(Styles.SUCCESS); // AtlantaFX style: Green/Success color

        HBox actionBox = new HBox(10, deleteBtn, printBtn);
        actionBox.setAlignment(Pos.CENTER);

        // --- 2. Logic/Events ---

        addButton.setOnAction(e -> {
            String text = inputField.getText();
            if (text != null && !text.isBlank()) {
                listView.getItems().add(text);
                inputField.clear();
            }
        });

        deleteBtn.setOnAction(e -> {
            int selectedIdx = listView.getSelectionModel().getSelectedIndex();
            if (selectedIdx != -1) {
                listView.getItems().remove(selectedIdx);
            }
        });

        printBtn.setOnAction(e -> {
            System.out.println("--- Current Todo List ---");
            listView.getItems().forEach(System.out::println);
            System.out.println("-------------------------");
        });

        // --- 3. Layout Assembly ---

        VBox root = new VBox(20, header, inputBox, listView, actionBox);
        root.setPadding(new Insets(30)); // Add breathing room around the edges
        root.setAlignment(Pos.TOP_CENTER);
        root.getStyleClass().add("app-root"); // Hook for CSS

        // Use a smaller window size for a "Minimalist" feel
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
