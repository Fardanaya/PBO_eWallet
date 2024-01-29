package Controller.libs;

import Controller.libs.Transaction.TransactionType;
import Model.Data.*;
import Node.*;

public class HistoryHandler {

    Account user;
    ModelAccount modelAccount;

    public HistoryHandler(Account user, ModelAccount modelAccount) {
        this.user = user;
        this.modelAccount = modelAccount;
    }

    public void execute(Transaction transaction) {

        double currentBalance = user.getWallet().getBalance();
        if (transaction.getType() == TransactionType.OUTCOME) {
            user.getWallet().setBalance(currentBalance - transaction.getAmount());
        } else if (transaction.getType() == TransactionType.INCOME) {
            user.getWallet().setBalance(currentBalance + transaction.getAmount());
        }

        History history = user.getHistory();
        history.addTransaction(transaction);
        modelAccount.commitData();
    }
}
