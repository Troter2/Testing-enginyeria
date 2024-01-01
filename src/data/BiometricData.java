package data;

public class BiometricData {
    SingleBiometricData facial;
    SingleBiometricData finger;

    public BiometricData(SingleBiometricData facial, SingleBiometricData finger){
        this.facial = facial;
        this.finger=finger;
    }

    public boolean compare(BiometricData data1){
        return facial.compare(data1.facial) && finger.compare(data1.finger);
    }
}
