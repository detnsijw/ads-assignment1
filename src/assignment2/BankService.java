package assignment2;

import java.util.*;

public class BankService {

    LinkedList<BankAccount> accounts;
    Stack<String> history;
    Queue<String> billQueue;
    Queue<BankAccount> requestQueue;
    Scanner sc;

    public BankService(LinkedList<BankAccount> accounts,
                       Stack<String> history,
                       Queue<String> billQueue,
                       Queue<BankAccount> requestQueue,
                       Scanner sc) {
        this.accounts = accounts;
        this.history = history;
        this.billQueue = billQueue;
        this.requestQueue = requestQueue;
        this.sc = sc;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- BANK ---");
            System.out.println("1 Add Account");
            System.out.println("2 Show Accounts");
            System.out.println("3 Search");
            System.out.println("4 Deposit");
            System.out.println("5 Withdraw");
            System.out.println("6 Add Bill");
            System.out.println("7 Back");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> addAccount();
                case 2 -> showAccounts();
                case 3 -> search();
                case 4 -> deposit();
                case 5 -> withdraw();
                case 6 -> addBill();
                case 7 -> { return; }
            }
        }
    }

    void addAccount() {
        System.out.print("Number: ");
        String num = sc.nextLine();
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Balance: ");
        double bal = Double.parseDouble(sc.nextLine());

        accounts.add(new BankAccount(num, user, bal));
        System.out.println("Added.");
    }

    void showAccounts() {
        for (BankAccount a : accounts) {
            System.out.println(a);
        }
    }

    void search() {
        System.out.print("Username: ");
        String u = sc.nextLine();

        for (BankAccount a : accounts) {
            if (a.getUsername().equalsIgnoreCase(u)) {
                System.out.println(a);
                return;
            }
        }
        System.out.println("Not found.");
    }

    void deposit() {
        BankAccount a = find();
        if (a == null) return;

        System.out.print("Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        a.deposit(amt);
        history.push("Deposit " + amt + " to " + a.getUsername());
    }

    void withdraw() {
        BankAccount a = find();
        if (a == null) return;

        System.out.print("Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        if (a.withdraw(amt)) {
            history.push("Withdraw " + amt + " from " + a.getUsername());
        } else {
            System.out.println("Not enough money.");
        }
    }

    void addBill() {
        System.out.print("Bill name: ");
        String b = sc.nextLine();
        billQueue.add(b);
    }

    BankAccount find() {
        System.out.print("Username: ");
        String u = sc.nextLine();

        for (BankAccount a : accounts) {
            if (a.getUsername().equalsIgnoreCase(u)) return a;
        }
        System.out.println("Not found.");
        return null;
    }
}
