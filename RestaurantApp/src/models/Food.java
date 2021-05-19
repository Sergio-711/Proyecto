package models;

public class Food {

    private String food;
    private int priceFood;
    private FoodType typeFood;
    private int id;

    public Food(String name, int price, FoodType type, int id){
       food = name;
       priceFood = price;
       typeFood = type;
       this.id = id;
    }

    public int getId(){
        return id;
    }

    public FoodType getType(){
        return typeFood;
    }

    public String getName(){
        return food;
    }

    public int getPrice(){
        return priceFood;
    }

    @Override
    public String toString() {
        return food + "   -   $" + priceFood + "   -   " + id;
    }
}
