package Week_1.DesignPattern_and_Principles._05_Answer;

public class EmailNotifier  implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}