package Model.Data;

import java.util.ArrayList;

import Node.*;

public class ModelBank {
    ArrayList<Bank> listBank = new ArrayList<>();

    public ArrayList<Bank> getListBank() {
        return listBank;
    }

    public Bank getBank(int index) {
        return listBank.get(index);
    }

    public void addBank(Bank bank) {
        listBank.add(bank);
    }
}
