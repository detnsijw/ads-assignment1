package assignment1;

import java.util.Scanner;

public class Classwork {
    public static void reverse(int n, int[] arr)  {
        if (n == 0) return;

        System.out.println(arr[n - 1]);
        reverse(n - 1, arr);
    }

    static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        reverse(n, arr);
    }
}
