public class Item {
    String name;
    boolean is_expense;
    int quantity;
    int sum_of_one;

    public Item(String name, boolean is_expense, int quantity, int sum_of_one) {
        this.name = name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", is_expense=" + is_expense +
                ", quantity=" + quantity +
                ", sum_of_one=" + sum_of_one +
                '}';
    }
}
