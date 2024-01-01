import data.Nif;
import data.VotingOption;
import electoralOrganism.NotEnableElectoralOrganism;
import evoting.VotingKiosk;
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
        votingKiosk = new VotingKiosk(opcions, new PositiveLocalService(), new NotEnableElectoralOrganism());

    }

    @Test
    public void testEnterNifInvalid() throws Nif.InvalidNifException {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        Nif nif= new Nif("12345678N");
        assertEquals("Document correcte",out.toString().trim());
    }
}
