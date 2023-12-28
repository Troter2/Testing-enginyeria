package data;

import java.util.Objects;

public class Password {
    private final String password;

    public Password(String password) throws InvalidPasswordException {
        validatePassword(password);
        this.password = password;
    }

    private void validatePassword(String password) throws InvalidPasswordException {
        if (password == null) {
            throw new InvalidPasswordException("La contraseña no puede ser null");
        }

        if (password.length() < 5) {
            throw new InvalidPasswordException("La contraseña debe tener al menos 5 caracteres");
        }

        // Requerir al menos un número
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("La contraseña debe contener al menos un número");
        }

        // Requerir al menos una letra mayúscula
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("La contraseña debe contener al menos una letra mayúscula");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Password other = (Password) obj;
        return Objects.equals(this.password, other.password);
    }

    public class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String msg) {
            super(msg);
        }
    }
}
