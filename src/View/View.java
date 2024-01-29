package View;

import java.util.ArrayList;

import Node.*;

public class View {
    private IO io = new IO();

    public void userWallet(Account user) {
        String leftAlignFormat = "| %-30s |%n";

        System.out.format("+--------------------------------+%n");
        System.out.format(leftAlignFormat, io.centerText(user.getPhone(), 30));
        System.out.format(leftAlignFormat, io.centerText("Halo , " + user.getName() + " !", 30));
        System.out.format(leftAlignFormat,
                io.centerText("Saldo Rp. " + String.valueOf(user.getWallet().getBalance()), 30));
    }

    public void userHistory(ArrayList<Transaction> listTransaction) {
        String leftAlignFormat = "| %-30s |%n";

        System.out.format("+--------------------------------+%n");
        for (Transaction transaction : listTransaction) {
            System.out.format(leftAlignFormat, "Transaction Id : " + transaction.getId(), 30);
            if (transaction.getName() != null) {
                System.out.format(leftAlignFormat, "Transaction name : " + transaction.getName(), 30);
            }
            System.out.format(leftAlignFormat, "Amount : " + transaction.getAmount(), 30);
            System.out.format(leftAlignFormat, "Date   : " + transaction.getTime(), 30);
            System.out.format(leftAlignFormat, "Action : " + transaction.getAction(), 30);
            System.out.format(leftAlignFormat, "Type Transaction : " + transaction.getType(), 30);
            System.out.format("+--------------------------------+%n");
        }

    }

    public void userProfile(Account user) {
        String leftAlignFormat = "| %-30s |%n";
        System.out.format("+--------------------------------+%n");
        System.out.format(leftAlignFormat, "Nama   : " + user.getName(), 30);
        System.out.format(leftAlignFormat, "Alamat : " + user.getAddress(), 30);
        System.out.format(leftAlignFormat, "Email  : " + user.getEmail(), 30);
    }

    public void Bank(ArrayList<Bank> listBank) {
        String leftAlignFormat = "| %-40s |%n";
        System.out.format("+------------------------------------------+%n");
        System.out.format(leftAlignFormat, io.centerText("Pilih Bank", 40), 40);
        System.out.format("+------------------------------------------+%n");
        for (Bank bank : listBank) {
            System.out.format(leftAlignFormat,
                    (listBank.indexOf(bank) + 1) + ". " + bank.getCode() + " - " + bank.getName(), 40);

        }
        System.out.format("+------------------------------------------+%n");

    }
}
