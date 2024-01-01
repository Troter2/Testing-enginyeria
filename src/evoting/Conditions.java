package evoting;

public class Conditions {

    boolean confirmed_vote, explicitConsent, vote_option, evote_active, faceBiometrics, fingerBiometrics;

    public Conditions() {
        evote_active = false;
        vote_option = false;
        confirmed_vote = false;
        explicitConsent = false;
        faceBiometrics = false;
        fingerBiometrics = false;
    }

    public boolean hasExplicitConsent(){
        return explicitConsent;
    }
    public boolean hasFaceBiometrics(){
        return faceBiometrics;
    }
    public boolean hasFingerBiometrics(){
        return fingerBiometrics;
    }
    public void setExplicitConsent(boolean explicitConsent) {
        this.explicitConsent = explicitConsent;
    }

    public void setFaceBiometrics(boolean faceBiometrics) {
        this.faceBiometrics = faceBiometrics;
    }

    public void setFingerBiometrics(boolean fingerBiometrics) {
        this.fingerBiometrics = fingerBiometrics;
    }

    public void setEvote_active(boolean evote_active) {
        this.evote_active = evote_active;
    }

    public void setConfirmed_vote(boolean confirmed_vote) {
        this.confirmed_vote = confirmed_vote;
    }

    public void setVote_option(boolean vote_option) {
        this.vote_option = vote_option;
    }

    public boolean isConfirmed_vote() {
        return confirmed_vote;
    }

    public boolean isEvote_active() {
        return evote_active;
    }

    public boolean isVote_option() {
        return vote_option;
    }
}