import Controller.*;
import Model.Data.*;
import Node.*;

public class Main {
    public static void main(String[] args) {
        AccountController accountController = new AccountController();

        accountController.userAuth();
    }
}