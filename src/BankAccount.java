import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private int defaultBalance = 100000;

    public BankAccount(int defaultBalance) {
        this.defaultBalance = defaultBalance;
    }

    public void writeTransactionToFile(String transactionType, int amount, int currentBalance) {
        try {
            FileWriter writer = new FileWriter("transaction_log.txt", true);
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);
            String transactionDetails = formattedDateTime + " - " + transactionType + ": Amount=" + amount + ", Balance=" + currentBalance + "\n";
            writer.write(transactionDetails);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
