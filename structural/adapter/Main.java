public class Main {
    public static void main(String[] args) {
        LegacyBillingSystem legacySystem = new LegacyBillingSystem();
        BillingSystem billingSystem = new BillingSystemAdapter(legacySystem);

        billingSystem.generateReport(); // Uses the adapter to generate a report
    }
}
