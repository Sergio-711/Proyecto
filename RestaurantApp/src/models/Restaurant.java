package models;

public class Restaurant {
    
    private static final String DOTS = ": ";    
    private static final String DOTS_WITH_MONEY = ": $";
    private Costumer [] costumerList;
    private Table [] tableList;
    private Food [] foodList;
    private FoodOrdered [] foodOrderedList;
    private FoodOrdered [] salesList;
    private int posCostumer;
    private int posOrder;
    public static final String TABLE_ONE ="Mesa uno";
    public static final String TABLE_TWO ="Mesa dos";
    public static final String TABLE_THREE ="Mesa tres";
    public static final String TABLE_FOUR ="Mesa cuatro";
    public static final String TABLE_FIVE ="Mesa cinco";
    public static final String TABLE_SIX ="Mesa seis";
    public static final String DATE  = "19/05";
    public static final String SUCCES_MESSAGE  = "Proceso realizado con exito";
    public static final String ERROR_MESSAGE = "Hubo un problema para realizar la accion";
    public static final int NUMBER_OF_TABLES  = 6;
    public static final int QUANTITY_COSTUMER  = 10;
    public static final int QUANTITY_OF_PRODUCTS  = 17;
    public static final int HIGH_TEMPERATURE  = 38;
    public static final int PERCENT_OF_DISCOUNT  = 10;

    public Restaurant(){
        tableList = new Table[NUMBER_OF_TABLES];
        foodList = new Food[QUANTITY_OF_PRODUCTS];
        costumerList = new Costumer[QUANTITY_COSTUMER];
        foodOrderedList = new FoodOrdered[QUANTITY_COSTUMER];
        salesList = new FoodOrdered[QUANTITY_COSTUMER];

        foodList[0] = new Food("Mariscos", 15000, FoodType.ENTRADA, 001);
        foodList[1] = new Food("Ensalada", 12000, FoodType.ENTRADA, 002);
        foodList[2] = new Food("Tostadas con pollo", 13000, FoodType.ENTRADA, 003);
        foodList[3] = new Food("Cangrejo", 25000, FoodType.PLATO_FUERTE, 011);
        foodList[4] = new Food("Carne de res al vino", 18000, FoodType.PLATO_FUERTE, 012);
        foodList[5] = new Food("Tilapia en finas hierbas", 22000, FoodType.PLATO_FUERTE, 013);
        foodList[6] = new Food("Rissotto de camarones", 23000, FoodType.PLATO_FUERTE, 014);
        foodList[7] = new Food("Gaseosa", 2500, FoodType.BEBIDA, 021);
        foodList[8] = new Food("Jugo de temporada", 3500, FoodType.BEBIDA, 022);
        foodList[9] = new Food("Vino(A)", 33000, FoodType.BEBIDA, 023);
        foodList[10] = new Food("Champania(A)", 57000, FoodType.BEBIDA, 024);
        foodList[11] = new Food("Cocktail de Maracuya(A)", 11000, FoodType.BEBIDA, 025);
        foodList[12] = new Food("Pastel de Zanahoria", 5500, FoodType.POSTRE, 031);
        foodList[13] = new Food("Brownie", 6500, FoodType.POSTRE, 032);
        foodList[14] = new Food("Tiramisu", 7000, FoodType.POSTRE, 033);

        costumerList[posCostumer] = new Costumer("Maria", 1256355, 37, 66, "19/11");
        foodOrderedList[0] = new FoodOrdered(001, costumerList[posCostumer++]);
        foodOrderedList[0].addFood(foodList[0]);
        foodOrderedList[0].addFood(foodList[3]);
        foodOrderedList[0].addFood(foodList[9]);
        foodOrderedList[0].addFood(foodList[13]);
        costumerList[posCostumer] = new Costumer("Jose", 1254665, 39, 25, "30/01");
        foodOrderedList[1] = new FoodOrdered(002, costumerList[posCostumer++]);
        foodOrderedList[1].addFood(foodList[1]);
        foodOrderedList[1].addFood(foodList[4]);
        foodOrderedList[1].addFood(foodList[8]);
        foodOrderedList[1].addFood(foodList[14]);
        costumerList[posCostumer] = new Costumer("Juan", 1287654, 36, 72, "26/08");
        foodOrderedList[2] = new FoodOrdered(003, costumerList[posCostumer++]);
        foodOrderedList[2].addFood(foodList[0]);
        foodOrderedList[2].addFood(foodList[3]);
        foodOrderedList[2].addFood(foodList[8]);
        foodOrderedList[2].addFood(foodList[14]);
        

        tableList[0] = new Table(false, TABLE_ONE);
        tableList[1] = new Table(false, TABLE_TWO);
        tableList[2] = new Table(true, TABLE_THREE);
        tableList[3] = new Table(true, TABLE_FOUR);
        tableList[4] = new Table(true, TABLE_FIVE);
        tableList[5] = new Table(true, TABLE_SIX);

        salesList[0] = foodOrderedList[0];
    }

    public String addFoodToInventory(String nameFood, int price, FoodType type, int id){
        for (int i = 0; i < foodList.length; i++) {
            if(foodList[i] == null){
                foodList[i] = new Food(nameFood, price, type, id);
                return SUCCES_MESSAGE;
            }
        }
        return ERROR_MESSAGE;
    }

    public void registerNewCostumer(String name, int id, int temperature, int age, String birthdayDate){
        for (int i = 0; i < costumerList.length; i++) {
            if(costumerList[i] == null){
                costumerList[i] = new Costumer(name, id, temperature, age, birthdayDate);
                posCostumer = i;
                return;
            }
        }
    }

    public Food returnFood(){
        return foodList[0];
    }

    public String deleteFromInventory(int id){
        for (int i = 0; i < foodList.length; i++) {
            if(foodList[i] != null && foodList[i].getId() == id){
                foodList[i] = null;
                return SUCCES_MESSAGE;
            }
        }
        return ERROR_MESSAGE;
    }

    public String bookTable(){
        for (int i = 0; i < tableList.length; i++) {
            if(tableList[i].getStatus()){
                return tableList[i].setStatusTable();
            }
        }
        return tableList[0].ERROR_MESSAGE;
    }

    public Food [] giveOptions(FoodType type){
        Food [] newList = new Food[foodList.length];
        int pos = 0;
        for (Food food : foodList) {
            if(food != null && food.getType().equals(type)){
                newList[pos++] = food;
            }            
        }
        return newList;
    }

    public void orderFood(int id){
        for (int i = 0; i < foodOrderedList.length; i++) {
            if(foodOrderedList[i] == null){
                foodOrderedList[i] = new FoodOrdered(id, costumerList[posCostumer]);
                posOrder = i;
                return;
            }
        }
    }

    public void addFoodToOrder(Food food){
        foodOrderedList[posOrder].addFood(food);
    }

    public Food checkFood(int id){
        for (Food food : foodList) {
            if(food != null && food.getId() == id){
                return food;
            }
        }
        return null;
    }

    public Table [] checkTableAvaliable(){
        Table [] newList = new Table[tableList.length];
        int pos = 0;
        for (Table table : tableList) {
            if(table != null && table.getStatus()){
                newList[pos++] = table;
            }
        }
        return newList;
    }

    public Costumer [] showCostumersInRiskByAge(int minAge){
        int pos = 0;
        Costumer [] newList = new Costumer[costumerList.length];
        for (Costumer costumer : costumerList) {
            if(costumer != null && costumer.getAge() >= minAge){
                newList[pos++] = costumer;
            }
        }
        return newList;
    }

    public Costumer [] showCostumersWithHighTemperature(){
        int pos = 0;
        Costumer [] newList = new Costumer[costumerList.length];
        for (Costumer costumer : costumerList) {
            if(costumer != null && costumer.getTemp() >= HIGH_TEMPERATURE){
                newList[pos++] = costumer;
            }
        }
        return newList;
    }

    public Costumer [] showCostumersWhoOrderesADrinkWithAlcohol(){
        Costumer [] newList = new Costumer[costumerList.length];
        int pos = 0;
        for (FoodOrdered order : foodOrderedList) {
            if(order != null && order.isThereAlcohol()){
                newList[pos++] = order.getCostumer();
            }
        }
        return newList;
    }

    public Costumer applyDiscount(){
        for (FoodOrdered order : foodOrderedList) {
            if(order != null && order.getBirthdayCostumer().equals(DATE)){
                order.setDiscount(PERCENT_OF_DISCOUNT);
                return order.getCostumer();
            }
        }
        return null;
    }

    public FoodOrdered showCheaperOrder(){
        FoodOrdered order = foodOrderedList[0];
        int cost = foodOrderedList[0].getCost();
        for (FoodOrdered food : foodOrderedList) {
            if(food != null && food.getCost() < cost){
                cost = food.getCost();
                order = food;
            }
        }
        return order;
    }

    public FoodOrdered showExpensiverOrder(){
        FoodOrdered order = foodOrderedList[0];
        int cost = foodOrderedList[0].getCost();
        for (FoodOrdered food : foodOrderedList) {
            if(food != null && food.getCost() > cost){
                cost = food.getCost();
                order = food;
            }
        }
        return order;
    }

    public String [] calculateQuantityOfSalesByType(){
        FoodType [] typeList = FoodType.values();
        String [] newList = new String[typeList.length];
        int pos = 0;
        int counter = 0;
        for (int i = 0; i < typeList.length; i++) {
            for (int j = 0; j < foodOrderedList.length; j++) {
                if(foodOrderedList[j] != null){
                    Food [] list = foodOrderedList[j].getOrder();
                    for (int k = 0; k < list.length; k++) {
                        if(list[k] != null && list[k].getType() == typeList[i]){
                            counter ++;
                        }
                    }
                }
            }
            newList[pos++] = typeList[i] + DOTS + counter;
            counter = 0;
        }
        return newList;
    }

    public String [] calculateSalesByFoodType(){
        FoodType [] typeList = FoodType.values();
        String [] newList = new String[typeList.length];
        int pos = 0;
        int cost = 0;
        for (int i = 0; i < typeList.length; i++) {
            for (int j = 0; j < foodOrderedList.length; j++) {
                if(foodOrderedList[j] != null){
                    Food [] list = foodOrderedList[j].getOrder();
                    for (int k = 0; k < list.length; k++) {
                        if(list[k] != null && list[k].getType() == typeList[i]){
                            cost += list[k].getPrice();
                        }
                    }
                }
            }
            newList[pos++] = typeList[i] + DOTS_WITH_MONEY + cost;
            cost = 0;
        }
        return newList;
    }

    public FoodOrdered [] showOrders(){
        return foodOrderedList;
    }

    public FoodOrdered payBill(int money, int id){
        FoodOrdered back = null;
        for (int i = 0; i < foodOrderedList.length; i++) {
            if(foodOrderedList[i] != null && foodOrderedList[i].getId() == id && foodOrderedList[i].getCost() <= money){
                for (int j = 0; j < salesList.length; j++) {
                    if(salesList[j] == null){
                        salesList[j] = foodOrderedList[i];
                        break;
                    }
                }
                back = foodOrderedList[i];
                foodOrderedList[i] = null;
                return back;
            }
        }
        return null;
    }

    public FoodOrdered [] payBillsByMoney(int money){
        int moneyAvaliable = money;
        FoodOrdered [] newList = new FoodOrdered[foodOrderedList.length];
        int pos = 0;
        for (int i = 0; i < foodOrderedList.length; i++) {
            if(foodOrderedList[i] != null && foodOrderedList[i].getCost() < moneyAvaliable){
                moneyAvaliable -= foodOrderedList[i].getCost();
                for (int j = 0; j < salesList.length; j++) {
                    if(salesList[j] == null){
                        salesList[j] = foodOrderedList[i];
                        break;
                    }
                }
                newList[pos++] = foodOrderedList[i];
                foodOrderedList[i] = null;
            }
        }
        return newList;
    }

    public FoodOrdered [] printSales(){
        return salesList;
    }
}
