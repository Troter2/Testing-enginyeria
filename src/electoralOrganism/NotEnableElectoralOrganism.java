package electoralOrganism;

import data.Nif;
import services.ElectoralOrganism;

public class NotEnableElectoralOrganism implements ElectoralOrganism{
    public NotEnableElectoralOrganism(){}
    @Override
    public void canVote(Nif nif) throws ElectoralOrganism.NotEnabledException {
        throw new ElectoralOrganism.NotEnabledException();
    }

    @Override
    public void disableVoter(Nif nif){
        return;
    }
}
