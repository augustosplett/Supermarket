import Item.*;
import Item.Lotion.Engineer;
import Item.Lotion.IBuilder;
import Item.Lotion.MenLotionBuilder;
import Item.Lotion.WomanLotionBuilder;
import Item.Mobile.*;
import Warehouse.Warehouse;

public class Main {
    public static final Warehouse WAREHOUSE_CENTRAL = new Warehouse();
    public static final SuperMarket SUPER_MARKET = new SuperMarket();
    public static void main(String[] args) {

        // build WAREHOUSE_CENTRAL Items
        // create mobile items using the build design pattern
        //iphone
        IMobileBuilder apple = new appleMobileBuilder();
        ProductionDirector director = new ProductionDirector(apple);
        director.constructMobile(5);
        Mobile iphone = director.getMobile();
        WAREHOUSE_CENTRAL.addItem(iphone.getItem());
        //samsung
        IMobileBuilder samsung = new samsungMobileBuilder();
        ProductionDirector director1 = new ProductionDirector(samsung);
        director1.constructMobile(5);
        Mobile galaxy = director1.getMobile();
        WAREHOUSE_CENTRAL.addItem(galaxy.getItem());

        //create lotion items using the build design pattern
        //men's lotion
        IBuilder menLotion = new MenLotionBuilder(10);
        Engineer engineer = new Engineer(menLotion);
        engineer.createLotion();
        Item mLotion = engineer.getLotion();
        WAREHOUSE_CENTRAL.addItem(mLotion);

        //women's lotion
        IBuilder womanLotion = new WomanLotionBuilder(50);
        Engineer engineer1 = new Engineer(womanLotion);
        engineer1.createLotion();
        Item ladiesLotion = engineer1.getLotion();
        WAREHOUSE_CENTRAL.addItem(ladiesLotion);

        SUPER_MARKET.welcomePage();
        SUPER_MARKET.administrativeMenu();




        //System.out.println("Builder constructed: " + iphone.getItem().getCurrentQuantity());
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