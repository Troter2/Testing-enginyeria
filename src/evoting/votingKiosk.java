package evoting;

import data.Nif;
import data.Password;
import data.VotingOption;

import java.net.ConnectException;

/**
 * Internal classes involved in in the exercise of the vote
 */
public class votingKiosk {
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


    //(. . .) // Setter methods for injecting dependences and additional methods

    private class InvalidAccountException extends Exception {
    }

    private class InvalidDNIDocumException extends Exception {
    }

    public class NotEnabledException extends Exception {
    }
}