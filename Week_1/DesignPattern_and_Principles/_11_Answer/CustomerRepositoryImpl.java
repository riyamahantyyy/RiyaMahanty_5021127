package Week_1.DesignPattern_and_Principles._11_Answer;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulate database access
        return "Customer with ID: " + id;
    }
}