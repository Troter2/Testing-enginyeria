package data;

public class Nif {
    private final String nif;

    public Nif(String nif1) throws InvalidNifException {
        validateNif(nif1);
        this.nif = nif1;
    }

    private void validateNif(String nif) throws InvalidNifException {
        if (nif == null) {
            throw new InvalidNifException("El NIF no puede ser null");
        } else if (nif.length() != 9) {
            throw new InvalidNifException("El NIF debe tener exactamente 9 caracteres");
        } else if (!isValidNifFormat(nif)) {
            throw new InvalidNifException("El formato del NIF es incorrecto");
        }
    }

    private boolean isValidNifFormat(String nif) {
        return nif.substring(0, 8).matches("\\d+") && Character.isLetter(nif.charAt(8));
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
        public InvalidNifException(String msg) {
            super(msg);
        }
    }
}
