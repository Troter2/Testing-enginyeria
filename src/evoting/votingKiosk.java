package evoting;

import data.Nif;
import data.Password;
import data.VotingOption;
import services.Scrutiny;

import java.net.ConnectException;
import java.util.List;

/**
 * Internal classes involved in in the exercise of the vote
 */
public class votingKiosk implements Scrutiny {
    //??? // The class members
     //??? // The constructor/s
    // Input events
    Nif nif1;
    public void initVoting () {}//{ . . . }
    public void setDocument (char opt) {}//{ . . . }
    public void enterAccount (String login, Password pssw)
            throws InvalidAccountException {

    }//{ . . . }
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
    }//{ . . . }
    public void enterNif (Nif nif) throws NotEnabledException, ConnectException
    {
        nif1=nif;
    }//{ . . . }
    public void initOptionsNavigation () {

    }//{ . . . }
    public void consultVotingOption (VotingOption vopt) {
        String info=vopt.getParty();
        System.out.println(info);
    }//{ . . . }
    public void vote () {}//{ . . . }

    public void confirmVotingOption (char conf) throws ConnectException {
        System.out.println("Escriviu la lletra 'a' si el vot es correcte");
        if (conf=='a'){

        }else{
            throw new ConnectException("el vot no sa confirmat");
        }
    }//{ . . .}
    // Internal operation, not required
    private void finalizeSession () {}//{ . . . }

    @Override
    public void initVoteCount(List<VotingOption> validParties) {

    }

    @Override
    public void scrutinize(VotingOption vopt) {

    }

    @Override
    public int getVotesFor(VotingOption vopt) {
        return 0;
    }

    @Override
    public int getTotal() {
        return 0;
    }

    @Override
    public int getNulls() {
        return 0;
    }

    @Override
    public int getBlanks() {
        return 0;
    }

    @Override
    public void getScrutinyResults() {

    }


    //(. . .) // Setter methods for injecting dependences and additional methods

    private class InvalidAccountException extends Exception {
    }

    private class InvalidDNIDocumException extends Exception {
        public InvalidDNIDocumException(String pritn) {
            System.out.println(pritn);
        }
    }

    private class NotEnabledException extends Exception {
    }
}
