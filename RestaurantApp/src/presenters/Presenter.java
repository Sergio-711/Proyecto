package presenters;

import models.Restaurant;
import models.FoodType;
import models.Food;
import models.Table;
import models.Costumer;
import models.FoodOrdered;
import views.Console;


public class Presenter {
    
    public static final int CASE_ADD_TO_INVENTORY = 1;
    public static final int CASE_VALIDATE_TABLE = 2;
    public static final int CASE_ORDER_FOOD = 3;
    public static final int CASE_CHECK_TABLE_AVALIABILITY = 4;
    public static final int CASE_SHOW_COSTUMERS_IN_RISK_BY_AGE = 5;
    public static final int CASE_SHOW_COSTUMERS_WITH_HIGH_TEMPERATURE = 6;
    public static final int CASE_SHOW_CHEAPER_ORDER = 7;
    public static final int CASE_SHOW_EXPENSIVER_ORDER = 8;
    public static final int CASE_SHOW_COSTUMERS_WHO_ORDERED_LIQUOR = 9;
    public static final int CASE_SHOW_QUANTITY_OF_SALES_BY_TYPE = 10;
    public static final int CASE_CALCULATE_SALES_BY_FOOD_TYPE = 11;
    public static final int CASE_GET_DISCOUNT_BIRTHDAY = 12;
    public static final int CASE_PRINT_ORDERS = 13;
    public static final int CASE_PAY_ONE_BILL = 14;
    public static final int CASE_PAY_THE_BILLS_AS_POSSIBLE = 15;
    public static final int CASE_PRINT_SALES = 16;
    public static final int CASE_DELETE_INVENTORY = 17;
    public static final int EXIT = 18;
    public static final int CASE_TYPE_ENTRACE = 1;
    public static final int CASE_TYPE_HIGHLIGTH = 2;
    public static final int CASE_TYPE_DRINK = 3;
    public static final int CASE_TYPE_DESSERT = 4;
    private Console console;
    private Restaurant rest;

    public Presenter(){
        rest = new Restaurant();
        console = new Console();
        runTest();
        printWelcomeMessage();
        showMenu();
    }

    public void printWelcomeMessage(){
        console.printWelcomeMessage();
        rest.registerNewCostumer(console.getName(), console.getId(), console.getTemp(), console.getAge(), console.getBirthday());
    }

    public FoodType solveType(int option){
        switch(option){
            case CASE_TYPE_ENTRACE:
                return FoodType.ENTRADA;
            case CASE_TYPE_HIGHLIGTH:
                return FoodType.PLATO_FUERTE;
            case CASE_TYPE_DRINK:
                return FoodType.BEBIDA;
            case CASE_TYPE_DESSERT:
                return FoodType.POSTRE;
            default:
                return null;
        }
    }

    public void showMenu(){
        int option = console.printMenu();
        switch(option){
            case CASE_ADD_TO_INVENTORY:
                addInventory();
                break;
            case CASE_VALIDATE_TABLE:
                validateTable();
                break;
            case CASE_ORDER_FOOD:
                orderFood();
                break;
            case CASE_CHECK_TABLE_AVALIABILITY:
                checkTableAvaliability();
                break;
            case CASE_SHOW_COSTUMERS_IN_RISK_BY_AGE:
                showCostumersInRisk();
                break;
            case CASE_SHOW_COSTUMERS_WITH_HIGH_TEMPERATURE:
                showCostumersWithHighTemp();
                break;
            case CASE_SHOW_CHEAPER_ORDER:
                showCheaperOrder();
                break;
            case CASE_SHOW_EXPENSIVER_ORDER:
                showExpensiverOrder();
                break;
            case CASE_SHOW_COSTUMERS_WHO_ORDERED_LIQUOR:
                showCostumersWhoOrderedLiquor();
                break;
            case CASE_SHOW_QUANTITY_OF_SALES_BY_TYPE:
                showQuantityOfSalesByType();
                break;
            case CASE_CALCULATE_SALES_BY_FOOD_TYPE:
                calculateSalesByCategory();
                break;
            case CASE_GET_DISCOUNT_BIRTHDAY:
                getDiscount();
                break;
            case CASE_PRINT_ORDERS:
                printOrders();
                break;
            case CASE_PAY_ONE_BILL:
                payOneBill();
                break;
            case CASE_PAY_THE_BILLS_AS_POSSIBLE:
                payBillsAsPossible();
                break;
            case CASE_PRINT_SALES:
                printSales();;
                break;
            case CASE_DELETE_INVENTORY:
                deleteFromInventory();
                break;
            case EXIT:
                console.printMessageToThanks();
                return;
            default:
                showMenu();
                break;
        }
        showMenu();
    }

    public void addInventory(){
        console.printMessage(rest.addFoodToInventory(console.getNewName(), console.getNewPrice(), solveType(console.getNewType()), console.getNewId()));
    }

    public void validateTable(){
        console.printAvaliableTable(rest.bookTable());
    }

    public void orderFood(){
        int count = 0;
        rest.orderFood(console.getIdOfOrder());
        do{
            int answer = console.getFood(rest.giveOptions(solveType(console.getNewType())));
            rest.addFoodToOrder(rest.checkFood(answer));
            count++;
        }while(console.askToOrderMore() == 1 && count < 10);
    }

    public void checkTableAvaliability(){
        console.printTableAvaliable(rest.checkTableAvaliable());
    }

    public void showCostumersInRisk(){
        console.printCostumersInRisk(rest.showCostumersInRiskByAge(console.getMinAge()));
    }

    public void showCostumersWithHighTemp(){
        console.printCostumersWithHighTemp(rest.showCostumersWithHighTemperature());
    }

    public void showCheaperOrder(){
        console.printCheaperOrder(rest.showCheaperOrder());
    }

    public void showExpensiverOrder(){
        console.printExpensiverOrder(rest.showExpensiverOrder());
    }

    public void showCostumersWhoOrderedLiquor(){
        console.printCostumersWhoOrderedLiquor(rest.showCostumersWhoOrderesADrinkWithAlcohol());
    }

    public void showQuantityOfSalesByType(){
        console.printQuantityOfSalesByType(rest.calculateQuantityOfSalesByType());
    }

    public void calculateSalesByCategory(){
        console.printSalesByFoodType(rest.calculateSalesByFoodType());
    }

    public void getDiscount(){
        console.printCostumerWithDiscount(rest.applyDiscount());
    }

    public void printOrders(){
        console.printAllOrder(rest.showOrders());
    }

    public void payOneBill(){
        console.printPayment(rest.payBill(console.getMoney(), console.getIdBill()));
    }

    public void payBillsAsPossible(){
        console.printManyPayments(rest.payBillsByMoney(console.getMoney()));
    }

    public void printSales(){
        console.printSales(rest.printSales());
    }

    public void deleteFromInventory(){
        console.printMessage(rest.deleteFromInventory(console.getIdProduct()));
    }

    public void runTest(){
        if(rest.bookTable().equals("Reservacion exitosa, su mesa es: Mesa tres")){
            System.out.println("Prueba #1 paso");
        }else{
            System.out.println("Prueba #1 fallo");
        }
        if(rest.deleteFromInventory(56).equals("Hubo un problema para realizar la accion")){
            System.out.println("Prueba #2 paso");
        }else{
            System.out.println("Prueba #2 fallo");
        }
        Food [] testList = new Food[5];
        int count = 0;
        if(rest.checkFood(1) == rest.returnFood()){
            System.out.println("Prueba #3 paso");
        }else{
            System.out.println("Prueba #3 fallo");
        }
        Table [] test = rest.checkTableAvaliable();
        count = 0;
        for (Table table : test) {
            if (table != null) {
                count++;
            }
        }
        if(count == 3){
            System.out.println("Prueba #4 paso");
        }else{
            System.out.println("Prueba #4 fallo");
        }
        Costumer [] testC = rest.showCostumersInRiskByAge(60);
        count = 0;
        for (Costumer costumer : testC) {
            if(costumer != null){
                count++;
            }
        }
        if(count == 2){
            System.out.println("Prueba #5 paso");
        }else{
            System.out.println("Prueba #5 fallo");
        }
        testC = rest.showCostumersWithHighTemperature();
        count = 0;
        for (Costumer costumer : testC) {
            if(costumer != null){
                count++;
            }
        }
        if(count == 1){
            System.out.println("Prueba #6 paso");
        }else{
            System.out.println("Prueba #6 fallo");
        }
        testC = rest.showCostumersWhoOrderesADrinkWithAlcohol();
        count = 0;
        for (Costumer costumer : testC) {
            if (costumer != null) {
                count++;
            }
        }
        if(count == 1){
            System.out.println("Prueba #7 paso");
        }else{
            System.out.println("Prueba #7 fallo");
        }
        Costumer costumer = rest.applyDiscount();
        if(costumer == null){
            System.out.println("Prueba #8 paso");
        }else{
            System.out.println("Prueba #8 fallo");
        }
        FoodOrdered foodO = rest.showCheaperOrder();
        if(foodO.getNameCostumer().equals("Jose")){
            System.out.println("Prueba #9 paso");
        }else{
            System.out.println("Prueba #9 fallo");
        }
        foodO = rest.showExpensiverOrder();
        if(foodO.getNameCostumer().equals("Maria")){
            System.out.println("Prueba #10 paso");
        }else{
            System.out.println("Prueba #10 fallo");
        }
        String [] catL = rest.calculateQuantityOfSalesByType();
        if(catL[0].equals("ENTRADA: 3")){
            System.out.println("Prueba #11 paso");
        }else{
            System.out.println("Prueba #11 fallo");
        }
        catL = rest.calculateSalesByFoodType();
        if(catL[0].equals("ENTRADA: $42000")){
            System.out.println("Prueba #12 paso");
        }else{
            System.out.println("Prueba #12 fallo");
        }
    }

    public static void main(String[] args) {
        new Presenter(); 
    }
}
