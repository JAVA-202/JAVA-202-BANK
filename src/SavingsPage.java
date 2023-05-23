import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavingsPage extends JPanel {

    private JFrame frame;

    public SavingsPage(JFrame frame) {
             this.frame = frame;
            setLayout(new FlowLayout());

            JLabel savingsLabel = new JLabel("SAVINGS ACCOUNT");
            setSize(400, 400);
            JButton depositButton = new JButton("DEPOSIT ");
            JButton withdrawalButton = new JButton("WITHDRAW");



        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDepositPage();
            }
        });
        add(depositButton);
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
    }

