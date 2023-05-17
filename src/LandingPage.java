import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandingPage extends JPanel {
    private static final String DEFAULT_PIN = "5555";
    private static int loginAttempts = 3;

    private JFrame frame;
    private JTextField pinField;

    public LandingPage(JFrame frame) {
        this.frame = frame;
        setLayout(new FlowLayout());

        JLabel pinLabel = new JLabel("Enter your PIN:");
        pinField = new JTextField(10);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPin = pinField.getText();
                if (enteredPin.equals(DEFAULT_PIN)) {
                    showWelcomePage();
                } else {
                    loginAttempts--;
                    if (loginAttempts > 0) {
                        JOptionPane.showMessageDialog(frame, "Incorrect PIN. You have " + loginAttempts + " more attempts.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "You have exceeded the maximum number of attempts.");
                        System.exit(0);
                    }
                }
            }
        });

        add(pinLabel);
        add(pinField);
        add(loginButton);
    }

    private void showWelcomePage() {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        JLabel welcomeLabel = new JLabel("Welcome to the Bank App!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.getContentPane().add(welcomeLabel);

        frame.setVisible(true);
    }
}
