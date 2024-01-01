package biometric;

import data.SingleBiometricData;
import evoting.biometricdataperipheral.HumanBiometricScanner;

public class NegativeHumanBiometricScanner implements HumanBiometricScanner {
    byte[] byt= new byte[1];
    byte[] byt1=new byte[1];
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        throw new HumanBiometricScanningException();
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        throw new HumanBiometricScanningException();
    }
}
