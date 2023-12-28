import data.VotingOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scrutiny.ActiveScrutiny;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestActiveScrutiny {

    private static ActiveScrutiny activeScrutiny;

    @BeforeAll
    public static void setUp() {
        // Se ejecuta una vez antes de todas las pruebas
        List<VotingOption> validParties = new ArrayList<>();
        validParties.add(new VotingOption("Party1"));
        validParties.add(new VotingOption("Party2"));
        validParties.add(new VotingOption("blank"));

        activeScrutiny = new ActiveScrutiny();
        activeScrutiny.initVoteCount(validParties);
    }

    @Test
    public void testScrutiny() {
        // Verificar que la inicialización de votos sea correcta
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("Party1")));
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("Party2")));
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("blank")));
        assertEquals(0, activeScrutiny.getNulls());
        assertEquals(0, activeScrutiny.getBlanks());
        assertEquals(0, activeScrutiny.getTotal());

        // Verificar que la votación para una opción válida se maneje correctamente
        VotingOption option = new VotingOption("Party1");
        activeScrutiny.scrutinize(option);
        assertEquals(1, activeScrutiny.getVotesFor(option));
        assertEquals(1, activeScrutiny.getTotal());

        //Verificar que la votación multiple válida se maneje correctamente
        VotingOption option2 = new VotingOption("Party2");
        VotingOption optionblank = new VotingOption("blank");
        activeScrutiny.scrutinize(option);
        activeScrutiny.scrutinize(optionblank);
        activeScrutiny.scrutinize(option);
        activeScrutiny.scrutinize(option);
        activeScrutiny.scrutinize(option2);
        activeScrutiny.scrutinize(option2);
        assertEquals(4, activeScrutiny.getVotesFor(option));
        assertEquals(2, activeScrutiny.getVotesFor(option2));
        assertEquals(1, activeScrutiny.getVotesFor(optionblank));
        assertEquals(7, activeScrutiny.getTotal());

        // Verificar que la votación para una opción no válida se maneje correctamente
        VotingOption invalidOption = new VotingOption("InvalidParty");
        activeScrutiny.scrutinize(invalidOption);
        assertEquals(1, activeScrutiny.getVotesFor(new VotingOption("null")));
        assertEquals(8, activeScrutiny.getTotal());

        // Verificar que los resultados de la escrutinio se impriman correctamente
        activeScrutiny.getScrutinyResults();
    }
}
