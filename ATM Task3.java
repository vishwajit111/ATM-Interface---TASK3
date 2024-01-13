import java.util.Scanner;

public class ATM {

    private static final int BALANCE_ENQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int QUIT = 4;

    private int balance;

    public ATM(int balance) {
        this.balance = balance;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("ATM Interface");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Withdrawal");
            System.out.println("3. Deposit");
            System.out.println("4. Quit");
            System.out.println("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case BALANCE_ENQUIRY:
                    balanceEnquiry();
                    break;
                case WITHDRAWAL:
                    withdrawal(scanner);
                    break;
                case DEPOSIT:
                    deposit(scanner);
                    break;
                case QUIT:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        } while (option != QUIT);
    }

    private void balanceEnquiry() {
        System.out.println("Your current balance is: " + balance);
    }

    private void withdrawal(Scanner scanner) {
        System.out.println("Enter the amount you want to withdraw: ");
        int amount = scanner.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Your new balance is: RS." + balance);
        }
    }

    private void deposit(Scanner scanner) {
        System.out.println("Enter the amount you want to deposit: ");
        int amount = scanner.nextInt();

        balance += amount;
        System.out.println("Deposit successful!");
        System.out.println("Your new balance is: RS." + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(3000);
        atm.start();
    }

    public static int getBalanceEnquiry() {
        return BALANCE_ENQUIRY;
    }

    public static int getWithdrawal() {
        return WITHDRAWAL;
    }

    public static int getDeposit() {
        return DEPOSIT;
    }

    public static int getQuit() {
        return QUIT;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
