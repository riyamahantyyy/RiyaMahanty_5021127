package Week_1.DesignPattern_and_Principles._04_Answer;

public class PaymentProcessorAdapterA implements PaymentProcessor {
        private PaymentGatewayA paymentGatewayA;
    
        public PaymentProcessorAdapterA(PaymentGatewayA paymentGatewayA) {
            this.paymentGatewayA = paymentGatewayA;
        }
    
        @Override
        public void processPayment(double amount) {
            paymentGatewayA.makePayment(amount);
        }
}
