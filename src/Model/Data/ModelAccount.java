package Model.Data;

import java.util.ArrayList;

import Model.JSON.ModelJSON;
import Node.Account;

import com.google.gson.reflect.TypeToken;

public class ModelAccount {

    ArrayList<Account> listAccount;
    ModelJSON<Account> ModelJSONAccount;

    public ModelAccount() {
        listAccount = new ArrayList<Account>();
        ModelJSONAccount = new ModelJSON<>("database/Account.json");
        loadData();
    }

    public ArrayList<Account> getListAccount() {
        return listAccount;
    }

    public void addAccount(Account Account) {
        listAccount.add(Account);
        commitData();
    }

    public Account getAccount(int index) {
        return listAccount.get(index);
    }

    public void updateAccount(Account Account) {
        listAccount.set(listAccount.indexOf(Account), Account);
        commitData();
    }

    public int searchAccount(String phone) {
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getPhone().equals(phone)) {
                return i;
            }
        }
        return -1;
    }

    private void loadData() {
        listAccount = ModelJSONAccount.readFromFile(new TypeToken<ArrayList<Account>>() {
        }.getType());
    }

    public void commitData() {
        ModelJSONAccount.writeToFile(listAccount);
    }
}
