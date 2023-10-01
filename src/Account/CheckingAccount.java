package Account;

import java.util.ArrayList;

public class CheckingAccount {
    public double balance;
    public ArrayList<StatementMovement> statement;//modify to private and implement a method to insert into the statement

    public CheckingAccount(double balance) {
        this.balance = balance;
        this.statement = new ArrayList<StatementMovement>();
    }

    public double TotalIncome(){
        return SumTransaction(TransactionType.SellProducts);
    }

    public double TotalOutcome(){
        return
            SumTransaction(TransactionType.BuyProducts) +
            SumTransaction(TransactionType.PayEmployees);
    }

    public double TotalPurchases(){
        return SumTransaction(TransactionType.BuyProducts);
    }

    public double TotalEmployeesPayments(){
        return SumTransaction(TransactionType.PayEmployees);
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

}
