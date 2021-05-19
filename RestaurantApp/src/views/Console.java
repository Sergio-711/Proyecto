package views;

import java.util.Scanner;
import models.FoodOrdered;
import models.Table;
import models.Costumer;
import models.Food;

public class Console {
    
    public static final String WELCOME_MESSAGE = "Bienvenido a nuestro restaurante, esperamos la estadia sea de su agrado\n";
    public static final String GET_NAME_MESSAGE = "Ingrese su nombre:";
    public static final String GET_ID = "Ingrese su numero de identificacion:";
    public static final String GET_TEMP = "Ingrese su temperatura:";
    public static final String GET_AGE = "Ingrese su edad:";
    public static final String GET_BIRTHDAY_DAY = "Ingrese su fecha de nacimiento:";
    public static final String MENU = "1) Aniadir inventario\n2) Reservar mesa\n3) Ordenar comida\n4) Mirar disponibilidad de mesas\n5) Mostrar clientes en riesgo sanitario por la edad\n6) Mostrar clientes con temperatura alta\n7) Mostrar orden mas barata\n8) Mostrar orden mas costosa\n9) Mostrar clientes que ordenaron una bebida con alcohol\n10) Mostrar cantidad de ventas por categoria\n11) Calcular ventas por categoria\n12) Obtener descuento por cumpleanos\n13) Imprimir pedidos\n14) Pagar una cuenta\n15) Pagar la mayor cantidad de cuentas posibles\n16) Imprimir ventas\n17) Eliminar del inventario\n18) Salir\n---> Seleccione una opcion del numero correspondiente por medio del teclado <---";
    public static final String MESSAGE_TO_WRITE = "---> Escriba el codigo correspondiente a su eleccion por medio del teclado, en caso de ser una bebida las que tengan una (A) es porque contienen alcohol <---\n";
    public static final String MESSAGE_TO_ORDER_MORE = "¿Desea ordenar algo mas? Ingrese 1 para si y 0 para no.\n";
    public static final String MESSAGE_GET_ID_ORDER = "Ingrese el id que le quiere dar a su factura\n";
    public static final String MESSAGE_TO_GET_MIN_AGE = "Ingrese la edad minima para que una persona se considere en riesgo:\n";
    public static final String MESSAGE_AVALIABLE_TABLE = "Las mesas disponibles son:\n";
    public static final String MESSAGE_SHOW_COSTUMER_IN_RISK  = "Los clientes que estan en riesgo por edad son:\n";
    public static final String MESSAGE_TO_SHOW_COSTUMER_WITH_HIGH_TEMP = "Los clientes que superan un temperatura de 38 grados son:\n";
    public static final String MESSAGE_SHOW_COSTUMER_WHO_ORDERED_LIQUOR  = "Los clientes que ordenaron bebidas con alcohol son:\n";
    public static final String MESSAGE_SHOW_APPLY_DISCOUNT = "Al cliente que se le aplico descuento por su cumpleanios fue:\n";
    public static final String MESSAGE_EXPENSIVER_ORDER = "La orden mas cara fue:\n";
    public static final String MESSAGE_CHEAPER_ORDER = "La orden mas económica fue:\n";
    public static final String MESSAGE_SHOW_QUANTITY_OF_SALES_BY_TYPE = "El numero de cantidad de ventas por categoria fue: \n";
    public static final String MESSAGE_SHOW_COST_BY_TYPE = "Las ventas por tipo de comida:\n";
    public static final String MESSAGE_TO_ADD_FOOD_INVENTORY = "Ingrese el nombre del producto\n";
    public static final String MESSAGE_TO_ADD_PRICE = "Ingrese el precio\n";
    public static final String MESSAGE_TO_SET_TYPE = "Ingrese la categoria del producto:\n1) ENTRADA\n2) PLATO FUERTE\n3) BEBIDA\n4) POSTRE\n";
    public static final String MESSAGE_TO_SET_ID = "Ingrese el id del producto:\n";
    public static final String MESSAGE_GET_MONEY = "Ingrese la cantidad de dinero con la que va a pagar:\n";
    public static final String MESSAGE_GET_ID_REQUEST = "Ingrese el id de la factura:\n";
    public static final String MESSAGE_TO_PRINT_SALES = "Las facturas que han sido pagadas son: \n";
    public static final String MESSAGE_TO_THANKS = "-------->Gracias por venir, vuelva pronto<---------\n";
    private Scanner scanner;

    public Console(){
        scanner = new Scanner(System.in);
    }

    public void printWelcomeMessage(){
        System.out.println(WELCOME_MESSAGE);
    }

    public String getName(){
        System.out.println(GET_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public int getId(){
        System.out.println(GET_ID);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getIdProduct(){
        System.out.println(MESSAGE_TO_SET_ID);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getTemp(){
        System.out.println(GET_TEMP);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getAge(){
        System.out.println(GET_AGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public String getBirthday(){
        System.out.println(GET_BIRTHDAY_DAY);
        return scanner.nextLine();
    }

    public int printMenu(){
        System.out.println(MENU);
        return Integer.parseInt(scanner.nextLine());
    }

    public String getNewName(){
        System.out.println(MESSAGE_TO_ADD_FOOD_INVENTORY);
        return scanner.nextLine();
    }

    public int getNewPrice(){
        System.out.println(MESSAGE_TO_ADD_PRICE);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getNewType(){
        System.out.println(MESSAGE_TO_SET_TYPE);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getNewId(){
        System.out.println(MESSAGE_TO_SET_ID);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printAvaliableTable(String answer){
        System.out.println(answer + "\n");
    }

    public int askToOrderMore(){
        System.out.println(MESSAGE_TO_ORDER_MORE);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getFood(Food [] list){
        for (Food food : list) {
            if(food != null){
                System.out.println(food);
            }
        }
        System.out.println("\n" + MESSAGE_TO_WRITE);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getIdOfOrder(){
        System.out.println(MESSAGE_GET_ID_ORDER);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printTableAvaliable(Table [] list){
        System.out.println(MESSAGE_AVALIABLE_TABLE);
        for (Table table : list) {
            if(table != null){
                System.out.println(table);
            }
        }
        System.out.println("\n");
    }

    public int getMinAge(){
        System.out.println(MESSAGE_TO_GET_MIN_AGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printCostumersInRisk(Costumer[] list){
        System.out.println(MESSAGE_SHOW_COSTUMER_IN_RISK);
        for (Costumer costumer : list) {
            if(costumer != null){
                System.out.println(costumer);
            }
        }
        System.out.println("\n");
    }

    public void printCostumersWithHighTemp(Costumer[] list){
        System.out.println(MESSAGE_TO_SHOW_COSTUMER_WITH_HIGH_TEMP);
        for (Costumer costumer : list) {
            if(costumer != null){
                System.out.println(costumer);
            }
        }
        System.out.println("\n");
    }

    public void printCostumersWhoOrderedLiquor(Costumer [] list){
        System.out.println(MESSAGE_SHOW_COSTUMER_WHO_ORDERED_LIQUOR);
        for (Costumer costumer : list) {
            if(costumer != null){
                System.out.println(costumer);
            }
        }
        System.out.println("\n");
    }

    public void printCostumerWithDiscount(Costumer costumer){
        System.out.println(MESSAGE_SHOW_APPLY_DISCOUNT + costumer + "\n");
    }

    public void printCheaperOrder(FoodOrdered order){
        System.out.println(MESSAGE_CHEAPER_ORDER + order + "\n");
    }

    public void printExpensiverOrder(FoodOrdered order){
        System.out.println(MESSAGE_EXPENSIVER_ORDER + order + "\n");
    }

    public void printQuantityOfSalesByType(String [] list){
        System.out.println(MESSAGE_SHOW_QUANTITY_OF_SALES_BY_TYPE);
        for (String string : list) {
            if(string != null){
                System.out.println(string);
            }
        }
        System.out.println("\n");
    }

    public void printSalesByFoodType(String [] list){
        System.out.println(MESSAGE_SHOW_COST_BY_TYPE);
        for (String string : list) {
            if(string != null){
                System.out.println(string);
            }
        }
        System.out.println("\n");
    }

    public int getMoney(){
        System.out.println(MESSAGE_GET_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getIdBill(){
        System.out.println(MESSAGE_GET_ID_REQUEST);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printAllOrder(FoodOrdered[] list){
        for (FoodOrdered foodOrdered : list) {
            if(foodOrdered != null){
                System.out.println(foodOrdered);
            }
        }
        System.out.println("\n");
    }

    public void printPayment(FoodOrdered order){
        System.out.println(order + "\n");
    }

    public void printManyPayments(FoodOrdered [] list){
        for (FoodOrdered foodOrdered : list) {
            if(foodOrdered != null){
                System.out.println(foodOrdered);
            }
        }
        System.out.println("\n");
    }

    public void printSales(FoodOrdered [] list){
        for (FoodOrdered foodOrdered : list) {
            if(foodOrdered != null){
                System.out.println(foodOrdered);
            }
        }
        System.out.println("\n");
    }

    public void printMessage(String answer){
        System.out.println(answer + "\n");
    }

    public void printMessageToThanks(){
        System.out.println(MESSAGE_TO_THANKS);
    }
}
