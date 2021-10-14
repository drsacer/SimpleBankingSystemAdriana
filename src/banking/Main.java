package banking;

import java.util.*;

public class Main {

    static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account currAccount = null;
        boolean exit = false;

        do {
            int choice = -1;

            // ne postoji account

            if (currAccount == null) {
                System.out.println("1. Create an account");
                System.out.println("2. Log into account");
                System.out.println("0. Exit");

                choice = scanner.nextInt();

                // kreiramo account

                switch (choice) {
                    case 1: {
                        Account newAccount = new Account();
                        newAccount = Account.createNewRandom();
                        accounts.add(newAccount);
                        System.out.println("Your card has been created.");
                        System.out.println("Your card number:\n" + newAccount.getCardNumber());
                        System.out.println("Your card PIN:\n" + newAccount.getPin());
                        break;
                    }

                    // provjeravamo postoji li account
                    case 2: {
                        System.out.print("Enter your card number:\n>");
                        String cardNumber = scanner.next();

                        System.out.print("Enter your pin:\n>");
                        String pin = scanner.next();

                        currAccount = foundAccount(cardNumber, pin);
                        if (currAccount == null) {
                            System.out.println("Wrong card number or PIN");
                        } else {
                            System.out.println("You have successfully logged in!");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Bye!");
                        exit = true;
                        break;
                    }
                }

                // logirani smo kao postojeći account ( currAccount )
            } else {
                System.out.println("1. Balance\n" + "2. Log out\n" + "3. Set balance\n" + "0. Exit\n");
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        System.out.println("Balance " + currAccount.getBalance() + "\n");
                        break;
                    case 2:
                        currAccount = null;
                        System.out.println("You have successfully logged out!\n");
                        break;
                    case 3:
                        System.out.println("Enter new balance\n>");
                        int b = scanner.nextInt();
                        currAccount.setBalance(b);
                        System.out.println("New balance is set!");
                        break;
                    case 0:
                        exit = true;
                }
            }
            if (choice == 0) {
                exit = true;
            }

        } while (!exit);
        System.out.println("Bye");
    }

    public static Account foundAccount(String cardNumber, String pin) {
        for (Account a : accounts) {
            if (a.getCardNumber().equals(cardNumber) && a.getPin().equals(pin))
                return a;
        }
        return null;
    }
}


