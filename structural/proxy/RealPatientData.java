public class RealPatientData implements PatientData {
    private String patientName;

    public RealPatientData(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public void viewData() {
        System.out.println("Viewing data for patient: " + patientName);
    }
}
