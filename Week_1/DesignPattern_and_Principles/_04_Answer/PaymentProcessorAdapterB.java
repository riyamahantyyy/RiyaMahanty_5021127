package Week_1.DesignPattern_and_Principles._04_Answer;

public class PaymentProcessorAdapterB implements PaymentProcessor {
    private PaymentGatewayB paymentGatewayB;

    public PaymentProcessorAdapterB(PaymentGatewayB paymentGatewayB) {
        this.paymentGatewayB = paymentGatewayB;
    }

    @Override
    public void processPayment(double amount) {
        paymentGatewayB.pay(amount);
    }
    
}
