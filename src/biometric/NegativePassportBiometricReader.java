package biometric;

import data.BiometricData;
import data.Nif;
import evoting.biometricdataperipheral.PassportBiometricReader;

public class NegativePassportBiometricReader implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {
        throw new NotValidPassportException();
    }

    @Override
    public Nif getNifWithOCR() throws Nif.InvalidNifException {
        throw new Nif.InvalidNifException("Invalid NIF");
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        throw new PassportBiometricReadingException();
    }
    class NotValidPassportException extends Exception {
    }
}
