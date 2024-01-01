package biometric;

import data.BiometricData;
import data.Nif;
import evoting.biometricdataperipheral.PassportBiometricReader;
import exceptions.InvalidNifException;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;

public class NegativePassportBiometricReader implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {
        throw new NotValidPassportException();
    }

    @Override
    public Nif getNifWithOCR() throws InvalidNifException {
        throw new InvalidNifException("Invalid NIF");
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        throw new PassportBiometricReadingException();
    }

}
