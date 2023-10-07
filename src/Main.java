import Item.Item;
import Warehouse.Warehouse;

public class Main {
    public static final Warehouse WAREHOUSE_CENTRAL = new Warehouse();
    public static final SuperMarket SUPER_MARKET = new SuperMarket();
    public static void main(String[] args) {

        Item banana = new Item("banana", 150, 5,0,5);
        Item apples = new Item("apple", 15, 5,0,5);
        Item watermelon = new Item("watermelon", 5555, 5,0,5);
        Item strawberry = new Item("strawberry", 15, 5,0,5);


        WAREHOUSE_CENTRAL.addItem(banana);
        WAREHOUSE_CENTRAL.addItem(apples);
        WAREHOUSE_CENTRAL.addItem(watermelon);
        WAREHOUSE_CENTRAL.addItem(strawberry);

        SUPER_MARKET.refillWarehouse(WAREHOUSE_CENTRAL, banana,2);
        SUPER_MARKET.refillWarehouse(WAREHOUSE_CENTRAL, apples,3);
        SUPER_MARKET.welcomePage();
        SUPER_MARKET.administrativeMenu();

//        MenLotionBuilder menLotionBuilder= new MenLotionBuilder();
//        Engineer engineerMen = new Engineer(menLotionBuilder);
//        engineerMen.createLotion();
//        engineerMen.getLotion().display();
//        WomanLotionBuilder womanLotionBuilder= new WomanLotionBuilder();
//        Engineer engineerWmn = new Engineer(womanLotionBuilder);
//        engineerWmn.createLotion();
//        engineerWmn.getLotion().display();


    }
}