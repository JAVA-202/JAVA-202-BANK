import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentPage extends JPanel {

    private JFrame frame;

    public CurrentPage(JFrame frame) {
        this.frame = frame;
        setLayout(new FlowLayout());

        JLabel CurrentLabel = new JLabel("Current Account");
        setSize(400, 400);
        JButton depositButton = new JButton("DEPOSIT ");
        JButton withdrawalButton = new JButton("WITHDRAW");



        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDepositPage();
            }
        });
        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWithdrawalPage();
            }
        });
        add(depositButton);
        add(withdrawalButton);
    }

    private void showDepositPage(){
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

// creating an object
        DepositPage depositPage = new DepositPage(frame);
        frame.getContentPane().add(depositPage);
        frame.setVisible(true);
    }

    private void showWithdrawalPage(){
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

// creating an object
        WithdrawalPage withdrawalPage = new WithdrawalPage(frame);
        frame.getContentPane().add(withdrawalPage);
        frame.setVisible(true);
    }
}
