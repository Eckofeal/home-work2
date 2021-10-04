package сredit;
import сlient.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Credit {

    public static int сount;

    private Client client;
    private CreditType creditType;
    private double givenMoneyAmount;
    private double backMoneyAmount;
    private double monthlyPayment;
    private double moneyPaid;
    private String moneyType;
    private Date whenIssued;
    private Date whenExpired;

    public Credit(Client client, CreditType creditType, double moneyAmount) {
        if(client != null) {
            this.client = client;
        }
        if(creditType != null) {
            this.creditType = creditType;
        }
        if(moneyAmount > creditType.getMinMoneyAmount() && moneyAmount < creditType.getMaxMoneyAmount()) {
            givenMoneyAmount = moneyAmount;
            backMoneyAmount = givenMoneyAmount + (givenMoneyAmount * creditType.getTermInYears() * (creditType.getYearPercent()/100));
            monthlyPayment = backMoneyAmount / (this.creditType.getTermInYears() * 12);
            moneyType = creditType.getMoneyType();
            whenIssued = new Date();
            whenExpired =  new Date();
            whenExpired.setTime(whenIssued.getTime());
            whenExpired.setYear(whenExpired.getYear() + creditType.getTermInYears());
            сount++;
        }
        else {
            this.client = null;
            this.creditType =  null;
            System.out.println("Incorrect amount of money in \"new Credit()\".");
        }
    }

    public Client getClient() {
        return client;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    public Date getWhenIssued() {
        return whenIssued;
    }

    public Date getWhenExpired() {
        return whenExpired;
    }

    public double getGivenMoneyAmount() {
        return givenMoneyAmount;
    }

    public double getBackMoneyAmount() {
        return backMoneyAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyPaid(double moneyPaid) {
        if(moneyPaid > 0) {
            this.moneyPaid = moneyPaid;
        }
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void printCredit() {
        System.out.printf("%-60s%s%s", "\n", "CREDIT:", "\n");
        System.out.println("1. CLIENT INFORMATION.");
        client.printClient();
        System.out.println("\n2. CREDIT TYPE.");
        creditType.printCreditType();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("\n3. CREDIT.");
        System.out.print("Bank paid to the client: " + givenMoneyAmount
                + "at " + creditType.getYearPercent()
                + "% per annum for a priod of " + creditType.getTermInYears() + " years (");
        System.out.print(dateFormat.format(whenIssued));
        System.out.print(" - ");
        System.out.print(dateFormat.format(whenExpired));
        System.out.print(").\n");
        System.out.println("\nTo be paid to the bank: " + backMoneyAmount);
        System.out.println("Monthly payment: " + monthlyPayment);
        System.out.println("Money paid: " + moneyPaid);
    }
}
