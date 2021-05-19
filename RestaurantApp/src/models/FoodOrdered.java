package models;

public class FoodOrdered {
    
    private Food [] foodOrderList;
    private int id;
    private int discount;
    private Costumer costumer;
    public static final int  QUANTITY_OF_FOOD = 10;
    public static final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    public static final String FIRST = "\n\n<================= RESTAURANTE ==================>\n";
    private static final String TOTAL = "Total";
    private static final String DISCOUNT = "Descuento";
    private static final String SUBTOTAL = "Subtotal";
    private static final String COST = "Costo";
    private static final String PRODUCT = "Producto";
    private static final String ID_BILL = "Id factura";
    private static final String ID = "Identificacion";
    private static final String NAME = "Nombre";
    private static final String DOT = ".";
    private static final char PARETHESIS = ')';

    public FoodOrdered(int id, Costumer newCostumer){
        this.id = id;
        this.costumer = newCostumer;
        foodOrderList = new Food[QUANTITY_OF_FOOD];
    }

    public void addFood(Food food){
        for (int i = 0; i < foodOrderList.length; i++) {
            if(foodOrderList[i] == null){
                System.out.println();
                foodOrderList[i] = food;
                return;
            }
        }
    }

    public Costumer getCostumer(){
        return costumer;
    }

    public String getNameCostumer(){
        return costumer.getName();
    }

    public int getId(){
        return id;
    }

    public Costumer setDiscount(int percentDiscount){
        discount = (getCost() * percentDiscount)/100;
        return costumer;
    }

    public String getBirthdayCostumer(){
        return costumer.getBirthday();
    }

    public Food [] getOrder(){
        return foodOrderList;
    }

    public boolean isThereAlcohol(){
        for (Food food : foodOrderList) {
            if(food != null){
                String name = food.getName();
                if(name.charAt(name.length() - 1) == PARETHESIS){
                    return true;
                }
            }
        }
        return false;
    }

    public int getCost(){
        int totalCost = 0;
        for (Food food : foodOrderList) {
            if(food != null){
                totalCost += food.getPrice();
            }
        }
        return totalCost - discount;
    }

    public int getTotal(){
        int totalCost = 0;
        for (Food food2 : foodOrderList) {
            if(food2 != null){
                totalCost += food2.getPrice();
            }
        }
        return totalCost;
    }

    public String getStringWithS(String first, String second){
        int totalDots = 50;
        String result = first;
        totalDots -= first.length() + second.length();
        for (int i = 0; i < totalDots; i++) {
            result += DOT;
        }
        result += second + "\n";
        return result;
    }

    public String getStringWithI(String first, int number){
        int totalDots = 50;
        String second = String.valueOf(number);
        String result = first;
        totalDots -= first.length() + second.length();
        for (int i = 0; i < totalDots; i++) {
            result += DOT;
        }
        result += second + "\n";
        return result;
    }

    @Override
    public String toString() {
        String result = FIRST + "\n"  + getStringWithS(NAME, costumer.getName()) + getStringWithI(ID, costumer.getId()) + "\n" + LINE + getStringWithI(ID_BILL, id) + getStringWithS(PRODUCT, COST) + "\n"; 
        for (Food food : foodOrderList) {
            if(food != null){
                result += getStringWithI(food.getName(), food.getPrice());
            }
        }
        result += LINE + "\n" + getStringWithI(SUBTOTAL, getTotal()) + getStringWithI(DISCOUNT, discount) + LINE + "\n" + getStringWithI(TOTAL, getCost()) + LINE;
        
        return result;
    }
}
