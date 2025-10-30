import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CounterApp extends JFrame {

    private static final Color COLOR_BACKGROUND = new Color(0xFF, 0xFF, 0xFF);
    private static final Color COLOR_TEXT_PRIMARY = new Color(0x09, 0x09, 0x0B);

    private int count = 0;
    private JLabel counterLabel;

    public CounterApp() {
        setTitle("Swing Counter App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBackground(COLOR_BACKGROUND);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        counterLabel = new JLabel(String.valueOf(count));
        counterLabel.setFont(new Font("SansSerif", Font.BOLD, 80));
        counterLabel.setForeground(COLOR_TEXT_PRIMARY);
        counterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(counterLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(COLOR_BACKGROUND);

        StyledButton incrementButton = new StyledButton("+1");
        StyledButton decrementButton = new StyledButton("-1");
        StyledButton increment5Button = new StyledButton("+5");
        StyledButton decrement5Button = new StyledButton("-5");

        buttonPanel.add(incrementButton);
        buttonPanel.add(decrementButton);
        buttonPanel.add(increment5Button);
        buttonPanel.add(decrement5Button);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        incrementButton.addActionListener(e -> updateCount(1));
        decrementButton.addActionListener(e -> updateCount(-1));
        increment5Button.addActionListener(e -> updateCount(5));
        decrement5Button.addActionListener(e -> updateCount(-5));

        add(mainPanel);
    }

    private void updateCount(int amount) {
        this.count += amount;
        this.counterLabel.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            new Runnable() {
                @Override
                public void run() {
                    new CounterApp().setVisible(true);
                }
            }
        );
    }

    public static class StyledButton extends JButton {

        private static final Color COLOR_BUTTON_PRIMARY_BG = new Color(
            0x18,
            0x18,
            0x1B
        );
        private static final Color COLOR_BUTTON_PRIMARY_HOVER_BG = new Color(
            0x27,
            0x27,
            0x2A
        );
        private static final Color COLOR_BUTTON_PRIMARY_TEXT = new Color(
            0xFA,
            0xFA,
            0xFA
        );

        public StyledButton(String text) {
            super(text);
            setFont(new Font("SansSerif", Font.BOLD, 16));
            setForeground(COLOR_BUTTON_PRIMARY_TEXT);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);

            setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            if (getModel().isPressed()) {
                g2.setColor(COLOR_BUTTON_PRIMARY_BG.darker());
            } else if (getModel().isRollover()) {
                g2.setColor(COLOR_BUTTON_PRIMARY_HOVER_BG);
            } else {
                g2.setColor(COLOR_BUTTON_PRIMARY_BG);
            }

            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);

            g2.dispose();

            super.paintComponent(g);
        }
    }
}
