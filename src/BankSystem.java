import Bank.*;
import Bank.currencies.*;
import Client.Client;
import Credit.*;
import Work.Work;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class BankSystem {
    //imagine that the exchange rates are the same and unchanged in all banks
    private final static double USDBUY;
    private final static double USDSELL;
    private final static double EUROBUY;
    private final static double EUROSELL;
    private final static double RUBBUY;
    private final static double RUBSELL;
    ArrayList<Bank> bankList;
    static {
        USDBUY = 2.495;
        USDSELL = 2.515;
        EUROBUY = 2.9;
        EUROSELL = 2.912;
        RUBBUY = 3.42;
        RUBSELL = 3.46;
    }

    public BankSystem() {
        bankList = new ArrayList<>();
    }

    public void setBankList(ArrayList<Bank> bankList) {
        if(bankList != null) this.bankList = bankList;
    }

    public ArrayList<Bank> getBankList() {
        return bankList;
    }

    public void addBank(Bank bank){
        if (bank == null) return;

            if (bankList.indexOf(bank) == -1) {
                bankList.add(bank);
            } else {
                System.out.println("Bank.Bank already exist.");
                return;
            }
    }

    public static void exchangeRates() {
        System.out.printf("%-60s%s%s", "\n", "EXCHANGE RATES:", "\n");
        System.out.printf("%15s %8s%n",  "BUY", "SELL");
        System.out.printf("%-12s%-8s%-6s%s%n", "1 USD", USDBUY, USDSELL, "BYN");
        System.out.printf("%-12s%-8s%-6s%s%n", "1 EURO", EUROBUY, EUROSELL, "BYN");
        System.out.printf("%-12s%-8s%-6s%s%n", "1 RUB", RUBBUY, RUBSELL, "BYN");
    }

    public static void info() {
        System.out.printf("%-60s%s%s", "\n", "BANK SYSTEM INFORMATION:", "\n");
        System.out.println("Number of banks in system: " + Bank.bankCount);
        System.out.println("Credits issued: " + Credit.creditCount);
        System.out.println("Number types of credits in banks: " + CreditType.creditTypeCount);
        System.out.println("Number of bank clients: " + Client.clientCount);
    }
    //OVERLOADED 5
    public void searchForCreditType(String moneyType) {
        System.out.printf("%-60s%s%s", "\n", "CREDIT SEARCH RESULT:", "\n");
        if (moneyType.isEmpty()) {
            System.out.println("No credits found for your request.");
        }
        else if(moneyType == "BYN" || moneyType == "RUB" || moneyType == "USD" || moneyType == "EUR") {
            if(!bankList.isEmpty()) {
                for(Bank element : bankList) {
                    if(element.findCreditType(moneyType) != null && element.findCreditType(moneyType).size() != 0) {
                        for(CreditType creditTypeElement : element.findCreditType(moneyType)) {
                            System.out.print("Bank \"" + element.getNameOfBank() + "\" : ");
                            creditTypeElement.printCreditType();
                        }
                    }
                }
            }
            else {
                System.out.println("No credits found for your request.");
            }
        }
        else {
            System.out.println("No credits found for your request.");
        }
    }
    //OVERLOADED 5
    public void searchForCreditType(String moneyType, double moneyAmount) {
        System.out.printf("%-60s%s%s", "\n", "CREDIT SEARCH RESULT:", "\n");
        if (moneyType.isEmpty() || moneyAmount == 0) {
            System.out.println("No credits found for your request.");
        }
        else if(moneyType == "BYN" || moneyType == "RUB" || moneyType == "USD" || moneyType == "EUR") {
            if(!bankList.isEmpty()) {
                int flag = 0;
                for(Bank element : bankList) {
                    if(element.findCreditType(moneyType, moneyAmount) != null && element.findCreditType(moneyType, moneyAmount).size() != 0) {
                        for(CreditType creditTypeElement : element.findCreditType(moneyType, moneyAmount)) {
                            System.out.print("Bank \"" + element.getNameOfBank() + "\" : ");
                            creditTypeElement.printCreditType();
                        }
                    }
                    else {
                       flag++;
                    }
                }
                if(flag == bankList.size()) System.out.println("No credits found for your request.");
            }
            else {
                System.out.println("No credits found for your request.");
            }
        }
        else {
            System.out.println("No credits found for your request.");
        }
    }

    public static void main(String[] args) {
        Byn byn1 = new Byn(1000000);
        Rub rub1 = new Rub(1250000);
        Euro eur1 = new Euro(150000);
        Usd usd1 = new Usd(175000);
        Byn byn2 = new Byn(2000000);
        Euro eur2 = new Euro(250000);
        Usd usd2 = new Usd(275000);
        Rub rub2 = new Rub(2250000);
        Byn byn3 = new Byn(3000000);
        Rub rub3 = new Rub(3250000);
        Euro eur3 = new Euro(350000);
        Usd usd3 = new Usd(375000);
        Byn byn4 = new Byn(4000000);
        Rub rub4 = new Rub(4250000);
        Euro eur4 = new Euro(450000);
        Usd usd4 = new Usd(475000);
        Bank bank1 = new Bank("Commercial Banking",
                LocalDateTime.of(2017, Month.JULY, 9, 12, 0), usd1, eur1, rub1, byn1);
        Bank bank2 = new Bank("Finance",
                LocalDateTime.of(2000, Month.AUGUST, 26, 0, 0), usd2, eur2, rub2, byn2);
        Bank bank3 = new Bank("Future's",
                LocalDateTime.of(1993, Month.MAY, 3, 18, 6), usd2, eur2, rub2, byn2);
        Bank bank4 = new Bank("Absolute",
                LocalDateTime.of(1886, Month.DECEMBER,31, 23, 59), usd3, eur3, rub3, byn3);
        Work work1 = new Work("Google", "Sales Manager", 6500, Usd.MONEYTYPE);
        Work work2 = new Work("KFC", "Restaurant Crew", 850, Byn.MONEYTYPE);
        Work work3 = new Work("Adidas", "Production Line Engineer", 2800, Euro.MONEYTYPE);
        Client client1 = new Client("Tom", "Fox",LocalDateTime.of(1990,Month.APRIL,5,10,15 ),work1);
        Client client2 = new Client("Alexa", "Dilan",LocalDateTime.of(1998,Month.SEPTEMBER,18,18,27 ),work2);
        Client client3 = new Client("Tom", "Fox",LocalDateTime.of(1984,Month.NOVEMBER,7,3,41 ),work3);
        CreditType creditType1 = new CreditType(
                "Elementary USD", Usd.MONEYTYPE, 1, 12,1000, 2000);
        CreditType creditType2 = new CreditType(
                "Light USD", Usd.MONEYTYPE, 1, 9,2000, 5000);
        CreditType creditType3 = new CreditType(
                "Medium USD", Usd.MONEYTYPE, 2, 8,5000, 10000);
        CreditType creditType4 = new CreditType(
                "High USD", Usd.MONEYTYPE, 3, 7,10000, 20000);
        CreditType creditType5 = new CreditType(
                "Inescapable USD", Usd.MONEYTYPE, 5, 7,20000, 50000);
        CreditType creditType6 = new CreditType(
                "Light EURO", Euro.MONEYTYPE, 2, 17,1000, 6000);
        CreditType creditType7 = new CreditType(
                "Medium EURO", Euro.MONEYTYPE, 2, 14,6000, 15000);
        CreditType creditType8 = new CreditType(
                "High EURO", Euro.MONEYTYPE, 2, 11,15000, 30000);
        CreditType creditType9 = new CreditType(
                "Light RUB", Rub.MONEYTYPE, 1, 25,70000, 210000);
        CreditType creditType10 = new CreditType(
                "Medium RUB", Rub.MONEYTYPE, 3, 23,210000, 400000);
        CreditType creditType11 = new CreditType(
                "High RUB", Rub.MONEYTYPE, 5, 20,400000, 1000000);
        CreditType creditType13 = new CreditType(
                "Medium BYN", Byn.MONEYTYPE, 1, 8,20000, 50000);
        CreditType creditType14 = new CreditType(
                "High BYN", Byn.MONEYTYPE, 2, 11,50000, 150000);
        bank1.addCreditType(creditType1);
        bank1.addCreditType(creditType2);
        bank1.addCreditType(creditType6);
        bank1.addCreditType(creditType9);
        bank2.addCreditType(creditType3);
        bank2.addCreditType(creditType7);
        bank2.addCreditType(creditType10);
        bank2.addCreditType(creditType13);
        bank3.addCreditType(creditType4);
        bank3.addCreditType(creditType8);
        bank4.addCreditType(creditType5);
        bank4.addCreditType(creditType11);
        bank4.addCreditType(creditType14);
        Credit credit1 = new Credit(client1, creditType3,6000);
        Credit credit2 = new Credit(client2, creditType7, 11000);
        Credit credit3 = new Credit(client3, creditType14, 80000);
        Credit credit4 = new Credit(client3, creditType1, 500);
        credit1.setMoneyPaid(580);
        credit1.printCredit();
        bank1.addCredit(credit1);
        bank2.addCredit(credit2);
        bank3.addCredit(credit3);
        bank1.printBankInformation();
        BankSystem bankSystem = new BankSystem();
        bankSystem.addBank(bank1);
        bankSystem.addBank(bank2);
        bankSystem.addBank(bank3);
        bankSystem.addBank(bank4);
        //Home task call(Business question)
        bankSystem.searchForCreditType("USD");
        bankSystem.searchForCreditType(Usd.MONEYTYPE, 1500);
        bankSystem.searchForCreditType(Euro.MONEYTYPE, 300);
        bankSystem.searchForCreditType("qwe");
        bankSystem.searchForCreditType("123", 50000);
        bankSystem.searchForCreditType(Usd.MONEYTYPE, 1500000);
        //static call
        BankSystem.exchangeRates();
        //static call
        BankSystem.info();
        //search before CreditType remove
        bankSystem.searchForCreditType(Byn.MONEYTYPE);
        bank4.removeCreditType(creditType14);
        //search after CreditType remove
        bankSystem.searchForCreditType(Byn.MONEYTYPE);
    }
}
