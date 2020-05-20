package vending.machine.basic;

public class JuiceStock {
    private Juice juice;
    private int capacity;
    private int stock;
    private int counter;

    public JuiceStock(Juice juice, int capacity, int stock) {
        this.juice = juice;
        this.capacity = capacity;
        this.stock = stock;
        this.counter = 0;
    }

    public Juice getJuice() {
        return juice;
    }

    public void setJuice(Juice juice) {
        this.juice = juice;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    // -------------------
    // Usage
    public boolean isValidTransaction(int pieces) {
        if (pieces > stock) {
            return false;
        }
        return true;
    }

    public void printProblems() {
        System.out.println("Sorry there is only " + stock + " pieces of " + juice.getName() + " left");
    }

    public void serve(int pieces) {
        if (pieces <= this.stock) {
            this.stock -= pieces;
            this.counter += pieces;
        }
        else {
            System.out.println("Sorry there is only " + stock + " pieces left");
        }
    }

    @Override
    public String toString() {
        return "JuiceStock{" + juice.toString() + " Capacity=" + capacity + ", Stock=" + stock + "} ";
    }
    // -------------------
    // Maintenance
    public boolean isEmpty() {
        if (stock <= capacity * 0.1) {
            return true;
        }
        return false;
    }

    public void fillUp() {
        this.stock = capacity;
    }

    public boolean isFull() {
        if (stock == capacity) {
            return true;
        }
        return false;
    }
}
