package banking;

import java.util.Random;
import java.util.Scanner;

public class Account {
    Scanner scanner = new Scanner(System.in);
    String cardNumber;
    String pin;
    int balance;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    static Account createNewRandom() {
        Account a = new Account ();
        String accNumNoCheck = "400000" + String.format("%09d", (long) (Math.random() * 999999999L));
        a.setCardNumber(accNumNoCheck );
        a.setPin(String.format("%04d", (long) (Math.random() * 9999)) );

        return a;
    }

    public String toString() {
        return "Account{" +
                "cardNumber='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                ", balance=" + balance +
                '}';
    }
}