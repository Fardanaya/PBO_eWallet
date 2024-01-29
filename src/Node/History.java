package Node;

import java.util.ArrayList;

public class History {
    ArrayList<Transaction> listTransaction;

    public History() {
        listTransaction = new ArrayList<>();
    }

    public ArrayList<Transaction> getListTransaction() {
        return listTransaction;
    }

    public void addTransaction(Transaction transaction) {
        listTransaction.add(transaction);
    }
}
