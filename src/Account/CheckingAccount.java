package Account;


import java.util.ArrayList;

public class CheckingAccount {

    private ArrayList<StatementMovement> statement;//modify to private and implement a method to insert into the statement

    public CheckingAccount() {

        this.statement = new ArrayList<StatementMovement>();
    }

    public void SaveMovementToStatement(StatementMovement movement){
        this.statement.add(movement);
    }
    public void DisplayStatement(){
        for(StatementMovement mov: statement){
            System.out.println("Code: " + mov.getCode()
                            + " Description: " + mov.getDescription()
                            + " Value: " + mov.getValue());
        }
    }
    public double TotalIncome(){
        return SumTransaction(TransactionType.SELL_PRODUCTS);
    }

    public double TotalOutcome(){
        return
            SumTransaction(TransactionType.BUY_PRODUCTS) +
            SumTransaction(TransactionType.PAY_EMPLOYEES);
    }

    public double TotalPurchases(){
        return SumTransaction(TransactionType.BUY_PRODUCTS);
    }

    public double TotalEmployeesPayments(){
        return SumTransaction(TransactionType.PAY_EMPLOYEES);
    }

    private double SumTransaction(TransactionType transType){
        double amount = 0;
        for(StatementMovement mov : statement){
            if (mov.getCode() == transType){
                amount += mov.getValue();
            }
        }
        return amount;
    }

    private double balance(){
        //implement the function to calculate the balance
        return 0.0;
    }
}
