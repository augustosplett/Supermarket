package Account;
//Each line of the statement will be an object of type "StatementMovement"
public class StatementMovement {
    private TransactionType code; //let's use a code to identify if the movement is a sell or buy operation or an employeers' payment
    private String description;
    private double value;

    public StatementMovement(TransactionType code, String description, double value) {
        this.code = code;
        this.description = description;
        this.value = value;
    }

    public TransactionType getCode() {
        return code;
    }

    public void setCode(TransactionType code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
