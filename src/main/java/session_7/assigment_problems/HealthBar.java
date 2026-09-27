package session_7.assigment_problems;

public class HealthBar {
    private final int maxHealth;
    private int currentHealth;

    public HealthBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        this.currentHealth -= amount;
        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }
        System.out.println("Took " + amount + " damage -> health = " + this.currentHealth);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        this.currentHealth += amount;
        if (this.currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        }
        System.out.println("Healed " + amount + " -> health = " + this.currentHealth + " (capped)");
    }

    public static void main(String[] args) {
        HealthBar c = new HealthBar(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}
