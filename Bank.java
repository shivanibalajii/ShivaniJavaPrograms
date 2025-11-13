import java.util.Scanner;


class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNo, String type, double initialBalance) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavAccount extends Account {
    SavAccount(String name, int accNo, double initialBalance) {
        super(name, accNo, "Savings", initialBalance);
    }

    void computeInterest(double rate, int years) {
        double interest = balance * Math.pow((1 + rate / 100), years) - balance;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}


class CurAccount extends Account {
    final double MIN_BALANCE = 500.0;
    final double SERVICE_CHARGE = 50.0;

    CurAccount(String name, int accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Service charge imposed: " + SERVICE_CHARGE);
        }
    }
}


public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavAccount sav = new SavAccount("Alice", 1001, 1000);
        sav.deposit(500);
        sav.computeInterest(5, 2);
        sav.withdraw(300);
        sav.displayBalance();

        System.out.println();

       
        CurAccount cur = new CurAccount("Bob", 2001, 600);
        cur.deposit(200);
        cur.withdraw(400);
        cur.displayBalance();

        sc.close();
    }
}
