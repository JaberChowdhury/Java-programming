import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * A complete, self-contained To-Do List application built using Java Swing.
 * This version uses the Nimbus Look and Feel for a modern appearance on all operating systems (including Linux).
 */
public class SimpleSwingApp {

    // Core Swing components
    private JFrame frame;
    private DefaultListModel<String> listModel; // Data model for the JList
    private JList<String> taskList; // Displays the tasks
    private JTextField taskInput; // Input field for new tasks
    private JButton addButton; // Button to add tasks
    private JButton removeButton; // Button to complete/remove tasks

    /**
     * Constructor sets up all GUI components and listeners.
     */
    public SimpleSwingApp() {
        // 1. Initialize Frame and Data Model (L&F is set in main method)
        frame = new JFrame("Simple Swing To-Do App (Nimbus L&F)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Use a simple selection mode
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Customizations for font/height are kept but the L&F will style the rest
        taskList.setFont(new Font("SansSerif", Font.PLAIN, 14));
        taskList.setFixedCellHeight(30);

        taskInput = new JTextField(25);
        addButton = new JButton("Add New Task");
        removeButton = new JButton("Mark Selected as Complete");

        // 2. Set up Layouts and Panels

        // Panel for input field and add button (at the top)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        // Use JScrollPane for the task list so it can scroll if tasks overflow
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Panel for the remove button (at the bottom)
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        controlPanel.add(removeButton);

        // Main Frame Layout (BorderLayout is great for North/Center/South structure)
        frame.setLayout(new BorderLayout(15, 15)); // Add visual gaps

        // Add padding around the main content area
        ((JComponent) frame.getContentPane()).setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // 3. Add Event Listeners

        // Both clicking the button or pressing Enter in the text field adds a task
        addButton.addActionListener(new AddTaskListener());
        taskInput.addActionListener(new AddTaskListener());

        removeButton.addActionListener(new RemoveTaskListener());

        // 4. Final Frame Configuration
        frame.setSize(550, 450);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);

        // Add an initial placeholder task
        listModel.addElement("Welcome! Type a task above and press 'Add'.");
    }

    /**
     * ActionListener to handle adding a new task.
     */
    private class AddTaskListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String task = taskInput.getText().trim();

            // Only add the task if the input field is not empty
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskInput.setText(""); // Clear the input field for the next task
            }
        }
    }

    /**
     * ActionListener to handle removing the selected task (marking it as complete).
     */
    private class RemoveTaskListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the index of the currently selected item
            int selectedIndex = taskList.getSelectedIndex();

            if (selectedIndex != -1) {
                // Remove the selected item from the data model
                listModel.remove(selectedIndex);
            } else {
                // Inform the user if nothing is selected
                JOptionPane.showMessageDialog(
                    frame,
                    "Please select a task from the list to mark as complete.",
                    "No Task Selected",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        }
    }

    /**
     * Main method: sets the Look and Feel and runs the application on the EDT.
     */
    public static void main(String[] args) {
        // We are using Nimbus because it is a modern, cross-platform L&F that is built-in,
        // which avoids the native look of Arch Linux/GTK.
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println(
                "Could not set Nimbus L&F. Falling back to default."
            );
        }

        // Run the application on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new SimpleSwingApp());
    }
}
