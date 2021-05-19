package models;

public class Costumer {
    
    private String name;
    private int id;
    private int temperature;
    private int age;
    private String birthdayDate;

    public Costumer(String name, int id, int temperature, int age, String birthdayDate){
        this.name = name;
        this.id = id;
        this.temperature = temperature;
        this.age = age;
        this.birthdayDate = birthdayDate;
    }

    @Override
    public String toString() {
        return name + " Identificacion: " + id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getTemp(){
        return temperature;
    }

    public int getAge(){
        return age;
    }

    public String getBirthday(){
        return birthdayDate;
    }
}
