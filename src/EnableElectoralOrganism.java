import data.Nif;
import services.ElectoralOrganism;

import java.net.ConnectException;

public class EnableElectoralOrganism implements ElectoralOrganism{
    @Override
    public void canVote(Nif nif) throws ElectoralOrganism.NotEnabledException {
        return;
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {
        return;
    }
}
