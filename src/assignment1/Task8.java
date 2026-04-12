package assignment1;

import java.util.Scanner;

public class Task8 {
    public static boolean checkDigit(String s, int index) {
        if (index < 0) return true;
        char c = s.charAt(index);
        if (c < '0' || c > '9') return false;

        return checkDigit(s, index - 1);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (checkDigit(s, s.length() - 1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
