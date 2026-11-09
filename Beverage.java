public class Beverage extends MenuItem {

    private String size;

    public Beverage() {
        super();
        this.size = "M";
    }

    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    @Override
    public double computePrice() {
        if (size.equalsIgnoreCase("L")) {
            return basePrice + 25;
        } else if (size.equalsIgnoreCase("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    @Override
    public String getDescription() {
        return name + " [" + getItemCode() + "] Size: " + size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size != null &&
            (size.equalsIgnoreCase("S") ||
             size.equalsIgnoreCase("M") ||
             size.equalsIgnoreCase("L"))) {
            this.size = size.toUpperCase();
        } else {
            System.out.println("Invalid beverage size.");
        }
    }
}