package data;

public class Password {
    private String password=null;
    public Password(String password1){
        if(password1!=null){
        this.password=password1;
        }else{System.out.println("password no pots ser null");}
    }
    public boolean equals(String pass){
        return password.equals(pass);
    }
}
