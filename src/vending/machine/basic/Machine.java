package vending.machine.basic;

public class Machine {
    private JuiceStock juiceStock;
    private MoneyStock moneyStock;

    public Machine(JuiceStock juiceStock, MoneyStock moneyStock) {
        this.juiceStock = juiceStock;
        this.moneyStock = moneyStock;
    }

    public JuiceStock getJuiceStock() {
        return juiceStock;
    }

    public void setJuiceStock(JuiceStock juiceStock) {
        this.juiceStock = juiceStock;
    }

    public MoneyStock getMoneyStock() {
        return moneyStock;
    }

    public void setMoneyStock(MoneyStock moneyStock) {
        this.moneyStock = moneyStock;
    }
    // -------------------
    // Usage
    public void buying(int noOfItems, int amount) {
        int change = (amount > juiceStock.getJuice().getPrice() * noOfItems) ? amount - juiceStock.getJuice().getPrice() * noOfItems : 0;

        if (amount < juiceStock.getJuice().getPrice() * noOfItems) {
            System.out.println("Not enough money!");
            return;
        }
        else if (!(juiceStock.isValidTransaction(noOfItems))) {
            juiceStock.printProblems();
            return;
        }
        else if (!(moneyStock.isValidTransaction(amount, change))) {
            moneyStock.printProblems(amount, change);
            return;
        }

        juiceStock.serve(noOfItems);
        System.out.println(noOfItems + " bottles of " + juiceStock.getJuice().getName() + " was served!");
        moneyStock.takeInAmount(amount);
        moneyStock.giveBack(change);
        System.out.println("The change is: " + change + "$");
        System.out.println("Thank you! Enjoy your drink! Bye!");
    }

    @Override
    public String toString() {
        return juiceStock.toString() + moneyStock.toString();
    }
}
