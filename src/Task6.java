import java.util.Scanner;

public class Task6 {
    public static int power(int n, int p) {
        if (p == 0) return 1;

        return n * power(n, p - 1);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        System.out.println(power(n, p));
    }
}
