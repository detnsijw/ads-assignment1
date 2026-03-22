import java.util.Scanner;

public class Task4 {
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;

        return n * factorial(n - 1);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n));
    }
}
