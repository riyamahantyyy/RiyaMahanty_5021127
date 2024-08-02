package Week_1.DesignPattern_and_Principles._03_Answer;

public class Test {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 3080")
            .setBluetoothEnabled(true)
            .build();

        Computer officePC = new Computer.Builder("Intel i5", "16GB")
            .setStorage("500GB SSD")
            .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
