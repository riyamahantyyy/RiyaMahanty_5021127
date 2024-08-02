package Week_1.DesignPattern_and_Principles._01_Answer;

public class Test {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Only one instance of Logger is created.");
        } else {
            System.out.println("Different instances of Logger are created.");
        }

        logger1.log("This is a log message.");
        logger2.log("This is another log message.");
    }
}
