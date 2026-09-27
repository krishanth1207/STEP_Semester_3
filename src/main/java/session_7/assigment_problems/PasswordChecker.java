package session_7.assigment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password == null || password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc1 strength: " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2 strength: " + pc2.getStrength());
    }
}
