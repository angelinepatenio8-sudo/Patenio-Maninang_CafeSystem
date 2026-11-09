/**
 * Represents a pastry menu item.
 */
public class Pastry extends MenuItem {

    private boolean warmed;

    public Pastry() {
        super();
        this.warmed = false;
    }

    public Pastry(String name, double basePrice,
                  String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    @Override
    public double computePrice() {
        if (warmed) {
            return basePrice + 10;
        } else {
            return basePrice;
        }
    }

    @Override
    public String getDescription() {
        if (warmed) {
            return name + " [" + getItemCode() + "] (Warmed)";
        } else {
            return name + " [" + getItemCode() + "] (Not warmed)";
        }
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}