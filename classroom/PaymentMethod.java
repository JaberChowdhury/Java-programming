interface PaymentMethods {
    abstract void pay(double amount);
    abstract void refund(double amount);
}

class CardPayment implements PaymentMethods {

    public void pay(double amound) {
        System.out.println("Paid " + amound + " tk via card");
    }

    public void refund(double amound) {
        System.out.println("Refunded " + amound + " tk via card");
    }
}

class BkashPayment implements PaymentMethods {

    public void pay(double amound) {
        System.out.println("Paid " + amound + " tk via bkash");
    }

    public void refund(double amound) {
        System.out.println("Refunded " + amound + " tk via bkash");
    }
}

class CashCounterPayment implements PaymentMethods {

    public void pay(double amound) {
        System.out.println("Paid " + amound + " tk via cash");
    }

    public void refund(double amound) {
        System.out.println("Refunded " + amound + " tk via cash");
    }
}

public class PaymentMethod {

    public static void main(String[] args) {
        CardPayment cp = new CardPayment();
        BkashPayment bp = new BkashPayment();
        CashCounterPayment cap = new CashCounterPayment();
        PaymentMethods[] data = { cp, bp, cap };

        for (PaymentMethods p : data) {
            p.pay(1234);
        }
    }
}
