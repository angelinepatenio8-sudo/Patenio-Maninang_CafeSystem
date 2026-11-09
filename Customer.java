public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        this("Guest", false);
    }

    public Customer(String name) {
        this(name, false);
    }

    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    public void addPoints(double amount) {
        if (amount > 0) {
            loyaltyPoints += (int) (amount / 50);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: Loyalty points cannot be negative.");
        }
    }
}