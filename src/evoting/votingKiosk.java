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
    public void initVoting () {}//{ . . . }
    public void setDocument (char opt) {}//{ . . . }
    public void enterAccount (String login, Password pssw)
            throws InvalidAccountException {}//{ . . . }
    public void confirmIdentif (char conf) throws InvalidDNIDocumException
    {}//{ . . . }
    public void enterNif (Nif nif) throws NotEnabledException, ConnectException
    {}//{ . . . }
    public void initOptionsNavigation () {}//{ . . . }
    public void consultVotingOption (VotingOption vopt) {}//{ . . . }
    public void vote () {}//{ . . . }

    public void confirmVotingOption (char conf) throws ConnectException {}//{ . . .}
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
    }

    private class NotEnabledException extends Exception {
    }
}
