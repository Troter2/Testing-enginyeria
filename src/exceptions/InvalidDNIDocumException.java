package exceptions;

public class InvalidDNIDocumException extends Exception {
    public InvalidDNIDocumException(String print) {
        System.out.println(print);
    }
}