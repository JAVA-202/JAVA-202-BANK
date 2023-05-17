import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JPanel {
    private JFrame frame;
    private LandingPage landingPage;

    public WelcomePage(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Bank App!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);

        JButton goToLoginPageButton = new JButton("Go to Landing Page");
        goToLoginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLandingPage();
            }
        });
        add(goToLoginPageButton, BorderLayout.SOUTH);
    }

    private void showLandingPage() {
        // this just clears the previous frame, and add the new components to it
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        // calling the landing page. already initialized at the top of the code
        landingPage = new LandingPage(frame);
        frame.getContentPane().add(landingPage);

        frame.setVisible(true);
    }
}
