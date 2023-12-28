package data;

public class Nif {
    private final String nif;
    public Nif(String nif1) throws InvalidNifException {
        if (nif1 == null) {
            throw new InvalidNifException("El NIF no puede ser null");
        } else if (nif1.length() != 9) {
            throw new InvalidNifException("El NIF debe tener exactamente 9 caracteres");
        } else if (!nif1.substring(0, 8).matches("\\d+") || !Character.isLetter(nif1.charAt(8))) {
            throw new InvalidNifException("El formato del NIF es incorrecto");
        } else {
            this.nif = nif1;
        }
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nif other = (Nif) obj;
        return this.nif.equals(other.nif);
    }
    public static class InvalidNifException extends Exception {
        public InvalidNifException (String msg){
            super(msg);
        }
    }
}
