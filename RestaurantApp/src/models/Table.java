package models;

public class Table {
    
    public static final String SUCCESFUL_MESSAGE= "Reservacion exitosa, su mesa es: ";
    public static final String ERROR_MESSAGE = "Hubo un problema";
    private boolean avaliability;
    private String name;

    public Table(boolean avaliability, String name){
        this.avaliability = avaliability;
        this.name = name;
    }

    public String setStatusTable(){
        avaliability = false;
        return SUCCESFUL_MESSAGE + name;
    }

    public boolean getStatus(){
        return avaliability;
    }

    @Override
    public String toString() {
        return name;
    }
}
