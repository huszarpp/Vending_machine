package vending.machine.basic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Juice juice = new Juice("Peach juice", 3);
        JuiceStock juiceStock = new JuiceStock(juice, 30, 10);
        MoneyStock moneyStock = new MoneyStock(1, 50, 15);
        Machine machine = new Machine(juiceStock, moneyStock);

        System.out.println(machine.toString());
        boolean on = true;
        while (on) {
            Scanner noOfItemsScanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Hello!");
            System.out.println("Please enter how many " + machine.getJuiceStock().getJuice().getName() + " (cost: " + juiceStock.getJuice().getPrice() + ") do you want to buy: ");
//            System.out.println("Or type 'off' to turn off the machine!");
            int noOfItems = noOfItemsScanner.nextInt();
/*
            String turn_off = noOfItemsScanner.nextLine();
            if (turn_off == "off") {
                break;
            }
*/
            if (!(machine.getJuiceStock().isValidTransaction(noOfItems))) {
                machine.getJuiceStock().printProblems();
                continue;
            }
            Scanner amountScanner = new Scanner(System.in);
            System.out.println("Insert coins, please! ");
            int amount = amountScanner.nextInt();

            machine.buying(noOfItems, amount);

            System.out.println(machine.toString());

            // maintenance
            if (machine.getJuiceStock().isEmpty()) {
                machine.getJuiceStock().fillUp();
                System.out.println("Juice stack is filled!");
                System.out.println(machine.toString());
            }

            if (machine.getMoneyStock().isFull()) {
                machine.getMoneyStock().emptyMoneyStock();
                System.out.println("Money stack is emptied!");
                System.out.println(machine.toString());
            }

        }
    }
}
