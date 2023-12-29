import evoting.VotingKiosk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestVotingKiosk {

    private VotingKiosk votingKiosk;

    @BeforeEach
    public void setUp() {
        // Inicializar la instancia de VotingKiosk antes de cada prueba
        votingKiosk = new VotingKiosk();
    }

    @Test
    public void testInitVoting() {
        // Verificar si el mensaje de bienvenida se imprime correctamente
        assertEquals("Benvingut a la plataforma de votació electrònica.\n" +
                        "Si us plau, segueix les instruccions per començar el procés de votació.",
                getConsoleOutput(votingKiosk::initVoting));
    }

    @Test
    public void testSetDocumentValid() {
        votingKiosk.setDocument('a');
    }

    @Test
    public void testSetDocumentInvalid() {
        // Redirige la salida de la consola para capturarla
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Ejecuta la acción que debería imprimir el mensaje de "Opció invalida"
        votingKiosk.setDocument('z');  // Una opción inválida

        // Restablece la salida estándar
        System.setOut(System.out);

        // Verifica que la salida contenga el mensaje esperado
        assertEquals("Opció invalida", out.toString().trim());
    }

    // Método de utilidad para capturar la salida de la consola
    private String getConsoleOutput(Runnable action) {
        // Guardar la salida estándar actual
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Ejecutar la acción que debería imprimir algo en la consola
        action.run();

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Devolver la salida capturada
        return out.toString().trim();
    }
}
