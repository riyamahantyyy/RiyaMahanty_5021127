package Week_1.DesignPattern_and_Principles._04_Answer;

public class Test {
    public static void main(String[] args) {
        PaymentGatewayA gatewayA = new PaymentGatewayA();
        PaymentProcessor processorA = new PaymentProcessorAdapterA(gatewayA);
        processorA.processPayment(100.0);

        PaymentGatewayB gatewayB = new PaymentGatewayB();
        PaymentProcessor processorB = new PaymentProcessorAdapterB(gatewayB);
        processorB.processPayment(200.0);
    }
}
