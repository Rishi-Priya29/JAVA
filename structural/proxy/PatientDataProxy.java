public class PatientDataProxy implements PatientData {
    private RealPatientData realPatientData;
    private boolean isAuthorized;

    public PatientDataProxy(String patientName, boolean isAuthorized) {
        this.realPatientData = new RealPatientData(patientName);
        this.isAuthorized = isAuthorized;
    }

    @Override
    public void viewData() {
        if (isAuthorized) {
            realPatientData.viewData();
        } else {
            System.out.println("Access denied. You are not authorized to view this data.");
        }
    }
}
