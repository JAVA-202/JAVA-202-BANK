import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SavingsPage extends JPanel {
    private static final int withdraw_limit = 50000;
    private static final int deposit_limit = 50000;
    private static final int default_balance = 100000;

    BankAccount bankAccount = new BankAccount(default_balance);

    private JFrame frame;
    private int currentBalance;

    public SavingsPage(JFrame frame) {
        this.frame = frame;
        this.currentBalance = default_balance;
        setLayout(new GridLayout(2, 1));

        JButton withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransaction("withdraw");
            }
        });
        add(withdrawalButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransaction("deposit");
            }
        });
        add(depositButton);
    }

    private void handleTransaction(String transactionType) {
        String amountString = JOptionPane.showInputDialog(frame, "Enter the amount:");
        if (amountString == null || amountString.isEmpty()) {
            return;
        }

        int amount = Integer.parseInt(amountString);

        if (transactionType.equals("withdraw")) {
            if (amount > withdraw_limit) {
                JOptionPane.showMessageDialog(frame, "Exceeded withdrawal limit. Please try again.");
                return;
            }

            if (amount > currentBalance) {
                JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                return;
            }

            currentBalance -= amount;


            bankAccount.writeTransactionToFile(transactionType, amount, currentBalance);
            JOptionPane.showMessageDialog(frame, "Withdrawal successful. Current balance: " + currentBalance);
            // Write withdrawal transaction details to file

            JOptionPane.showMessageDialog(frame, "Withdrawal successful. Current balance: " + currentBalance);
        } else if (transactionType.equals("deposit")) {
            if (amount > deposit_limit) {
                JOptionPane.showMessageDialog(frame, "Exceeded deposit limit. Please try again.");
                return;
            }

            currentBalance += amount;
            // Write deposit transaction details to file
            bankAccount.writeTransactionToFile(transactionType, amount, currentBalance);
            JOptionPane.showMessageDialog(frame, "Deposit successful. Current balance: " + currentBalance);
        }
    }
}
