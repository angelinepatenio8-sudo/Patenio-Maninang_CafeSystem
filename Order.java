public class Order {

    private String orderId;
    private Customer customer;

    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;

    private int itemCount;
    private double voucherAmount;
    private boolean pointsAwarded;

    private static final int MAX_ITEMS = 3;
    private static final double STUDENT_DISCOUNT = 0.10;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
        this.voucherAmount = 0;
        this.pointsAwarded = false;
    }

    public void addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Invalid menu item.");
        } else if (itemCount >= MAX_ITEMS) {
            System.out.println("Order is full. Cannot add " +
                               item.getName() + ".");
        } else {
            if (itemCount == 0) {
                item1 = item;
            } else if (itemCount == 1) {
                item2 = item;
            } else {
                item3 = item;
            }

            itemCount++;
        }
    }

    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            return subtotal - (subtotal * STUDENT_DISCOUNT);
        } else {
            return subtotal;
        }
    }

    public double computeTotal(double voucher) {
        if (voucher < 0) {
            System.out.println("Invalid voucher amount.");
            voucher = 0;
        }

        double total = computeTotal();

        if (voucher > total) {
            voucher = total;
        }

        voucherAmount = voucher;

        return total - voucherAmount;
    }

    public void printReceipt() {
        double subtotal = computeSubtotal();
        double discount = 0;

        if (customer.isStudent()) {
            discount = subtotal * STUDENT_DISCOUNT;
        }

        double discountedTotal = subtotal - discount;
        double total = discountedTotal - voucherAmount;

        if (total < 0) {
            total = 0;
        }

        System.out.println();
        System.out.println("========== CAFE RECEIPT ==========");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Student: " +
                           (customer.isStudent() ? "Yes" : "No"));

        System.out.println("----------------------------------");

        if (item1 != null) {
            System.out.printf("%-30s %8.2f%n",
                              item1.getDescription(),
                              item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%-30s %8.2f%n",
                              item2.getDescription(),
                              item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%-30s %8.2f%n",
                              item3.getDescription(),
                              item3.computePrice());
        }

        System.out.println("----------------------------------");
        System.out.printf("Subtotal:              %8.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("Student Discount:     -%8.2f%n", discount);
        }

        if (voucherAmount > 0) {
            System.out.printf("Voucher:              -%8.2f%n",
                              voucherAmount);
        }

        System.out.printf("TOTAL:                 %8.2f%n", total);

        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }

        System.out.println("Loyalty Points: " +
                           customer.getLoyaltyPoints());
        System.out.println("==================================");
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getItemCount() {
        return itemCount;
    }
}