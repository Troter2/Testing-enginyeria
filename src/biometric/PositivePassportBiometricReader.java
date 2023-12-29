package biometric;

import data.BiometricData;
import data.Nif;
import evoting.biometricdataperipheral.PassportBiometricReader;

public class PositivePassportBiometricReader implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {
        return;
    }

    @Override
    public Nif getNifWithOCR() throws Nif.InvalidNifException {
        return new Nif("12345678N");
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        return new BiometricData();
    }
}
