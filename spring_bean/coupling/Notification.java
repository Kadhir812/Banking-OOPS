package coupling;

public interface Notification {
    void send();
}

class EmailService implements Notification {
  @Override
  public void send() {
    System.out.println("Sending Email");
  }
}

class SMSService implements Notification {
  @Override
  public void send() {
    System.out.println("Sending SMS");
  }
}

class Order {
   Notification ser;

  Order(Notification ser) {
        this.ser = ser;
    }

  void placeOrder() {
        ser.send();
    }
}

class CouplingDemo {
  public static void main(String[] args) {
    Order emailOrder = new Order(new EmailService());
    emailOrder.placeOrder();

    Order smsOrder = new Order(new SMSService());
    smsOrder.placeOrder();
  }
}
