package Week_1.DesignPattern_and_Principles._08_Answer;

public class Test {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Payment using Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(100.00);

        System.out.println();

        // Payment using PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("user@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(200.00);
    }
}
