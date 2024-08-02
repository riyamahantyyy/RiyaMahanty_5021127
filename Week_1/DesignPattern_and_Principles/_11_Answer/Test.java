package Week_1.DesignPattern_and_Principles._11_Answer;

public class Test {
    public static void main(String[] args) {
        // Create repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService service = new CustomerService(repository);

        // Use service to get customer details
        String customerDetails = service.getCustomerDetails(1);
        System.out.println(customerDetails);
    }
}