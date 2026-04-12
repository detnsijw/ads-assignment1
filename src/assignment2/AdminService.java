package assignment2;

import java.util.*;

public class AdminService {

    LinkedList<BankAccount> accounts;
    Queue<BankAccount> requestQueue;
    Queue<String> billQueue;
    Scanner sc;

    public AdminService(LinkedList<BankAccount> accounts,
                        Queue<BankAccount> requestQueue,
                        Queue<String> billQueue,
                        Scanner sc) {
        this.accounts = accounts;
        this.requestQueue = requestQueue;
        this.billQueue = billQueue;
        this.sc = sc;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- ADMIN ---");
            System.out.println("1 Process Account");
            System.out.println("2 Process Bill");
            System.out.println("3 Back");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> processAccount();
                case 2 -> processBill();
                case 3 -> { return; }
            }
        }
    }

    void processAccount() {
        if (requestQueue.isEmpty()) {
            System.out.println("No requests.");
            return;
        }
        accounts.add(requestQueue.poll());
    }

    void processBill() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills.");
            return;
        }
        System.out.println("Processed: " + billQueue.poll());
    }
}
