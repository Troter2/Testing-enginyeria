import data.VotingOption;
import electoralOrganism.EnableElectoralOrganism;
import evoting.VotingKiosk;
import localService.PositiveLocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBiometricData {
    private VotingKiosk votingKiosk;
    @BeforeEach
    public void setUp() {
        List opcions=new ArrayList<VotingOption>();
        opcions.add(new VotingOption("partit1"));
        opcions.add(new VotingOption("partit2"));
        opcions.add(new VotingOption("partit3"));
        // Inicializar la instancia de VotingKiosk antes de cada prueba
        votingKiosk = new VotingKiosk(opcions, new PositiveLocalService(), new EnableElectoralOrganism());
    }
    @Test
    public void testverifiyBiometricData(){

    }
    @Test
    public void testreadPassportValid(){

    }
    @Test
    public void testreadPassportInvalid(){

    }
    @Test
    public void testreadFaceBiometrics(){

    }
    @Test
    public void testreadFingerPrintBiometrics(){

    }
}
