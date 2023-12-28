package data;

public class Password {
    private String password=null;
    public Password(String password1) throws InvalidPasswordException {
        if(password1!=null){
            this.password=password1;
        } else {
            throw new InvalidPasswordException("Password no pot ser null");
        }
    }
    public boolean equals(String pass){
        return password.equals(pass);
    }

    public class InvalidPasswordException extends Exception {
        public InvalidPasswordException (String msg){
            super(msg);
        }
    }
}
