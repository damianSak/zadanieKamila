package utils;

import java.util.Scanner;

public class StringHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static String readStringFromUser() {
        String stringInput = scanner.nextLine();
        return stringInput;
    }

    public static String printMessageWithChooseOption(String communicate) {
        System.out.println(communicate);
        System.out.print(">: ");
        return StringHandler.readStringFromUser();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
