package biometric;

import data.SingleBiometricData;
import evoting.biometricdataperipheral.HumanBiometricScanner;
import exceptions.HumanBiometricScanningException;

public class PositiveHumanBiometricScanner implements HumanBiometricScanner {
    byte[] byt= new byte[1];
    byte[] byt1=new byte[1];
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        byt[0]=1;
        return new SingleBiometricData(byt);
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        byt1[1]=1;
        return new SingleBiometricData(byt1);
    }
}
