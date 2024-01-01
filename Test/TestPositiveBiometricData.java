import biometric.PositiveHumanBiometricScanner;
import biometric.PositivePassportBiometricReader;
import data.BiometricData;
import data.SingleBiometricData;
import data.VotingOption;
import electoralOrganism.EnableElectoralOrganism;
import evoting.VotingKiosk;
import exceptions.*;
import localService.PositiveLocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPositiveBiometricData {
    private VotingKiosk votingKiosk;
    @BeforeEach
    public void setUp() {
        List opcions=new ArrayList<VotingOption>();
        opcions.add(new VotingOption("partit1"));
        opcions.add(new VotingOption("partit2"));
        opcions.add(new VotingOption("partit3"));
        // Inicializar la instancia de VotingKiosk antes de cada prueba
        votingKiosk = new VotingKiosk(opcions, new PositiveLocalService(), new EnableElectoralOrganism(), new PositivePassportBiometricReader(), new PositiveHumanBiometricScanner());
    }
    @Test
    public void testvVerifiyBiometricData(){

    }
    @Test
    public void testReadPassportValid() throws BiometricVerificationFailedException, PassportBiometricReadingException, HumanBiometricScanningException, InvalidNifException, NotEnabledException, ConnectException, NotValidPassportException {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        votingKiosk.readPassport();
        assertEquals("No tenim permis per llegir el passaport",out.toString().trim());
    }

    @Test
    public void testReadFaceBiometricsValid(){
        assertDoesNotThrow(() ->  votingKiosk.readFaceBiometrics());
    }
    @Test
    public void testReadFingerPrintBiometricsValid(){
        assertDoesNotThrow(() ->  votingKiosk.readFingerPrintBiometrics());
    }

    @Test
    public void testVerifiyBiometricData(){
        BiometricData bioData1 = new BiometricData(new SingleBiometricData(new byte[10]), new SingleBiometricData(new byte[10]));
        BiometricData bioData2 = new BiometricData(new SingleBiometricData(new byte[10]), new SingleBiometricData(new byte[10]));
        assertDoesNotThrow(() -> votingKiosk.verifiyBiometricData(bioData1,bioData2));
    }
}