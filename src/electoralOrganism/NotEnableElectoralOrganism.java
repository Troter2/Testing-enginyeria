package electoralOrganism;

import data.Nif;
import exceptions.NotEnabledException;
import services.ElectoralOrganism;

public class NotEnableElectoralOrganism implements ElectoralOrganism{
    public NotEnableElectoralOrganism(){}
    @Override
    public void canVote(Nif nif) throws NotEnabledException {
        throw new NotEnabledException();
    }

    @Override
    public void disableVoter(Nif nif){
        return;
    }
}
