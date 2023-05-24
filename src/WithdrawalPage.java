import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WithdrawalPage extends JPanel{

    private JFrame frame;
    public WithdrawalPage(JFrame frame) {
        JLabel withdrawalLabel = new JLabel("ENTER THE AMOUNT:");
        JTextField withdrawalField = new JTextField(10);
        JButton withdrawalButton = new JButton("WITHDRAW");

        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(withdrawalLabel);
        add(withdrawalField);
        add(withdrawalButton);
    }
}

