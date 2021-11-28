import tests.BaseClass;

public class Utils extends BaseClass {
    public static String prescriptionId = "";

    public static String getPrescriptionId() {
        return prescriptionId;
    }

    public static void setPrescriptionId(String prescriptionId) {
        Utils.prescriptionId = prescriptionId;
    }
}
