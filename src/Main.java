import Account.CheckingAccount;
import Account.StatementMovement;
import Account.TransactionType;

public class Main {
    public static void main(String[] args) {
        var account = new CheckingAccount(10000);
        var mov1 = new StatementMovement(TransactionType.SellProducts, "Products Sold", 1000);
        var mov2 = new StatementMovement(TransactionType.BuyProducts, "Products Bought", 2000);
        var mov3 = new StatementMovement(TransactionType.PayEmployees, "Employees Paid", 5000);

        account.statement.add(mov1);
        account.statement.add(mov2);
        account.statement.add(mov3);

        System.out.println(account.balance);
        System.out.println("Total Income: " + account.TotalIncome());
        System.out.println("Total Outcome: " + account.TotalOutcome());
        System.out.println("Total Purchases: " + account.TotalPurchases());
        System.out.println("Total Employees Payment: " + account.TotalEmployeesPayments());
    }
}