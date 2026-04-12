package assignment1;

import java.util.Scanner;

public class Task3 {
    public static boolean findPrime(int n, int div) {
        if (n <= 1) return false;
        if (div == 1) return true;
        if (n % div == 0) return false;

        return findPrime(n, div - 1);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (findPrime(n, 2)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
    }
}
