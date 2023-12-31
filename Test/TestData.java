import data.Nif;
import data.Password;
import exceptions.InvalidNifException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestData {
    @Test
    // Pruebas para la clase Nif
    void testNif() {
        // Caso de prueba 1: NIF válido
        assertDoesNotThrow(() -> new Nif("12345678N"));

        // Caso de prueba 2: NIF con longitud incorrecta
        assertThrows(InvalidNifException.class, () -> new Nif("123456789X"));

        // Caso de prueba 3: NIF con formato incorrecto (letra en posición incorrecta)
        assertThrows(InvalidNifException.class, () -> new Nif("1234567X8"));

        // Caso de prueba 4: NIF con formato incorrecto (número en posición de letra)
        assertThrows(InvalidNifException.class, () -> new Nif("123456789"));

        // Caso de prueba 5: NIF con valor null
        assertThrows(InvalidNifException.class, () -> new Nif(null));
    }
    @Test
    // Pruebas para la clase Password
    void testPassword() {
        // Caso de prueba 1: Contraseña válida
        assertDoesNotThrow(() -> new Password("Abcd123"));

        // Caso de prueba 2: Contraseña con longitud incorrecta
        assertThrows(Password.InvalidPasswordException.class, () -> new Password("Ab12"));

        // Caso de prueba 3: Contraseña sin letra mayúscula
        assertThrows(Password.InvalidPasswordException.class, () -> new Password("abcd123"));

        // Caso de prueba 4: Contraseña sin número
        assertThrows(Password.InvalidPasswordException.class, () -> new Password("Abcdefgh"));

        // Caso de prueba 5: Contraseña con valor null
        assertThrows(Password.InvalidPasswordException.class, () -> new Password(null));
    }

}
