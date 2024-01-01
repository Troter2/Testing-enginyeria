package biometric;

import data.BiometricData;
import data.Nif;
import data.SingleBiometricData;
import evoting.biometricdataperipheral.PassportBiometricReader;
import exceptions.InvalidNifException;
import exceptions.NotValidPassportException;
import exceptions.PassportBiometricReadingException;

public class PositivePassportBiometricReader implements PassportBiometricReader {
    @Override
    public void validatePassport() {
        return;
    }

    @Override
    public Nif getNifWithOCR()  {
        try {
            return new Nif("12345678N");
        } catch (InvalidNifException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BiometricData getPassportBiometricData()  {
        return new BiometricData(new SingleBiometricData(new byte[10]), new SingleBiometricData(new byte[10]));
    }
}
