package Bank.currencies;

public class Euro {
    public static final String MONEYTYPE = "EUR";
    private double moneyAmount;

    public Euro(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Euro() {
        this(0);
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void printMoneyAmount() {
        System.out.println(moneyAmount + " " + MONEYTYPE);
    }
}
