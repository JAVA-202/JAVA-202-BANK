import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountType extends JPanel{
    private JFrame frame;

    public AccountType(JFrame frame){
        this.frame = frame;
        setLayout(new FlowLayout());

        JLabel selectAccountLabel = new JLabel("SELECT ACCOUNT TYPE");
        setSize(400,400);
        JButton savingButton = new JButton("SAVING ACCOUNT ");
        JButton currentButton = new JButton("CURRENT ACCOUNT");

        savingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // perfoms actions for saving account
//                JOptionPane.showMessageDialog(frame,"YOU HAVE SELECTED SAVING ACCOUNT.");
                // TODO:Implement actions for saving account
                showSavingsPage();
            }
        });

        currentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // perfoms actions for current account
                JOptionPane.showMessageDialog(frame,"YOUR HAVE SELECTED CURRENT ACCOUNT");
                // TODO:Implemnt actions for current account
            }
        });

        add(selectAccountLabel);
        add(savingButton);
        add(currentButton);

    }

    private void showSavingsPage(){
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();


        SavingsPage savingsPage = new SavingsPage(frame);
        frame.getContentPane().add(savingsPage);
        frame.setVisible(true);
    }

}