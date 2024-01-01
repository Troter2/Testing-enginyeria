package evoting;

import biometric.PositivePassportBiometricReader;
import biometric.PositiveHumanBiometricScanner;
import data.*;
import evoting.biometricdataperipheral.HumanBiometricScanner;
import evoting.biometricdataperipheral.PassportBiometricReader;
import services.LocalService;
import electoralOrganism.EnableElectoralOrganism;
import scrutiny.ActiveScrutiny;
import services.ElectoralOrganism;

import java.util.*;


import java.net.ConnectException;

/**
 * Internal classes involved in the exercise of the vote
 */
public class VotingKiosk {
    //??? // The class members
    //??? // The constructor/s
    // Input events
    ActiveScrutiny scrutiny = new ActiveScrutiny();
    LocalService localService;
    Conditions conditions = new Conditions();
    ElectoralOrganism electoralOrganism;
    Nif curNif;
    SingleBiometricData face;
    SingleBiometricData finger;

    public VotingKiosk(List opcions, LocalService ls, ElectoralOrganism eo){
        localService = ls;
        scrutiny = new ActiveScrutiny();
        scrutiny.initVoteCount(opcions);
        conditions = new Conditions();
        electoralOrganism = eo;
        conditions.setEvote_active(true);
    }

    VotingOption curVotingOption,vote;
    public void initVoting () {
        System.out.println("Benvingut a la plataforma de votació electrònica.\n" +
                "Si us plau, segueix les instruccions per començar el procés de votació.");
    }
    public void setDocument (char opt) {
        if(opt=='a'){
            //selecionar el dni
            try {
                confirmIdentif('a');
            } catch (InvalidDNIDocumException e) {
                e.printStackTrace();
            }

        }else if(opt=='b'){
            //selecionar el passaport
        } else {
            System.out.println("Opció invalida");
        }
    }

    public void enterAccount (String login, Password pssw)
    {
        try {
            localService.verifyAccount(login,pssw);
        } catch (LocalService.InvalidAccountException e) {
            System.out.println("Credencials incorrectes");
        }
    }
    public void confirmIdentif (char conf) throws InvalidDNIDocumException
    {
        if (conf=='a'){
            System.out.println("Document correcte");
        }else if(conf=='b'){
            throw new InvalidDNIDocumException("El Nif esta caducat");
        }else if (conf=='c'){
            throw new InvalidDNIDocumException("El Nif no correspon a la persona");
        }else{
            throw new InvalidDNIDocumException("El Nif no es valid");
        }
    }
    public void enterNif(Nif nif) throws InvalidDNIDocumException {
        try {
            electoralOrganism.canVote(nif);
            curNif = nif;
        } catch (ElectoralOrganism.NotEnabledException e) {
            throw new VotingKiosk.InvalidDNIDocumException("Aquest usuari ja no pot votar");
        } catch (ConnectException e) {
            System.out.println("Error de conexión");
        }
    }
    public void initOptionsNavigation () {
        System.out.println("Benvingut al sistema de votació. Si us plau, selecciona una opció:");
        System.out.println("a. Veure les opcions de vot disponibles");
        System.out.println("b. Començar a votar");
        System.out.println("c. Sortir");

    }
    public void consultVotingOption (VotingOption vopt) {
        conditions.setVote_option(true);
        curVotingOption = vopt;
    }
    public void vote () throws ProceduralException {
        if(conditions.isEvote_active() && conditions.isVote_option()) {
            conditions.setConfirmed_vote(true);
            vote = curVotingOption;
        }else throw new ProceduralException();
    }


    public void confirmVotingOption (char conf) throws ProceduralException, ConnectException {
        if(conditions.isEvote_active() && conditions.isVote_option() && conditions.isConfirmed_vote()) {
            System.out.println("Escriviu la lletra 'a' si vols votar " + vote);
            if (conf == 'a') {
                increaseVote();
                electoralOrganism.disableVoter(curNif);
            } else {
                throw new ConnectException("el vot no sa confirmat");
            }
        }else{throw new ProceduralException();}
    }
    // Internal operation, not required
    private void finalizeSession () {

    }

    // Setter methods for injecting dependences and additional methods
    private void increaseVote() {
        //scrutiny.
        scrutiny.scrutinize(vote);
    }

    //Part 2
    private void verifiyBiometricData(BiometricData humanBioD, BiometricData passpBioD) throws BiometricVerificationFailedException {

        if (humanBioD.equals(passpBioD)) {
            
        } else {
            removeBiometricData();
            throw new BiometricVerificationFailedException();
        }
    }
    public void grantExplicitConsent (char cons) {
        conditions.setExplicitConsent(true);

    }

    public void readPassport () throws PassportBiometricReader.NotValidPassportException, PassportBiometricReader.PassportBiometricReadingException, BiometricVerificationFailedException, HumanBiometricScanner.HumanBiometricScanningException, ElectoralOrganism.NotEnabledException, ConnectException, Nif.InvalidNifException {
        if(!conditions.hasExplicitConsent()) {
            System.out.println("No tenim permis per llegir el passaport");
        }else {

            PassportBiometricReader passport = new PositivePassportBiometricReader();
            passport.validatePassport();
            passport.getPassportBiometricData();
            System.out.println("Lectura del passaport correcta.");
            passport.getNifWithOCR();
        }
        //readFaceBiometrics();
       // readFingerPrintBiometrics();

    }
    public void readFaceBiometrics () throws HumanBiometricScanner.HumanBiometricScanningException {
        HumanBiometricScanner human=new PositiveHumanBiometricScanner();
        face=human.scanFaceBiometrics();

    }
    public void readFingerPrintBiometrics () throws ElectoralOrganism.NotEnabledException, HumanBiometricScanner.HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException {
        HumanBiometricScanner human=new PositiveHumanBiometricScanner();
        finger=human.scanFingerprintBiometrics();
    }

    private void removeBiometricData () {

    }




//Excepcions

    public class InvalidDNIDocumException extends Exception {
        public InvalidDNIDocumException(String print) {
            System.out.println(print);
        }
    }

    private class BiometricVerificationFailedException extends Exception {
    }


    public class ProceduralException extends Exception {
    }
}
