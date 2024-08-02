package Week_1.DesignPattern_and_Principles._07_Answer;

public class WebApp implements Observer {
    private String stockName;
    private double stockPrice;

    @Override
    public void update(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        display();
    }

    private void display() {
        System.out.println("Web App - Stock: " + stockName + ", Price: " + stockPrice);
    }
}
