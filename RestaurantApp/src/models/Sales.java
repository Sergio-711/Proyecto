package models;

public class Sales {
    
    private FoodOrdered sale;

    public Sales(FoodOrdered sale){
        this.sale = sale;
    }

    @Override
    public String toString() {
        return sale.toString();
    }
}
