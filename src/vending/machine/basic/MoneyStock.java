package vending.machine.basic;

public class MoneyStock {
    private int denomination;
    private int capacity;
    private int stock;
    private int counterIncome;
    private int counterExpense;

    public MoneyStock(int denomination, int capacity, int stock) {
        this.denomination = denomination;
        this.capacity = capacity;
        this.stock = stock;
        this.counterIncome = 0;
        this.counterExpense = 0;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCounterIncome() {
        return counterIncome;
    }

    public void setCounterIncome(int counterIncome) {
        this.counterIncome = counterIncome;
    }

    public int getCounterExpense() {
        return counterExpense;
    }

    public void setCounterExpense(int counterExpense) {
        this.counterExpense = counterExpense;
    }
    // -------------------
    // Usage
    public boolean isEmpty() {
        return stock == 0;
    }

    public boolean isValidTransaction(int income, int change) {
        if ((stock + income - change > capacity) || (change > stock + income)) {
            return false;
        }
        return true;
    }

    public void printProblems(int income, int change) {
        if (stock + income - change > capacity) {
            System.out.println("Sorry you can throw in max " + (capacity - stock) + " pieces of " + denomination + "$");
        }
        if (change > stock + income) {
            System.out.println("Sorry there is not enough change in the machine, please throw in the correct amount!");
        }
    }

    public void takeInAmount(int income) {
        this.stock += income;
        this.counterIncome += income;
    }

    public void giveBack(int change) {
        this.stock -= change;
        this.counterExpense -= change;
    }

    @Override
    public String toString() {
        return "MoneyStock{Capacity= " + capacity + ", Stock= " + stock + "}";
    }
    // -------------------
    // Maintenance
    public void emptyMoneyStock() {
        this.stock = (int) (capacity * 0.1);
    }

    public boolean isFull() {
        return stock >= capacity * 0.9;
    }

    public void resetCounterIncome() {
        counterIncome = 0;
    }

    public void resetCounterExpense() {
        counterExpense = 0;
    }
}
