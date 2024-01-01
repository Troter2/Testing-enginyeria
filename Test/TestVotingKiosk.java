import data.Nif;
import data.Password;
import data.VotingOption;
import electoralOrganism.EnableElectoralOrganism;
import evoting.VotingKiosk;

import localService.PositiveLocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVotingKiosk {

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

    @Test
    public void testEnterAccountValid() throws Password.InvalidPasswordException {
        String name= "Juan";
        Password psw=new Password("1A234");
        //votingKiosk.enterAccount(name,psw);
        assertDoesNotThrow(() -> votingKiosk.enterAccount(name,psw));
    }
    @Test
    public void testEnterAccountInvalid() throws Password.InvalidPasswordException {
   //    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
   //    System.setOut(new java.io.PrintStream(out));
   //    String name= "Juan";
   //    Password psw=new Password("12A34");
   //    votingKiosk.enterAccount(name,psw);
   //    assertEquals("La contraseña debe tener al menos 5 caracteres",out.toString().trim());
    }
    @Test
    public void testconfirmIdentifValid() throws VotingKiosk.InvalidDNIDocumException {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        votingKiosk.confirmIdentif('a');
        assertEquals("Document correcte",out.toString().trim());
    }
    @Test
    public void testConfirmIdentifInvalid() throws VotingKiosk.InvalidDNIDocumException {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        assertThrows(VotingKiosk.InvalidDNIDocumException.class,() -> votingKiosk.confirmIdentif('b'));
        assertThrows(VotingKiosk.InvalidDNIDocumException.class,() -> votingKiosk.confirmIdentif('c'));
        assertThrows(VotingKiosk.InvalidDNIDocumException.class,() -> votingKiosk.confirmIdentif('d'));
        assertThrows(VotingKiosk.InvalidDNIDocumException.class,() -> votingKiosk.confirmIdentif('z'));
        assertThrows(VotingKiosk.InvalidDNIDocumException.class,() -> votingKiosk.confirmIdentif('4'));
    }

    @Test
    public void testEnterNifInvalid() throws Nif.InvalidNifException {
        //Nif nif= new Nif("12345678N");

    }
    @Test
    public void testConsultVotingOptionValid(){
        VotingOption vopt1=new VotingOption("PSOE");
        VotingOption vopt2=new VotingOption("PEPE");
        assertDoesNotThrow(() ->  votingKiosk.consultVotingOption(vopt1));
        assertDoesNotThrow(() ->  votingKiosk.consultVotingOption(vopt2));

    }
    @Test
    public void testConsultVotingOptionInvalid(){

    }
    @Test
    public void testVoteValid(){
        VotingOption vopt1=new VotingOption("PSOE");
        assertDoesNotThrow(() ->  votingKiosk.consultVotingOption(vopt1));
        assertDoesNotThrow(() ->  votingKiosk.vote());
    }
    @Test
    public void testVoteInvalid(){
        assertThrows(VotingKiosk.ProceduralException.class,() -> votingKiosk.vote());
    }
    @Test
    public void testConfirmVotingOptionValid(){
        VotingOption vopt1=new VotingOption("partit1");
        assertDoesNotThrow(() ->  votingKiosk.consultVotingOption(vopt1));
        assertDoesNotThrow(() ->  votingKiosk.vote());
        assertDoesNotThrow(() ->  votingKiosk.confirmVotingOption('a'));
    }
    @Test
    public void testConfirmVotingOptionInvalid(){
        assertThrows(VotingKiosk.ProceduralException.class,() -> votingKiosk.confirmVotingOption('a'));
        VotingOption vopt1=new VotingOption("partit1");
        assertDoesNotThrow(() ->  votingKiosk.consultVotingOption(vopt1));
        assertDoesNotThrow(() ->  votingKiosk.vote());
        assertThrows(java.net.ConnectException.class,() -> votingKiosk.confirmVotingOption('d'));
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
