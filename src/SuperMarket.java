import Account.CheckingAccount;
import Account.StatementMovement;
import Account.TransactionType;
import Item.Item;
import Warehouse.Warehouse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SuperMarket {

    long lastEmployeesPayment;
    public CheckingAccount account ;
    public Warehouse warehouse;

    public SuperMarket() {
        this.lastEmployeesPayment = System.currentTimeMillis();
        this.warehouse = new Warehouse();
        this.account = new CheckingAccount();

    }
    private void registerEmployeesPayment(long time, double value){
        var transaction = new StatementMovement(TransactionType.PAY_EMPLOYEES,
                "Payment for " + time + " seconds of work.",
                value);
        this.account.SaveMovementToStatement(transaction);
    }
    public void registerBuyTransaction(int quantity, Item item) {
        var transaction =
                new StatementMovement(TransactionType.BUY_PRODUCTS,
                        quantity + " - " + item.getName(),
                        quantity * item.getPrice());
        this.account.SaveMovementToStatement(transaction);
    }

    public void refillWarehouse(Warehouse origin, Item item, int quantity){
        this.warehouse.buyItem(origin, item, quantity);
        registerBuyTransaction(quantity, item);
    }

    public void welcomePage(){
        System.out.println("Hello Mr/Ms Administrator!");
        System.out.format("Date and Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")) +"%n");
        salesBalance();
        profitAndLossStatement();
    }

    public void salesBalance(){
        String tableFormat = "| %-30s | %-8d | $ %-11.2f |%n";

        System.out.println("\nSALES BALANCE:");
        System.out.println();
        System.out.println("+--------------------------------+----------+---------------+");
        System.out.println("| DESCRIPTION                    | QUANTITY | AMOUNT        |");
        System.out.println("+--------------------------------+----------+---------------+");

        System.out.format(tableFormat,
                "Total items bought ",
                this.warehouse.getItemsBought(),
                this.account.TotalPurchases());

        System.out.format(tableFormat,
                "Total items sold ",
                this.warehouse.getItemsSold(),
                this.account.TotalIncome());

        System.out.println("+--------------------------------+----------+---------------+");
    }

    public void profitAndLossStatement(){

        String profitTableFormat = "| %-40s | $ %-12.2f |%n";

        System.out.println("\nPROFIT AND LOSS STATEMENT:");
        System.out.println();
        System.out.println("+------------------------------------------+----------------+");
        System.out.println("| DESCRIPTION                              | AMOUNT         |");
        System.out.println("+------------------------------------------+----------------+");

        System.out.format(profitTableFormat,
                "1 - Total items purchased",
                this.account.TotalPurchases()
                );

        System.out.format(profitTableFormat,
                "2 - Total employees' salary",
                this.account.TotalEmployeesPayments()
        );

        System.out.println("+------------------------------------------+----------------+");

        System.out.format(profitTableFormat,
                "A - TOTAL EXPENSES (1 + 2)",
                this.account.TotalOutcome()
        );

        System.out.println("+------------------------------------------+----------------+");

        System.out.format(profitTableFormat,
                "B - Sales Income",
                this.account.TotalIncome()
        );

        System.out.println("+------------------------------------------+----------------+");

        System.out.format(profitTableFormat,
                "C - PROFIT (B - A)",
                this.account.TotalIncome()
                        - this.account.TotalPurchases()
                        - this.account.TotalEmployeesPayments()
        );

        System.out.println("+------------------------------------------+----------------+");
    }

    public void administrativeMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("+------------------------------------------------------------+");
        System.out.println("| ADMINISTRATIVE MENU                                        |");
        System.out.println("+------------------------------------------------------------+");
        System.out.println("| 1 - PAY EMPLOYEES                                          |");
        System.out.println("| 2 - BUY ITEMS TO YOUR WAREHOUSE                            |");
        System.out.println("| 3 - SELL ITEMS ON YOUR WAREHOUSE                           |");
        System.out.println("| 4 - CONSULT YOUR WAREHOUSE                                 |");
        System.out.println("| 5 - SEE STATEMENTS                                         |");
        System.out.println("| 6 - EXIT                                                   |");
        System.out.println("+------------------------------------------------------------+");
        System.out.print(" ENTER YOUR CHOICE: ");
        handleUserChoice(Integer.parseInt(scanner.next()));
    }

    public void showItemsOnWarehouseSeller(Warehouse origin){
        Scanner scanner = new Scanner(System.in);

        origin.availableItemsWithQuantityTable();
        System.out.print("Enter the item you want to buy: ");
        int chosenItem =Integer.parseInt(scanner.next());
        System.out.print("Enter how much of this item you want to buy: ");
        int qtde =Integer.parseInt(scanner.next());

        Item item = origin.inventory.get(chosenItem - 1);

        this.refillWarehouse(origin, item, qtde);
    }

    public void handleUserChoice(int userInput){
        switch (userInput){
            case 1:
                //pay employees and register transaction.
                payEmployees();
                administrativeMenu();
                break;
            case 2:
                //just buying using the name is missing
                showItemsOnWarehouseSeller(Main.WAREHOUSE_CENTRAL);
                administrativeMenu();
                break;
            case 3:
                System.out.println("menu3");
                break;
            case 4:
                this.warehouse.availableItemsWithQuantityTable();
                //implement method to ask if the user wants to see more details of the items on the warehouse
                administrativeMenu();
                break;
            case 5:
                //show balances and statements
                salesBalance();
                profitAndLossStatement();
                administrativeMenu();
                break;
            case 6:
                System.exit(0);
                break;

        }
    }

    public void payEmployees(){
        long elapsed = System.currentTimeMillis() - lastEmployeesPayment; //check how much time since last payment
        lastEmployeesPayment = System.currentTimeMillis(); //set a new last payment time
        var cost = 2600 / 60; //transform the cost from minute to second
        var amountOfTime = elapsed / 1000; //transform milliseconds to seconds
        var employeesPaymentAmount =  cost * amountOfTime; //calculate the total amount to be paid
        registerEmployeesPayment(amountOfTime, employeesPaymentAmount);//register the transaction
    }
}
