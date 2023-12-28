import data.Nif;
import services.ElectoralOrganism;

import java.net.ConnectException;

public class ConnectedElectoralOrganism implements ElectoralOrganism {
    public void canVote(Nif nif) throws ConnectException {
        return;
    }
    public void disableVoter(Nif nif) throws ConnectException{
        return;
    }
}
