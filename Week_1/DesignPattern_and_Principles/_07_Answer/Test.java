package Week_1.DesignPattern_and_Principles._07_Answer;

public class Test {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("AAPL");

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(150.00);
        stockMarket.setStockPrice(155.00);
    }
}
