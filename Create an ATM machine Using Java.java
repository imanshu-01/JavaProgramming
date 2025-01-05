import java.util.Scanner;
class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin) {
        this.balance = balance; // Fixed typo: 'ballance' to 'balance'
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");
        System.out.println("5. Exit");
    }

    public void deposit(int amount) { // Changed method name to lowercase
        balance += amount;
    }

    public void withdraw(int amount) { // Changed method name to lowercase
        if (balance < amount) {
            System.out.println("Insufficient Funds");
            return;
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public boolean validatePin(int pin) { // Changed parameter name to lowercase
        return this.pin == pin; // Fixed variable name to match the class variable
    }

    public void changePin(int newPin) { // Changed method name to lowercase
        this.pin = newPin; // Fixed variable name to match the class variable
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in) // Use Scanner for input
        ) {
            ATM atm = new ATM(1000, 1234); // Fixed instantiation
            atm.displayMenu();
            System.out.print("Enter the Pin: ");
            int pin = Integer.parseInt(scanner.nextLine()); // Changed to use Scanner
            if (atm.validatePin(pin)) {
                int option = 0;
                while (option != 5) {
                    atm.displayMenu();
                    option = Integer.parseInt(scanner.nextLine()); // Changed to use Scanner
                    switch (option) {
                        case 1 -> System.out.println("Balance: " + atm.getBalance());
                            
                        case 2 -> {
                            System.out.print("Enter Amount: ");
                            int amount = Integer.parseInt(scanner.nextLine()); // Changed to use Scanner
                            atm.deposit(amount);
                        }
                            
                        case 3 -> {
                            System.out.print("Enter Amount: ");
                            int amount = Integer.parseInt(scanner.nextLine()); // Changed to use Scanner
                            atm.withdraw(amount);
                        }
                            
                        case 4 -> {
                            System.out.print("Enter New Pin: ");
                            int newPin = Integer.parseInt(scanner.nextLine()); // Changed to use Scanner
                            atm.changePin(newPin);
                        }
                            
                        case 5 -> System.out.println("Thank you for using ATM!");
                            
                        default -> System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("You have entered an Invalid Pin");
            }
            // Close the scanner
        } // Fixed instantiation
    }
}