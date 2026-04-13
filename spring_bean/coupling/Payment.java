package coupling;

public interface Payment {
    void pay();
}

class DebitCardService implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying through Debit Card");
    }
}

class CreditCardService implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying through Credit Card");
    }
}

class CashService implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying through Cash");
    }
}


class PaymentProcess {
     Payment paymentService;

    PaymentProcess(Payment paymentService) {
        this.paymentService = paymentService;
    }

    void checkout() {
        paymentService.pay();
    }
}

class PaymentDem {
    public static void main(String[] args) {
        PaymentProcess debit = new PaymentProcess(new DebitCardService());
        debit.checkout();

        PaymentProcess credit = new PaymentProcess(new CreditCardService());
        credit.checkout();

        PaymentProcess cash = new PaymentProcess(new CashService());
        cash.checkout();
    }   
}