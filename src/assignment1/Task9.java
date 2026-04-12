package assignment1;

import java.util.Scanner;

public class Task9 {
    public static int len(String s, int index) {
        if (index < 0) return 0;
        char c = s.charAt(index);

        return 1 + len(s, index - 1);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(len(s, s.length() - 1));
    }
}
