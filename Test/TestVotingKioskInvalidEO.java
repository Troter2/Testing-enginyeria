import biometric.PositiveHumanBiometricScanner;
import biometric.PositivePassportBiometricReader;
import data.Nif;
import data.VotingOption;
import electoralOrganism.EnableElectoralOrganism;
import electoralOrganism.NotEnableElectoralOrganism;
import evoting.VotingKiosk;
import exceptions.InvalidDNIDocumException;
import exceptions.InvalidNifException;
import localService.PositiveLocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVotingKioskInvalidEO {
    private VotingKiosk votingKiosk;


    @BeforeEach
    public void setUp() {
        List opcions=new ArrayList<VotingOption>();
        opcions.add(new VotingOption("partit1"));
        opcions.add(new VotingOption("partit2"));
        opcions.add(new VotingOption("partit3"));
        // Inicializar la instancia de VotingKiosk antes de cada prueba
        votingKiosk = new VotingKiosk(opcions, new PositiveLocalService(), new NotEnableElectoralOrganism(), new PositivePassportBiometricReader(), new PositiveHumanBiometricScanner());

    }

    @Test
    public void testEnterNifValid() throws InvalidNifException {
        Nif nif= new Nif("12345678N");

        assertThrows(InvalidDNIDocumException.class,() -> votingKiosk.enterNif(nif));
    }
}
