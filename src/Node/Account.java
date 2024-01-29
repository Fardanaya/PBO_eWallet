package Node;

public class Account extends User {
    private String phone;
    private String password;
    private Wallet wallet;
    private History history;

    public Account(String phone, String password) {
        this.phone = phone;
        this.password = password;
        this.wallet = new Wallet();
        this.history = new History();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public History getHistory() {
        return history;
    }
}
