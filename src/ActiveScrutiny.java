import data.VotingOption;
import services.Scrutiny;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActiveScrutiny implements Scrutiny {

    int totalVotes = 0;
    HashMap<VotingOption, Integer> votes = new HashMap<VotingOption,Integer>();
    @Override
    public void initVoteCount(List<VotingOption> validParties) {
        votes.put(new VotingOption("null"), 0);
        votes.put(new VotingOption("blank"), 0);
        for (VotingOption option : validParties){
            votes.put(option, 0);
        }
    }

    @Override
    public void scrutinize(VotingOption opt) {
        if(votes.containsKey(opt))
            votes.put(opt, votes.get(opt)+1);
        else
            votes.put(new VotingOption("null"), votes.get(new VotingOption("null"))+1);
        totalVotes++;
    }

    @Override
    public int getVotesFor(VotingOption opt) {
        return votes.get(new VotingOption("null"));
    }

    @Override
    public int getTotal() {
        return totalVotes;
    }

    @Override
    public int getNulls() {
        return votes.get(new VotingOption("null"));
    }

    @Override
    public int getBlanks() {
        return votes.get(new VotingOption("blank"));
    }

    @Override
    public void getScrutinyResults() {
        for (HashMap.Entry<VotingOption,Integer> entry : votes.entrySet())
            System.out.println(entry.getKey() + ":" + entry.getValue());
    }
}
