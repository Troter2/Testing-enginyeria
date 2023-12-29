package data;

import evoting.biometricdataperipheral.PassportBiometricReader;

public class PassportBiometric implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {
        
    }

    @Override
    public Nif getNifWithOCR() {
        return null;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        return null;
    }
}
