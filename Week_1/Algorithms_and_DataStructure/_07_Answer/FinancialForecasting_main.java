
import java.util.Scanner;

public class FinancialForecasting_main {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double rate, int periods) {
        // Base case: If there are no more periods, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: Apply growth rate and decrease period count
        return calculateFutureValue(presentValue * (1 + rate), rate, periods - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for present value, growth rate, and number of periods
        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();
        
        System.out.print("Enter the annual growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();
        
        System.out.print("Enter the number of periods (years): ");
        int periods = scanner.nextInt();

        // Calculate future value using the recursive method
        double futureValue = calculateFutureValue(presentValue, growthRate, periods);

        // Display the result
        System.out.printf("The future value after %d periods is: %.2f\n", periods, futureValue);

        // Close the scanner
        scanner.close();
    }
}
