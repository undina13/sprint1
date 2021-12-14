public class MonNew {
    String mon;
    int amount;
    int expense;

    public MonNew() {
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "MonNew{" +
                "mon='" + mon + '\'' +
                ", amount=" + amount +
                ", expense=" + expense +
                '}';
    }
}
