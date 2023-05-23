import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPage extends JPanel {

    private JFrame frame;
    public DepositPage(JFrame frame) {
        JLabel depositLabel = new JLabel("ENTER THE AMOUNT:");
        JTextField depositField = new JTextField(10);
        JButton depositButton = new JButton("DEPOSIT");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(depositLabel);
        add(depositField);
        add(depositButton);
    }
}
