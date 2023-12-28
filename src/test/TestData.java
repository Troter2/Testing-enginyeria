package test;

import data.Nif;
import data.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestData {
    @Test//El nif no pot ser null
    public void niftest() throws Nif.InvalidNifException {
        Nif nif =new Nif("1234N");
        Nif nif2 =new Nif("1234N");
        Nif nif3 =new Nif("1235N");
        Nif nif4 = new Nif("null");
        assertTrue(nif.equals(nif2));
        assertNotEquals(nif,nif3);
        assertNull(nif4);
    }
    @Test
    public void TestPassword () throws Password.InvalidPasswordException {
        Password password=new Password("123");
        Password password1=new Password("123");
        Password password2=new Password("123N");
        Password password4=new Password(null);
        assertEquals(password,password1);
        assertNotEquals(password,password2);
        assertNull(password4);

    }

}
