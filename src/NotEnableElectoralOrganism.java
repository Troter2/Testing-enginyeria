import data.Nif;
import services.ElectoralOrganism;

import java.net.ConnectException;

public class NotEnableElectoralOrganism implements ElectoralOrganism{
    @Override
    public void canVote(Nif nif) throws ElectoralOrganism.NotEnabledException {
        throw new ElectoralOrganism.NotEnabledException();
    }

    @Override
    public void disableVoter(Nif nif){
        return;
    }
}
