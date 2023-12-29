package evoting.biometricdataperipheral;

import data.BiometricData;
import data.Nif;

public interface PassportBiometricReader {// Perip. for reading passport biometrics
    void validatePassport () throws NotValidPassportException;
    Nif getNifWithOCR () throws Nif.InvalidNifException;
    BiometricData getPassportBiometricData ()
            throws PassportBiometricReadingException;

    class NotValidPassportException extends Exception {
    }

    class PassportBiometricReadingException extends Exception {
    }
}
