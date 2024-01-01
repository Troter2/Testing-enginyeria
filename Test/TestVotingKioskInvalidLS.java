import data.Nif;
import data.Password;
import data.VotingOption;
import electoralOrganism.EnableElectoralOrganism;
import electoralOrganism.NotEnableElectoralOrganism;
import evoting.VotingKiosk;
import localService.NegativeLocalService;
import localService.PositiveLocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVotingKioskInvalidLS {
    private VotingKiosk votingKiosk;


    @BeforeEach
    public void setUp() {
        List opcions=new ArrayList<VotingOption>();
        opcions.add(new VotingOption("partit1"));
        opcions.add(new VotingOption("partit2"));
        opcions.add(new VotingOption("partit3"));
        // Inicializar la instancia de VotingKiosk antes de cada prueba
        votingKiosk = new VotingKiosk(opcions, new NegativeLocalService(), new EnableElectoralOrganism());

    }

    @Test
    public void testEnterAccountInvalid() throws Nif.InvalidNifException {


        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        try {
            votingKiosk.enterAccount("user", new Password("password1A"));
        } catch (Password.InvalidPasswordException e) {
            throw new RuntimeException(e);
        }
        assertEquals("Credencials incorrectes",out.toString().trim());

    }
}
