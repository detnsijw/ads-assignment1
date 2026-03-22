import java.util.Scanner;

public class Task7 {
    public static int reverse(int n, int[] arr) {
        if (n == 0) return arr[0];

        System.out.println(arr[n]);
        return reverse(n - 1, arr);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(reverse(n - 1, arr));
    }
}
