package evoting;

import data.Nif;
import data.Password;
import data.VotingOption;
import localService.PositiveLocalService;
import services.LocalService;
import electoralOrganism.EnableElectoralOrganism;
import scrutiny.ActiveScrutiny;
import services.ElectoralOrganism;
import java.util.Scanner;


import java.net.ConnectException;

/**
 * Internal classes involved in the exercise of the vote
 */
public class VotingKiosk {
    //??? // The class members
    //??? // The constructor/s
    // Input events
    ActiveScrutiny scrutiny = new ActiveScrutiny();
    EnableElectoralOrganism electoralOrganism = new EnableElectoralOrganism();
    Nif curNif;

    public VotingKiosk(){
        scrutiny = new ActiveScrutiny();
        EnableElectoralOrganism electoralOrganism1 = new EnableElectoralOrganism();
    }

    VotingOption curVotingOption,vote;
    public void initVoting () {
        System.out.println("Benvingut a la plataforma de votació electrònica.\n" +
                "Si us plau, segueix les instruccions per començar el procés de votació.");
        Scanner scanner=new Scanner(System.in);
        char opt=scanner.next().charAt(0);
        System.out.println("selecioneu el tipus de document: 'a' per a DNI i 'b' per a passaport");
        setDocument(opt);
    }
    public void setDocument (char opt) {
        if(opt=='a'){
            //selecionar el dni
            try {
                confirmIdentif('a');
            } catch (InvalidDNIDocumException e) {
                e.printStackTrace();
            }

        }else if(opt=='b'){
            //selecionar el passaport
        } else {
            System.out.println("Opció invalida");
        }
    }

    public void enterAccount (String login, Password pssw)
    {
        LocalService local = new PositiveLocalService();
        try {
            local.verifyAccount(login,pssw);
        } catch (LocalService.InvalidAccountException e) {
            e.printStackTrace();
        }
    }
    public void confirmIdentif (char conf) throws InvalidDNIDocumException
    {
        if (conf=='a'){
            System.out.println("Document correcte");
        }else if(conf=='b'){
            throw new InvalidDNIDocumException("El Nif esta caducat");
        }else if (conf=='c'){
            throw new InvalidDNIDocumException("El Nif no correspon a la persona");
        }else{
            throw new InvalidDNIDocumException("El Nif no es valid");
        }
    }
    public void enterNif (Nif nif)
    {
        try {
            electoralOrganism.canVote(nif);
            curNif=nif;
        } catch (ElectoralOrganism.NotEnabledException e) {
            System.out.println("Aquest usuari ja no pot votar");
        }
    }
    public void initOptionsNavigation () {
        System.out.println("Benvingut al sistema de votació. Si us plau, selecciona una opció:");
        System.out.println("a. Veure les opcions de vot disponibles");
        System.out.println("b. Començar a votar");
        System.out.println("c. Sortir");

       /* char entradaUsuari = obtenirEntradaUsuari();

        switch (entradaUsuari) {
            case 'a':
                mostrarOpcionsVot();
                break;
            case 'b':
                iniciarVotacio();
                break;
            case 'c':
                sortirSistemaVotacio();
                break;
            default:
                System.out.println("Opció no vàlida. Si us plau, torna a intentar.");
                initOptionsNavigation(); // Crida recursiva per gestionar una entrada no vàlida
                break;
        }*/
    }
    public void consultVotingOption (VotingOption vopt) {
        curVotingOption = vopt;
    }
    public void vote () {
        vote = curVotingOption;
    }


    public void confirmVotingOption (char conf) throws ConnectException {
        System.out.println("Escriviu la lletra 'a' si vols votar " + vote);
        if (conf=='a'){
            increaseVote();
            electoralOrganism.disableVoter(curNif);
        }else{
            throw new ConnectException("el vot no sa confirmat");
        }
    }
    // Internal operation, not required
    private void finalizeSession () {}

    // Setter methods for injecting dependences and additional methods
    private void increaseVote() {
        scrutiny.scrutinize(vote);
    }

    private class InvalidAccountException extends Exception {
    }

    public class InvalidDNIDocumException extends Exception {
        public InvalidDNIDocumException(String print) {
            System.out.println(print);
        }
    }

    private class NotEnabledException extends Exception {
    }
}
