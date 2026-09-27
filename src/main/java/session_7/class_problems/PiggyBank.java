package session_7.class_problems;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: Amount must be greater than 0");
        } else {
            this.savings += amount;
            System.out.println("Deposited " + amount + " -> savings = " + this.savings);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be greater than 0");
        } else if (amount > this.savings) {
            System.out.println("Withdrawal rejected: Insufficient savings, stays " + this.savings);
        } else {
            this.savings -= amount;
            System.out.println("Withdrew " + amount + " -> savings = " + this.savings);
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}