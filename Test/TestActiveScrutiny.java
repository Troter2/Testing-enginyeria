import data.VotingOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scrutiny.ActiveScrutiny;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestActiveScrutiny {

    private static ActiveScrutiny activeScrutiny;

    @BeforeEach
    void setUp() {
        // Se ejecuta antes de cada una de las pruebas
        List<VotingOption> validParties = new ArrayList<>();
        validParties.add(new VotingOption("Party1"));
        validParties.add(new VotingOption("Party2"));
        validParties.add(new VotingOption("Party3"));
        validParties.add(new VotingOption("Party4"));
        validParties.add(new VotingOption("blank"));

        activeScrutiny = new ActiveScrutiny();
        activeScrutiny.initVoteCount(validParties);
    }

    @Test
    //Verificar que haciendolo junto funciona correctamente
    void testScrutiny() {
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

        //Verificar que la votación multiple se maneje correctamente
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

    @Test
    void testInitializationScrutiny () {
        // Verificar que la inicialización de votos sea correcta
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("Party1")));
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("Party2")));
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("Party3")));
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("Party4")));
        assertEquals(0, activeScrutiny.getVotesFor(new VotingOption("blank")));
        assertEquals(0, activeScrutiny.getNulls());
        assertEquals(0, activeScrutiny.getBlanks());
        assertEquals(0, activeScrutiny.getTotal());
    }

    @Test
    void testUniqueScrutiny () {
        // Verificar que la votación para una opción válida se maneje correctamente
        VotingOption option = new VotingOption("Party3");
        activeScrutiny.scrutinize(option);
        assertEquals(1, activeScrutiny.getVotesFor(option));
        assertEquals(1, activeScrutiny.getTotal());
        activeScrutiny.getScrutinyResults();
    }

    @Test
    void testMultipleScrutiny () {
        //Verificar que la votación multiple se maneje correctamente
        VotingOption option = new VotingOption("Party1");
        VotingOption option2 = new VotingOption("Party2");
        VotingOption option3 = new VotingOption("Party3");
        VotingOption option4 = new VotingOption("Party4");
        VotingOption optionBlank = new VotingOption("blank");
        VotingOption option5 = new VotingOption("Party5");
        for (int i = 0; i < 5; i++) {
            activeScrutiny.scrutinize(option);
        }
        for (int i = 0; i < 2; i++) {
            activeScrutiny.scrutinize(option2);
        }
        for (int i = 0; i < 9; i++) {
            activeScrutiny.scrutinize(option3);
        }
        for (int i = 0; i < 4; i++) {
            activeScrutiny.scrutinize(option4);
        }
        for (int i = 0; i < 2; i++) {
            activeScrutiny.scrutinize(option5);
        }
        for (int i = 0; i < 5; i++) {
            activeScrutiny.scrutinize(optionBlank);
        }

        assertEquals(5, activeScrutiny.getVotesFor(option));
        assertEquals(2, activeScrutiny.getVotesFor(option2));
        assertEquals(9, activeScrutiny.getVotesFor(option3));
        assertEquals(4, activeScrutiny.getVotesFor(option4));
        assertEquals(5, activeScrutiny.getVotesFor(optionBlank));
        assertEquals(2, activeScrutiny.getVotesFor(new VotingOption("null")));
        assertEquals(27, activeScrutiny.getTotal());

        activeScrutiny.getScrutinyResults();
    }

    @Test
    void testNullScrutiny () {
        // Verificar que la votación para una opción no válida se maneje correctamente
        VotingOption option5 = new VotingOption("Cs");
        activeScrutiny.scrutinize(option5);
        assertEquals(1, activeScrutiny.getVotesFor(new VotingOption("null")));
        assertEquals(1, activeScrutiny.getTotal());
        activeScrutiny.getScrutinyResults();
    }

}
