package assignment1;

import java.util.Scanner;

public class Task2 {
    public static int findSum(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + findSum(arr, n - 1);
    }

    public static double average(int a, int n) {
        return (double) a / n;
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = findSum(arr, n);
        System.out.println(average(sum, n));
    }
}
