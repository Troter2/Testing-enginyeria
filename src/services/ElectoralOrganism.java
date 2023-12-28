package services;

import data.Nif;
import evoting.votingKiosk;

import java.net.ConnectException;

public interface ElectoralOrganism { // External service for the Electoral Organism
    void canVote(Nif nif) throws votingKiosk.NotEnabledException, ConnectException;
    void disableVoter(Nif nif) throws ConnectException;
}
