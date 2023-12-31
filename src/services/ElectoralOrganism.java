package services;

import data.Nif;
import evoting.VotingKiosk;
import exceptions.NotEnabledException;

import java.net.ConnectException;

public interface ElectoralOrganism { // External service for the Electoral Organism
    void canVote(Nif nif) throws NotEnabledException, ConnectException;
    void disableVoter(Nif nif) throws ConnectException;


}
