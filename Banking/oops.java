package Banking;
import java.util.Scanner;
import java.util.ArrayList;


class Customer {

    private static int nextAccountNumber = 1001;
    private int accountNumber;
    private String name;
    private double balance;
    private String accountType;
    private String email;

    public Customer(String name, double balance, String accountType, String email) {
        this.accountNumber = nextAccountNumber++;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Bank {
    private ArrayList<Customer> customers;

    Bank() {
        customers = new ArrayList<>();
    }

    public void createAccount(String name, double balance, String accountType, String email) {
        Customer c = new Customer(name, balance, accountType, email);
        customers.add(c);
        System.out.println("Account created successfully. Account Number: " + c.getAccountNumber());
    }

    public Customer searchCustomer(int accountNumber) {
        for (Customer c : customers) {
            if (c.getAccountNumber() == accountNumber) {
                return c;
            }
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        Customer c = searchCustomer(accountNumber);
        if (c != null) {
            c.setBalance(c.getBalance() + amount);
            System.out.println("Amount deposited. New balance: " + c.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Customer c = searchCustomer(accountNumber);
        if (c != null) {
            if (c.getBalance() >= amount) {
                c.setBalance(c.getBalance() - amount);
                System.out.println("Amount withdrawn. New balance: " + c.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void enquiry(int accountNumber) {
        Customer c = searchCustomer(accountNumber);
        if (c != null) {
            System.out.println("Account Number: " + c.getAccountNumber());
            System.out.println("Name: " + c.getName());
            System.out.println("Balance: " + c.getBalance());
            System.out.println("Account Type: " + c.getAccountType());
            System.out.println("Email: " + c.getEmail());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(int fromAcc, int toAcc, double amount) {
        Customer from = searchCustomer(fromAcc);
        Customer to = searchCustomer(toAcc);
        if (from == null || to == null) {
            System.out.println("One or both accounts not found.");
            return;
        }
        if (from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            System.out.println("Transfer successful. New balance of " + from.getName() + ": " + from.getBalance());
        } else {
            System.out.println("Insufficient balance in sender's account.");
        }
    }

    public void displayAll() {
        if (customers.isEmpty()) {
            System.out.println("No customers to display.");
            return;
        }
        for (Customer c : customers) {
            System.out.println("Account Number: " + c.getAccountNumber());
            System.out.println("Name: " + c.getName());
            System.out.println("Balance: " + c.getBalance());
            System.out.println("Account Type: " + c.getAccountType());
            System.out.println("Email: " + c.getEmail());
        }
    }
}

public class oops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        int acc; 
        while (true) {
            System.out.println(
                    "\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Enquiry\n5. Transfer\n6. Search by Account Number\n7. Display All\n8. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Account Type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    bank.createAccount(name, bal, type, email);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    acc = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double dep = sc.nextDouble();
                    bank.deposit(acc, dep);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    acc = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double wd = sc.nextDouble();
                    bank.withdraw(acc, wd);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    acc = sc.nextInt();
                    bank.enquiry(acc);
                    break;
                case 5:
                    System.out.print("Enter Sender Account Number: ");
                    int from = sc.nextInt();
                    System.out.print("Enter Receiver Account Number: ");
                    int to = sc.nextInt();
                    System.out.print("Enter Amount to Transfer: ");
                    double amt = sc.nextDouble();
                    bank.transfer(from, to, amt);
                    break;
                case 6:
                    System.out.print("Enter Account Number to Search: ");
                    acc = sc.nextInt();
                    Customer c = bank.searchCustomer(acc);
                    if (c != null) {
                        System.out.println("Account found: " + c.getName() + ", Balance: " + c.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 7:
                    bank.displayAll();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
