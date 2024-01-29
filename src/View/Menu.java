package View;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    private IO io = new IO();

    public int userAuth() {
        String title = "E-Wallet KopiPaste";
        String[] Menu = { "Register", "Login", "Keluar" };
        int selectedOption = io.getMenuUserInput(title, Menu);
        io.cls();
        return selectedOption;
    }

    public int mainMenu() {
        String title = "HOME";
        String[] Menu = { "TopUp", "Transfer", "Payment", "History", "Profile", "Logout" };
        int selectedOption = io.getMenuUserInput(title, Menu);
        io.cls();
        return selectedOption;
    }

    public int paymentMenu() {
        String title = "PAYMENT";
        String[] Menu = { "PULSA", "TOKEN LISTRIK", "Back" };
        int selectedOption = io.getMenuUserInput(title, Menu);
        io.cls();
        return selectedOption;
    }

    public int pulsa(int[] amount) {
        String title = "PULSA";
        List<String> menu = Arrays.stream(amount)
                .mapToObj(i -> "Rp. " + i)
                .collect(Collectors.toList());
        menu.add("Cancel");
        int selectedOption = io.getMenuUserInput(title, menu.toArray(new String[0]));
        io.cls();
        return selectedOption;
    }

    public int tokenListrik(int[] amount) {
        String title = "TOKEN LISTRIK";
        List<String> menu = Arrays.stream(amount)
                .mapToObj(i -> "Rp. " + i)
                .collect(Collectors.toList());
        menu.add("Cancel");
        int selectedOption = io.getMenuUserInput(title, menu.toArray(new String[0]));
        io.cls();
        return selectedOption;
    }

    public int historyMenu() {
        String title = "HISTORY";
        String[] Menu = { "Lihat Semua History", "Lihat History Masuk", "Lihat History Keluar", "Back" };
        int selectedOption = io.getMenuUserInput(title, Menu);
        io.cls();
        return selectedOption;
    }

    
    public int profileMenu() {
        String title = "PROFILE";
        String[] Menu = { "Edit Profile", "Cancel" };
        int selectedOption = io.getMenuUserInput(title, Menu);
        io.cls();
        return selectedOption;
    }

    public int editProfileMenu() {
        String title = "EDIT PROFILE";
        String[] Menu = { "Name", "Address", "Email", "Password", "Back" };
        int selectedOption = io.getMenuUserInput(title, Menu);
        io.cls();
        return selectedOption;
    }


}
