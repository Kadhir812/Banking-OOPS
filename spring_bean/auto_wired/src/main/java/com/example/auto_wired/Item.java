package spring.auto_wired.src.main.java.com.example.auto_wired;

public class Item {
    private int roll;
    private String name;
    private double fee;

    public Item() {
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Item [roll=" + roll + ", name=" + name + ", fee=" + fee + "]";
    }
}
