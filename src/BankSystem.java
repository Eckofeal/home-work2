import address.Address;
import bank.*;
import bank.currency.Currency;
import bank.employee.Employee;
import сlient.Client;
import сredit.*;
import work.Work;

import java.time.LocalDateTime;
import java.time.Month;

//ARRAY
public class BankSystem {

    private final static double USDBUY = 2.495;
    private final static double USDSELL = 2.515;
    private final static double EUROBUY = 2.9;
    private final static double EUROSELL = 2.912;
    private final static double RUBBUY = 3.42;
    private final static double RUBSELL = 3.46;

    private Bank[] banks;

    public BankSystem() {
        banks = new Bank[0];
    }

    public void setBanks(Bank[] banks) {
        this.banks = banks;
    }

    public Bank[] getBanks() {
        return banks;
    }

    public void addBank(Bank bank) {
        if (bank == null) {
            return;
        }
        if (indexOfBank(bank) == -1) {
            banks = add(bank);
        } else {
            System.out.println("Bank already exist.");
        }
    }

    private int indexOfBank(Bank bank) {
        int result = -1;
        if (banks.length != 0) {
            int flag = 0;
            for (int i = 0; i < banks.length; i++) {
                flag++;
                if (banks[i].equals(bank)) {
                    result = i;
                    return result;
                }
            }
            if (flag == banks.length) {
                result = -1;
            }
        } else {
            result = -1;
        }
        return result;
    }

    private Bank[] add(Bank bank) {
        if (bank == null) {
            return banks;
        }
        Bank[] returnList;
        if (banks == null) {
            returnList = new Bank[1];
            returnList[0] = bank;
        } else {
            returnList = new Bank[banks.length + 1];
            returnList = copyThenInsert(banks, returnList, bank);
        }
        return returnList;
    }

    private Bank[] copyThenInsert(Bank[] copyThis, Bank[] intoThis, Bank thenInsertThis) {
        for (int i = 0; i < intoThis.length; i++) {
            if (i != intoThis.length - 1) {
                intoThis[i] = copyThis[i];
            } else {
                intoThis[i] = thenInsertThis;
            }
        }
        return intoThis;
    }

    public static void exchangeRates() {
        System.out.printf("%-60s%s%s", "\n", "EXCHANGE RATES:", "\n");
        System.out.printf("%15s %8s%n", "BUY", "SELL");
        System.out.printf("%-12s%-8s%-6s%s%n", "1 USD", USDBUY, USDSELL, "BYN");
        System.out.printf("%-12s%-8s%-6s%s%n", "1 EURO", EUROBUY, EUROSELL, "BYN");
        System.out.printf("%-12s%-8s%-6s%s%n", "1 RUB", RUBBUY, RUBSELL, "BYN");
    }

    public static void info() {
        System.out.printf("%-60s%s%s", "\n", "BANK SYSTEM INFORMATION:", "\n");
        System.out.println("Number of banks in system: " + Bank.count);
        System.out.println("Number of employees: " + Employee.count);
        System.out.println("Credits issued: " + Credit.сount);
        System.out.println("Number types of credits in banks: " + CreditType.count);
        System.out.println("Number of bank clients: " + Client.сount);
    }
    //OVERLOADED 3
    public void searchForCreditType(String moneyType) {
        System.out.printf("%-60s%s%s", "\n", "CREDIT SEARCH RESULT:", "\n");
        int flag = 0;
        for (Bank element : banks) {
            if (element.findCreditType(moneyType) != null && element.findCreditType(moneyType).length != 0) {
                for (CreditType creditTypeElement : element.findCreditType(moneyType)) {
                    System.out.print("Bank \"" + element.getName() + "\" : ");
                    creditTypeElement.printCreditType();
                }
            } else {
                flag++;
            }
        }
        if (flag == banks.length) {
            System.out.println("No credits found for your request.");
        }
    }
    //OVERLOADED 3
    public void searchForCreditType(String moneyType, double moneyAmount) {
        System.out.printf("%-60s%s%s", "\n", "CREDIT SEARCH RESULT:", "\n");
        int flag = 0;
        for (Bank element : banks) {
            if (element.findCreditType(moneyType, moneyAmount) != null && element.findCreditType(moneyType, moneyAmount).length != 0) {
                for (CreditType creditTypeElement : element.findCreditType(moneyType, moneyAmount)) {
                    System.out.print("Bank \"" + element.getName() + "\" : ");
                    creditTypeElement.printCreditType();
                }
            } else {
                flag++;
            }
        }
        if (flag == banks.length) {
            System.out.println("No credits found for your request.");
        }
    }

    public static void main(String[] args) {
        Currency byn1 = new Currency(1000000, Currency.BYN);
        Currency rub1 = new Currency(1250000, Currency.RUB);
        Currency eur1 = new Currency(150000, Currency.EURO);
        Currency usd1 = new Currency(175000, Currency.USD);
        Currency byn2 = new Currency(2000000, Currency.BYN);
        Currency eur2 = new Currency(250000, Currency.EURO);
        Currency usd2 = new Currency(275000, Currency.USD);
        Currency rub2 = new Currency(2250000, Currency.RUB);
        Currency byn3 = new Currency(3000000, Currency.BYN);
        Currency rub3 = new Currency(3250000, Currency.RUB);
        Currency eur3 = new Currency(350000, Currency.EURO);
        Currency usd3 = new Currency(375000, Currency.USD);
        Currency byn4 = new Currency(4000000, Currency.BYN);
        Currency rub4 = new Currency(4250000, Currency.RUB);
        Currency eur4 = new Currency(450000, Currency.EURO);
        Currency usd4 = new Currency(475000, Currency.USD);
        Address adr1 = new Address("Minsk", "Lenina", 3);
        Address adr2 = new Address("Moscow", "Old Arbat", 12);
        Address adr3 = new Address("London", "Piccadilly", 7);
        Address adr4 = new Address("Berlin", "Unter den Linden", 9);
        Bank bank1 = new Bank("Commercial Banking", adr1,
                LocalDateTime.of(2017, Month.JULY, 9, 12, 0), usd1, eur1, rub1, byn1);
        Bank bank2 = new Bank("Finance", adr2,
                LocalDateTime.of(2000, Month.AUGUST, 26, 0, 0), usd2, eur2, rub2, byn2);
        Bank bank3 = new Bank("Future's", adr3,
                LocalDateTime.of(1993, Month.MAY, 3, 18, 6), usd2, eur2, rub2, byn2);
        Bank bank4 = new Bank("Absolute", adr4,
                LocalDateTime.of(1886, Month.DECEMBER, 31, 23, 59), usd3, eur3, rub3, byn3);
        Work work1 = new Work("Google", "Sales Manager", 6500, Currency.USD);
        Work work2 = new Work("KFC", "Restaurant Crew", 850, Currency.BYN);
        Work work3 = new Work("Adidas", "Production Line Engineer", 2800, Currency.EURO);
        Client client1 = new Client("Tom", "Fox", LocalDateTime.of(1990, Month.APRIL, 5, 10, 15), work1);
        Client client2 = new Client("Alexa", "Dilan", LocalDateTime.of(1998, Month.SEPTEMBER, 18, 18, 27), work2);
        Client client3 = new Client("Tom", "Fox", LocalDateTime.of(1984, Month.NOVEMBER, 7, 3, 41), work3);
        CreditType creditType1 = new CreditType(
                "Elementary USD", Currency.USD, 1, 12, 1000, 2000);
        CreditType creditType2 = new CreditType(
                "Light USD", Currency.USD, 1, 9, 2000, 5000);
        CreditType creditType3 = new CreditType(
                "Medium USD", Currency.USD, 2, 8, 5000, 10000);
        CreditType creditType4 = new CreditType(
                "High USD", Currency.USD, 3, 7, 10000, 20000);
        CreditType creditType5 = new CreditType(
                "Inescapable USD", Currency.USD, 5, 7, 20000, 50000);
        CreditType creditType6 = new CreditType(
                "Light EURO", Currency.EURO, 2, 17, 1000, 6000);
        CreditType creditType7 = new CreditType(
                "Medium EURO", Currency.EURO, 2, 14, 6000, 15000);
        CreditType creditType8 = new CreditType(
                "High EURO", Currency.EURO, 2, 11, 15000, 30000);
        CreditType creditType9 = new CreditType(
                "Light RUB", Currency.RUB, 1, 25, 70000, 210000);
        CreditType creditType10 = new CreditType(
                "Medium RUB", Currency.RUB, 3, 23, 210000, 400000);
        CreditType creditType11 = new CreditType(
                "High RUB", Currency.RUB, 5, 20, 400000, 1000000);
        CreditType creditType13 = new CreditType(
                "Medium BYN", Currency.BYN, 1, 8, 20000, 50000);
        CreditType creditType14 = new CreditType(
                "High BYN", Currency.BYN, 2, 11, 50000, 150000);
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
        Credit credit1 = new Credit(client1, creditType3, 6000);
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
        bankSystem.searchForCreditType(Currency.USD, 1500);
        bankSystem.searchForCreditType(Currency.EURO, 300);
        bankSystem.searchForCreditType("qwe");
        bankSystem.searchForCreditType("123", 50000);
        bankSystem.searchForCreditType(Currency.USD, 1500000);
        //static call
        BankSystem.exchangeRates();
        //static call
        BankSystem.info();
        //search before CreditType remove
        bankSystem.searchForCreditType(Currency.BYN);
        bank4.removeCreditType(creditType14);
        //search after CreditType remove
        bankSystem.searchForCreditType(Currency.BYN);
    }
}
