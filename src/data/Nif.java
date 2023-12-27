package data;

public class Nif {
    private String nif;
    public Nif(String nif1){
        if(nif1.equals(null)){System.out.println("El nif no pot ser null");}else{
        this.nif = nif1;}
    }
    public boolean equals (String nif2){
        return this.nif.equals(nif2);
    }



}
