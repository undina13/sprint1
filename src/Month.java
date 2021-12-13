public class Month {
    String mon;
    int amount;
    boolean is_expense;

    public Month(String mon, int amount, boolean is_expense) {
        this.mon = mon;
        this.amount = amount;
        this.is_expense = is_expense;
    }

    @Override
    public String toString() {
        return "Month{" +
                "mon=" + mon +
                ", amount=" + amount +
                ", is_expense=" + is_expense +
                '}';
    }
}
