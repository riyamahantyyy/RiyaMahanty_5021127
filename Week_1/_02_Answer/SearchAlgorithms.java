import java.util.Arrays;

public class SearchAlgorithms {
    private static Product[] products = new Product[] {
        new Product("1", "Laptop", "Electronics"),
        new Product("2", "Smartphone", "Electronics"),
        new Product("3", "Coffee Maker", "Home Appliances"),
        new Product("4", "Blender", "Home Appliances")
    };

    // Linear Search
    public static Product linearSearchById(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearchById(String productId) {
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId())); // Ensure array is sorted
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductId().compareTo(productId);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
