package electoralOrganism;

import data.Nif;
import services.ElectoralOrganism;

import java.net.ConnectException;

public class NotConnectedElectoralOrganism implements ElectoralOrganism{
    public NotConnectedElectoralOrganism(){}
    public void canVote(Nif nif) throws ConnectException {
        throw new ConnectException();
    }
    public void disableVoter(Nif nif) throws ConnectException{
        throw new ConnectException();
    }
}
