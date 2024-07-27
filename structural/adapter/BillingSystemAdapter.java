public class BillingSystemAdapter implements BillingSystem {
    private LegacyBillingSystem legacyBillingSystem;

    public BillingSystemAdapter(LegacyBillingSystem legacyBillingSystem) {
        this.legacyBillingSystem = legacyBillingSystem;
    }

    @Override
    public void generateReport() {
        legacyBillingSystem.generateOldFormatReport();
    }
}
