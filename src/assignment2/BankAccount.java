package assignment2;

public class BankAccount {
    private String accountNumber;
    private String username;
    private double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("+" + amount);
            System.out.println("Balance:" + balance);
        } else {
            System.out.println("Unavailable amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("-" + amount);
            System.out.println("Balance:" + balance);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return username + " - Balance: " + balance;
    }
}
