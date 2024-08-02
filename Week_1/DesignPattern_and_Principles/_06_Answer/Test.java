package Week_1.DesignPattern_and_Principles._06_Answer;

public class Test {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded and displayed on first call
        image1.display();
        System.out.println();

        // Image will be cached and only displayed
        image1.display();
        System.out.println();

        // Image will be loaded and displayed on first call
        image2.display();
    }
}
