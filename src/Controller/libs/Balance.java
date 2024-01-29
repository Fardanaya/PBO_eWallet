package Controller.libs;

import Node.*;

public class Balance {
    Account user;

    public Balance(Account user) {
        this.user = user;
    }

    public boolean validateBalance(double amount) {
        if (user.getWallet().getBalance() > amount) {
            return true;
        } else {
            return false;
        }
    }
}
