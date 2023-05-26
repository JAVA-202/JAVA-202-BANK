import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JPanel {
    private static final String default_pin = "5555";
    private static int loginAttempts = 3;

    private JFrame frame;
    private JTextField pinField;

    public FirstPage(JFrame frame) {
        this.frame = frame;
        setLayout(new FlowLayout());

        JLabel pinLabel = new JLabel("Enter your PIN:");
        pinField = new JTextField(10);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPin = pinField.getText();
                // note that string values are compared using '==', not 'equals()'
                if (enteredPin.equals(default_pin)) {
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

        LandingPage landingPage = new LandingPage(frame);
        frame.getContentPane().add(landingPage);

        frame.setVisible(true);
    }
}
