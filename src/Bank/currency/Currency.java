package bank.currency;

public class Currency {

    public static final String USD = "USD";
    public static final String EURO = "EUR";
    public static final String BYN = "BYN";
    public static final String RUB = "RUB";

    private String type;
    private double amount;

    public Currency(double moneyAmount, String moneyType) {
        if(moneyAmount != 0) {
            this.amount = moneyAmount;
        }
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setType(String type) {
        if(!type.isEmpty()) {
            this.type = type;
        }
    }

    public String getType() {
        return type;
    }

    public void printMoneyAmount() {
        System.out.println(amount + " " + type);
    }
}
