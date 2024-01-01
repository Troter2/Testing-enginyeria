package evoting.biometricdataperipheral;

import biometric.NegativePassportBiometricReader;
import data.BiometricData;
import data.Nif;
import exceptions.InvalidNifException;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;

public interface PassportBiometricReader {// Perip. for reading passport biometrics
    void validatePassport () throws NotValidPassportException;
    Nif getNifWithOCR () throws InvalidNifException;
    BiometricData getPassportBiometricData ()
            throws PassportBiometricReadingException;


}
