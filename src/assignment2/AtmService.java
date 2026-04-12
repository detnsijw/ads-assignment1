package assignment2;

import java.util.*;

public class AtmService {

    LinkedList<BankAccount> accounts;
    Scanner sc;

    public AtmService(LinkedList<BankAccount> accounts, Scanner sc) {
        this.accounts = accounts;
        this.sc = sc;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- ATM ---");
            System.out.println("1 Balance");
            System.out.println("2 Withdraw");
            System.out.println("3 Back");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> balance();
                case 2 -> withdraw();
                case 3 -> { return; }
            }
        }
    }

    void balance() {
        BankAccount a = find();
        if (a != null)
            System.out.println("Balance: " + a.getBalance());
    }

    void withdraw() {
        BankAccount a = find();
        if (a == null) return;

        System.out.print("Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        if (!a.withdraw(amt))
            System.out.println("Not enough.");
    }

    BankAccount find() {
        System.out.print("Username: ");
        String u = sc.nextLine();

        for (BankAccount a : accounts) {
            if (a.getUsername().equalsIgnoreCase(u)) return a;
        }
        return null;
    }
}
