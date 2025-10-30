import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf; // Import the FlatLaf library

/**
 * A simple Java Swing example to show how to use FlatLaf
 * to create a modern-looking application.
 *
 * To Run This:
 * 1. Download the FlatLaf JAR file (search "FlatLaf Maven" or "FlatLaf download").
 * 2. Add the flatlaf-[version].jar file to your project's classpath.
 * 3. Compile and run this file.
 */
public class ModernSwingApp {

    public static void main(String[] args) {
        // 1. Set up the FlatLaf Light Look and Feel
        // This is the single line that makes everything look modern!
        // Do this *before* creating any Swing components.
        try {
            FlatLightLaf.setup(); // Or use FlatDarkLaf.setup() for a dark theme
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        // 2. Create your Swing components (standard Swing code)
        // We use SwingUtilities.invokeLater to ensure UI updates are thread-safe.
        SwingUtilities.invokeLater(() -> {

            // Create the main window (JFrame)
            JFrame frame = new JFrame("My Final Exam Project");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a panel to hold components
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Add some spacing

            // Create components
            JLabel label = new JLabel("Welcome to my app!");
            JButton button = new JButton("Click Me");
            JTextField textField = new JTextField("You can type here", 15);
            JCheckBox checkBox = new JCheckBox("An option");

            // Add an action listener to the button
            button.addActionListener(e -> {
                // Show a modern-looking dialog box
                JOptionPane.showMessageDialog(frame, "Hello, " + textField.getText() + "!");
            });

            // Add components to the panel
            panel.add(label);
            panel.add(textField);
            panel.add(button);
            panel.add(checkBox);

            // Add the panel to the frame and make it visible
            frame.add(panel);
            frame.setLocationRelativeTo(null); // Center the window on the screen
            frame.setVisible(true);
        });
    }
}
