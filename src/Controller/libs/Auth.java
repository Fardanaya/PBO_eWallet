package Controller.libs;

import Model.Data.ModelAccount;
import Node.Account;
import View.*;

public class Auth {
    IO io = new IO();

    public void register(ModelAccount modelAccount) {
        String phone, password, verifpass;
        io.print("REGISTER");
        do {
            phone = io.getUserInput("Phone : ");
            if (phone.length() < 10) {
                io.cls();
                io.print("Phone harus lebih dari 10 karakter. Silakan coba lagi.");
                continue;
            } else if (modelAccount.searchAccount(phone) != -1) {
                io.cls();
                io.print("Phone sudah terdaftar. Silakan coba lagi.");
                continue;
            }
        } while (phone.length() < 10 || modelAccount.searchAccount(phone) != -1);

        do {
            password = io.getPasswordInput("Password : ");
            if (password.length() < 8 || !containLetterAndDigit(password)) {
                io.cls();
                io.print("password harus lebih dari 8 karakter dan terdiri dari huruf dan angka");
                io.print("Phone : " + phone);
                continue;
            }
        } while (password.length() < 8 || !containLetterAndDigit(password));

        do {
            verifpass = io.getPasswordInput("Repeat Password : ");
            if (!password.equals(verifpass)) {
                io.cls();
                io.print("Password tidak cocok. Silakan coba lagi.");
                io.print("Phone : " + phone);
                io.print("Password : " + ("*").repeat(password.length()));
                continue;
            }
            modelAccount.addAccount(new Account(phone, password));
            io.print("Registrasi Berhasil");
        } while (!password.equals(verifpass));
    }

    public boolean containLetterAndDigit(String pass) {
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char x : pass.toCharArray()) {
            if (Character.isLetter(x)) {
                hasLetter = true;
            } else if (Character.isDigit(x)) {
                hasDigit = true;
            }
            if (hasLetter && hasDigit) {
                break;
            }
        }

        return hasLetter && hasDigit;
    }

    public Account login(ModelAccount modelAccount) {
        io.print("LOGIN");
        String phone = io.getUserInput("Phone : ");
        Account account = null;
        boolean loginSuccessful = false;

        while (!loginSuccessful) {
            String password = io.getPasswordInput("Password : ");
            int userid = modelAccount.searchAccount(phone);

            if (userid == -1) {
                io.print("User tidak ditemukan");
                phone = io.getUserInput("Phone : ");
                continue;
            }

            account = modelAccount.getAccount(userid);

            if (!password.equals(account.getPassword())) {
                io.print("Password salah");
                continue;
            }

            loginSuccessful = true;
        }

        io.print("Login Berhasil");
        return account;
    }
}
