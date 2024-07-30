import java.util.HashMap;

public class InventoryManagement {
    private HashMap<String, Product> inventory;

    // Constructor to initialize the inventory with default products
    public InventoryManagement() {
        inventory = new HashMap<>();
        // Add default products
        //addProduct(new Product("1", "Laptop", 10, 999.99));
        

    }

    // Method to add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Method to update a product
    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    // Method to delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    // Method to get a product
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    // Method to display all products
    public void displayAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }
}
