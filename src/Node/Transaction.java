package Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Controller.libs.Transaction.ActionType;
import Controller.libs.Transaction.TransactionType;

public class Transaction {
    private String id;
    private String name;
    private double amount;
    private String time;
    // public boolean status = false;
    private ActionType action;
    private TransactionType type;

    public Transaction(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.time = time();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public ActionType getAction() {
        return action;
    }

    public TransactionType getType() {
        return type;
    }

    public void topUp() {
        this.action = ActionType.TOPUP;
        this.type = TransactionType.INCOME;
    }

    public void transferSender() {
        this.action = ActionType.TRANSFER;
        this.type = TransactionType.OUTCOME;
    }

    public void transferReceiver() {
        this.action = ActionType.TRANSFER;
        this.type = TransactionType.INCOME;
    }

    public String payment(String kode) {
        this.action = ActionType.PAYMENT;
        this.type = TransactionType.OUTCOME;
        return kode + this.id;
    }

    public void payment() {
        this.action = ActionType.PAYMENT;
        this.type = TransactionType.OUTCOME;
    }

    private String time() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return myDateObj.format(myFormatObj);
    }

    // public void confirm() {
    // this.status = true;
    // };
}
