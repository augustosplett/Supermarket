import Account.CheckingAccount;
import Account.StatementMovement;
import Account.TransactionType;
import Warehouse.Item;
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

        Item item = new Item("banana", 15);
        var warhouse = new Warehouse();
        warhouse.addItem(item);
        warhouse.displayItems();
    }
}