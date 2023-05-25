import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JPanel {
    private JFrame frame;

    public WelcomePage(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        // SAVINGS BUTTON
        JButton savingsButton = new JButton("Savings");
        savingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountPage("Savings");
            }
        });
        buttonPanel.add(savingsButton);

        // CURRENT BUTTON
        JButton currentButton = new JButton("Current");
        currentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountPage("Current");
            }
        });
        buttonPanel.add(currentButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void showAccountPage(String accountType) {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        if (accountType.equals("Savings")) {
            SavingsPage savingsPage = new SavingsPage(frame);
            frame.getContentPane().add(savingsPage);

        } else if (accountType.equals("Current")) {
            CurrentPage currentPage = new CurrentPage(frame);
            frame.getContentPane().add(currentPage);
        }

        frame.setVisible(true);
    }
}
