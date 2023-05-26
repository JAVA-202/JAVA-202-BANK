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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

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
        currentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountPage("Current");
            }
        });

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1.0;
            buttonPanel.add(Box.createVerticalGlue(), gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
            buttonPanel.add(savingsButton, gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
            buttonPanel.add(currentButton, gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
            buttonPanel.add(Box.createVerticalGlue(), gbc);

            add(buttonPanel, BorderLayout.CENTER);

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
