package spring_bean.springcore.src.main.java.com.example.springcore;

public class Address {
    String city;
    String state;
    int pinCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
    }
}
