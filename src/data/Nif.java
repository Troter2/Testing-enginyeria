package data;

public class Nif {
    private String nif;
    public Nif(String nif1) throws InvalidNifException{
        if(nif1.equals(null)) { // exepcio
            throw new InvalidNifException("El nif no pot ser null");
        } else if (nif1.length() != 9){
            throw new InvalidNifException("El nif no esta complert o sobren caracters");
        } else {
            this.nif = nif1;
        }
    }
    public boolean equals (String nif2){
        return this.nif.equals(nif2);
    }
    public class InvalidNifException extends Exception {
        public InvalidNifException (String msg){
            super(msg);
        }
    }
}
