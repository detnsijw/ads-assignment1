package assignment2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> history = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<BankAccount> requestQueue = new LinkedList<>();

        // preload
        accounts.add(new BankAccount("1", "Ali", 150000));
        accounts.add(new BankAccount("2", "Sara", 200000));

        BankService bank = new BankService(accounts, history, billQueue, requestQueue, sc);
        AtmService atm = new AtmService(accounts, sc);
        AdminService admin = new AdminService(accounts, requestQueue, billQueue, sc);

        while (true) {
            System.out.println("\n1 Bank\n2 ATM\n3 Admin\n4 Exit");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> bank.menu();
                case 2 -> atm.menu();
                case 3 -> admin.menu();
                case 4 -> System.exit(0);
            }
        }
    }
}