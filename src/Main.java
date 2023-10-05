import Item.Item;
import Item.MenLotionBuilder;
import Item.WomanLotionBuilder;
import Item.Engineer;
import Warehouse.Warehouse;

public class Main {
    public static void main(String[] args) {
//        var account = new CheckingAccount(10000);
//        var mov1 = new StatementMovement(TransactionType.SELL_PRODUCTS, "Products Sold", 1000);
//        var mov2 = new StatementMovement(TransactionType.BUY_PRODUCTS, "Products Bought", 2000);
//        var mov3 = new StatementMovement(TransactionType.PAY_EMPLOYEES, "Employees Paid", 5000);
//
//        account.SaveMovementToStatement(mov1);
//        account.SaveMovementToStatement(mov2);
//        account.SaveMovementToStatement(mov3);
//
//        System.out.println(account.balance);
//        System.out.println("Total Income: " + account.TotalIncome());
//        System.out.println("Total Outcome: " + account.TotalOutcome());
//        System.out.println("Total Purchases: " + account.TotalPurchases());
//        System.out.println("Total Employees Payment: " + account.TotalEmployeesPayments());

        Item banana = new Item("banana", 15, 5,0,5);
        Item apples = new Item("apple", 15, 5,0,5);
        Item watermelon = new Item("watermelon", 15, 5,0,5);
        Item strawberry = new Item("strawberry", 15, 5,0,5);
        var warehouse = new Warehouse();
        warehouse.addItem(banana);
        warehouse.addItem(apples);
        warehouse.addItem(watermelon);
        warehouse.addItem(strawberry);
        System.out.println("Warehouse before Buyers");
        warehouse.displayItems();

        var buyer = new Warehouse();
        System.out.println("Buyer before Buy");
        buyer.displayItems();

        buyer.buyItems(warehouse, buyer, banana);
        System.out.println("Buyer after Buy");

        buyer.displayItems();

        System.out.println("Warehouse after Buyers");
        warehouse.displayItems();
        System.out.println("Statement: ");
        buyer.account.DisplayStatement();
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