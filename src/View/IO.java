package View;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class IO {

    private Scanner input = new Scanner(System.in);
    private Console console = System.console();

    public void print(String text) {
        System.out.println(text);
    }

    public String getUserInput(String text) {
        System.out.print(text);
        return input.nextLine();
    }

    public String getPasswordInput(String text) {
        if (console == null) {
            System.err.println("Error: Console not available");
            System.exit(1);
        }
        return new String(console.readPassword(text));
    }

    public int getMenuUserInput(String title, String[] menuOptions) {

        String leftAlignFormat = "| %-30s |%n";

        System.out.format("+--------------------------------+%n");
        System.out.format(leftAlignFormat, centerText(title, 30));
        System.out.format("+--------------------------------+%n");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.format(leftAlignFormat, i + 1 + ". " + menuOptions[i]);
        }
        System.out.format("+--------------------------------+%n");

        while (true) {
            System.out.print("| -> ");
            try {
                int userInput = Integer.parseInt(input.nextLine());
                if (userInput >= 1 && userInput <= menuOptions.length) {
                    return userInput;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    public String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return String.format("%" + (padding + text.length()) + "s", text);
    }
}