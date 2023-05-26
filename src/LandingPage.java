import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandingPage extends JPanel {
    private JFrame frame;
    private LandingPage landingPage;

    public LandingPage(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("WELCOME TO THE MATRIX ");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);

        JButton goToLoginPageButton = new JButton("Proceed");
        goToLoginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLandingPage();
            }
        });
        add(goToLoginPageButton, BorderLayout.SOUTH);
    }

    private void showLandingPage() {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        WelcomePage welcomePage = new WelcomePage(frame);

        frame.getContentPane().add(welcomePage);
        frame.setVisible(true);
    }
}