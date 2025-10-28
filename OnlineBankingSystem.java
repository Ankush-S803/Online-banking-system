import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private int pin;
    private double balance;

    public BankAccount(String accountHolder, int pin, double initialBalance) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! " + amount + " added.");
            checkBalance();
        } else {
            System.out.println("Invalid amount. Deposit must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be positive.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! " + amount + " deducted.");
            checkBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class OnlineBankingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount("Arpita Singh", 2710, 20000.0);

        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        boolean isAuthenticated = false;

        System.out.println("Welcome to Online Banking System");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your 4-digit PIN: ");
            int enteredPin = readIntInput(sc);
            if (account.verifyPin(enteredPin)) {
                System.out.println("\nLogin successful!");
                System.out.println("Welcome, " + account.getAccountHolder() + "!");
                isAuthenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        if (isAuthenticated) {
            int choice;
            do {
                System.out.println("\nMain Menu\n");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = readIntInput(sc);

                switch (choice) {
                    case 1:
                        account.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmt = readDoubleInput(sc);
                        account.deposit(depositAmt);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = readDoubleInput(sc);
                        account.withdraw(withdrawAmt);
                        break;
                    case 4:
                        System.out.println("Thank you, " + account.getAccountHolder() + ", for using Online Banking!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Account locked due to multiple incorrect PIN attempts.");
        }

        sc.close();
    }

    private static int readIntInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
                sc.next();
            }
        }
    }

    private static double readDoubleInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid amount: ");
                sc.next();
            }
        }
    }
}
