package ads.a2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BankAccount{
    String accountNumber;
    String username;
    double balance;
    public BankAccount(String accountNumber, String username, double balance){
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
    @Override
    public String toString(){
        return username+" - Balance: "+balance;
    }
}
public class Main{
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> transactionHistory = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequests = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        runTask6();
        while (true){
            System.out.println("\n1 - Enter Bank\n2 - Enter ATM\n3 - Admin Area\n4 - Exit");
            int choice = scanner.nextInt();
            if (choice==1) bankMenu();
            else if (choice==2) atmMenu();
            else if (choice==3) adminMenu();
            else if (choice==4) break;
        }
    }
    static void runTask6(){
        BankAccount[] initialAccounts = new BankAccount[3];
        initialAccounts[0] = new BankAccount("101", "Ali", 150000);
        initialAccounts[1] = new BankAccount("102", "Sara", 220000);
        initialAccounts[2] = new BankAccount("103", "Zaid", 10000);
        System.out.println("Physical Array Predefined Accounts:");
        for (BankAccount acc : initialAccounts){
            System.out.println(acc);
            accounts.add(acc);
        }
    }
    static BankAccount findAccount(String username){
        for (BankAccount acc : accounts){if (acc.username.equalsIgnoreCase(username)) return acc;}
        return null;
    }
    static void bankMenu(){
        while (true){
            System.out.println("\nBank Menu");
            System.out.println("1. Submit account opening request");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Add bill payment");
            System.out.println("5. View last transaction");
            System.out.println("6. Undo last transaction");
            System.out.println("7. Back");
            int choice = scanner.nextInt();
            if (choice==1){
                System.out.print("Enter Account Number: ");
                String accNum = scanner.next();
                System.out.print("Enter Username: ");
                String name = scanner.next();
                System.out.print("Enter Initial Balance: ");
                double bal = scanner.nextDouble();
                accountRequests.add(new BankAccount(accNum, name, bal));
                System.out.println("Account request submitted to queue.");
            }else if (choice==2){
                System.out.print("Enter username: ");
                BankAccount acc = findAccount(scanner.next());
                if (acc!=null){
                    System.out.print("Deposit: ");
                    double amt = scanner.nextDouble();
                    acc.balance+=amt;
                    transactionHistory.push("Deposit "+amt+" to "+acc.username);
                    System.out.println("New balance: "+acc.balance);
                }else{
                    System.out.println("Account not found.");
                }
            }else if (choice==3){
                System.out.print("Enter username: ");
                BankAccount acc = findAccount(scanner.next());
                if (acc!=null){
                    System.out.print("Withdraw: ");
                    double amt = scanner.nextDouble();
                    if (acc.balance>=amt){
                        acc.balance-=amt;
                        transactionHistory.push("Withdraw "+amt+" from "+acc.username);
                        System.out.println("New balance: "+acc.balance);
                    }else{System.out.println("Insufficient funds.");}
                }else{System.out.println("Account not found.");}
            }else if (choice==4){
                System.out.print("Enter Bill Name: ");
                String bill = scanner.next();
                billQueue.add(bill);
                transactionHistory.push("Bill payment request: "+bill);
                System.out.println("Added: "+bill);
            }else if (choice==5){
                if (!transactionHistory.isEmpty()){
                    System.out.println("Last transaction: "+transactionHistory.peek());
                }else{System.out.println("No transactions.");}
            }else if (choice==6){
                if (!transactionHistory.isEmpty()){
                    System.out.println("Undo -> "+transactionHistory.pop()+" removed");
                }else{System.out.println("No transactions.");}
            }else if (choice==7){break;}
        }
    }
    static void atmMenu(){
        while (true){
            System.out.println("\nATM Menu");
            System.out.println("1. Balance enquiry");
            System.out.println("2. Withdraw");
            System.out.println("3. Back");
            int choice = scanner.nextInt();
            if (choice==1){
                System.out.print("Enter username: ");
                BankAccount acc = findAccount(scanner.next());
                if (acc!=null){System.out.println("Balance: "+acc.balance);
                }else{System.out.println("Account not found.");}
            }else if (choice==2){
                System.out.print("Enter username: ");
                BankAccount acc = findAccount(scanner.next());
                if (acc!=null){
                    System.out.print("Withdraw: ");
                    double amt = scanner.nextDouble();
                    if (acc.balance>=amt){
                        acc.balance-=amt;
                        transactionHistory.push("Withdraw "+amt+" from "+acc.username);
                        System.out.println("New balance: "+acc.balance);
                    }else{System.out.println("Insufficient funds.");
                    }
                }else{System.out.println("Account not found.");
                }
            }else if (choice==3){break;}
        }
    }
    static void adminMenu(){
        while (true){
            System.out.println("\nAdmin Menu");
            System.out.println("1. View and process account queue");
            System.out.println("2. View and process bill payment queue");
            System.out.println("3. Display all accounts");
            System.out.println("4. Search account by username");
            System.out.println("5. Back");
            int choice = scanner.nextInt();
            if (choice==1){
                System.out.println("Pending requests:");
                for (BankAccount req : accountRequests){System.out.println(req);}
                if (!accountRequests.isEmpty()){
                    BankAccount newAcc = accountRequests.poll();
                    accounts.add(newAcc);
                    System.out.println("Account added successfully: "+newAcc);
                }else{System.out.println("No pending requests.");}
            }else if (choice==2){
                System.out.println("Remaining Bills:");
                for (String bill : billQueue){System.out.println(bill);}
                if (!billQueue.isEmpty()){
                    System.out.println("Processing: "+billQueue.poll());
                    System.out.println("Remaining in queue: "+billQueue);
                }else{System.out.println("No pending bills.");}
            }else if (choice==3){
                System.out.println("Accounts List:");
                for (int i=0; i<accounts.size(); i++){System.out.println((i+1)+". "+accounts.get(i));}
            }else if (choice==4){
                System.out.print("Enter username to search: ");
                BankAccount acc = findAccount(scanner.next());
                if (acc!=null){System.out.println("Found: "+acc);
                }else{System.out.println("Account not found.");}
            }else if (choice==5){break;}
        }
    }
}
