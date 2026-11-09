public class CafeApp {

    public static void main(String[] args) {

        // Create customers using different constructors.
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");

        // Create beverage objects.
        Beverage latte = new Beverage(
            "Iced Latte", 95.00, "B-01", "L"
        );

        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80.00);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        // Create pastry objects.
        Pastry ensaymada = new Pastry(
            "Ensaymada", 45.00, "P-01", true
        );

        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setBasePrice(30.00);
        cookie.setItemCode("P-02");
        cookie.setWarmed(false);

        // Create meal objects.
        Meal chickenAdobo = new Meal(
            "Chicken Adobo", 110.00, "M-01", true, 1
        );

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130.00);
        beefTapa.setItemCode("M-02");
        beefTapa.setUpsized(false);
        beefTapa.setExtraSides(0);

        // First order.
        Order order1 = new Order("1001", customer1);

        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);

        // Test the maximum of three items.
        order1.addItem(cookie);

        order1.printReceipt();

        // Second order.
        Order order2 = new Order("1002", customer2);

        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);

        // Apply a 20-peso voucher.
        order2.computeTotal(20.00);

        order2.printReceipt();
    }
}