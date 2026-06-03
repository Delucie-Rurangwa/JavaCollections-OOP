package EcommerceBasedSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class EcommerceSystem {

        // 1. Inventory Database: Maps Product ID -> Current Stock Level
        private Map<String, Integer> inventory = new HashMap<>();

        // 2. Product Details: Maps Product ID -> Actual Product Object
        private Map<String, Product> productCatalog = new HashMap<>();

        // 3. Order History: A simple list of all successful orders
        private List<Order> orderHistory = new ArrayList<>();

        // ADD PRODUCT TO SYSTEM
        public void addProduct(Product product, int initialStock) {
            productCatalog.put(product.getProductId(), product);
            inventory.put(product.getProductId(), initialStock);
            System.out.println("System: Added " + product.getName() + " with stock " + initialStock);
        }

        // PROCESS ORDER
        public void processOrder(Order order) {
            Map<String, Integer> cart = order.getShoppingCart();

            // Prevent processing of empty orders
            if (cart.isEmpty()) {
                System.out.println("Error: Cannot process empty order for " + order.getCustomerName());
                return;
            }

            // Verify products exist AND stock is sufficient
            for (String productId : cart.keySet()) {
                int quantityRequested = cart.get(productId);

                // Check if product exists
                if (!inventory.containsKey(productId)) {
                    System.out.println("Error: Product ID " + productId + " does not exist. Order Rejected.");
                    return; // Stop the whole process instantly
                }

                // Check if we have enough stock
                int currentStock = inventory.get(productId);
                if (currentStock < quantityRequested) {
                    System.out.println("Error: Not enough stock for " + productId + ". Order Rejected.");
                    return;
                }
            }

            //  Let's update inventory.
            for (String productId : cart.keySet()) {
                int quantityRequested = cart.get(productId);
                int currentStock = inventory.get(productId);

                // Deduct the requested amount from the current stock
                inventory.put(productId, currentStock - quantityRequested);
            }

            // Store completed order for future reference
            orderHistory.add(order);
            System.out.println("Success: Order " + order.getOrderId() + " processed successfully!");
        }


    }