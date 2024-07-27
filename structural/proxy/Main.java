public class Main {
    public static void main(String[] args) {
        PatientData proxyAuthorized = new PatientDataProxy("John Doe", true);
        PatientData proxyUnauthorized = new PatientDataProxy("Jane Doe", false);

        proxyAuthorized.viewData();   // Authorized access
        proxyUnauthorized.viewData(); // Unauthorized access
    }
}
