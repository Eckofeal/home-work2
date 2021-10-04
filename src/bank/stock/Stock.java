package bank.stock;

import bank.currency.Currency;

public class Stock {

    private String companyName;
    private long stockNumber;
    private Currency costPerStock;

    public Stock(String companyName, long stockNumber, Currency costPerShare) {
        this.companyName = companyName;
        this.stockNumber = stockNumber;
        this.costPerStock = costPerShare;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setSharesNumber(long stockNumber) {
        this.stockNumber = stockNumber;
    }

    public long getSharesNumber() {
        return stockNumber;
    }

    public void setCostPerStock(Currency costPerStock) {
        this.costPerStock = costPerStock;
    }

    public Currency getCostPerStock() {
        return costPerStock;
    }

    public void printStock() {
        System.out.println("Shares of the company \"" + companyName + "\":");
        System.out.println("Cost per share: " + costPerStock.getAmount() + " " + costPerStock.getType());
    }
}
