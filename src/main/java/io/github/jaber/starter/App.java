package io.github.jaber.starter;

import atlantafx.base.theme.CupertinoDark;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(
            new CupertinoDark().getUserAgentStylesheet()
        );

        // --- 1. Fix Screen Dimensions (Use Double, not Int) ---
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double width = screenBounds.getWidth();
        double height = screenBounds.getHeight();

        // --- 2. Fix Text (Convert numbers to String) ---
        Text showWidth = new Text("Width: " + width);
        Text showHeight = new Text("Height: " + height);

        // --- 3. Create Data (Use ObservableList, not ArrayList) ---
        // JavaFX needs "ObservableList" to track changes automatically.
        ObservableList<User> users = FXCollections.observableArrayList(
            new User("Jaber", 22, 5000.00, true),
            new User("Bob", 22, 5000.00, true),
            new User("Orbit", 22, 5000.00, false),
            new User("Sifat", 22, 5000.00, true),
            new User("Hopes", 122, 25000.00, false)
        );

        // --- 4. Setup Table ---
        TableView<User> table = new TableView<>();

        // DEFINE COLUMNS (The missing part!)
        TableColumn<User, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<User, Double> salaryCol = new TableColumn<>("Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<User, Boolean> activeCol = new TableColumn<>("Active");
        activeCol.setCellValueFactory(new PropertyValueFactory<>("isActive"));
        activeCol.setCellFactory(CheckBoxTableCell.forTableColumn(activeCol));

        // Add columns and data to table
        table.getColumns().addAll(nameCol, ageCol, salaryCol, activeCol);
        table.setItems(users); // <--- Crucial step!

        // --- 5. Layout ---
        VBox root = new VBox(10, showWidth, showHeight, table);
        root.setPadding(new Insets(20));

        // Make the table grow to fill the screen
        VBox.setVgrow(table, Priority.ALWAYS);

        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Data Table Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
