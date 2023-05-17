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
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        LandingPage landingPage = new LandingPage(frame);
        frame.getContentPane().add(landingPage);

        frame.setVisible(true);
    }
}
