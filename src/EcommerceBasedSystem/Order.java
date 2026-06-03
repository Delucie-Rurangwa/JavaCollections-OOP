package EcommerceBasedSystem;

import java.util.HashMap;
import java.util.Map;

    public class Order {
        private String orderId;
        private String customerName;

        // This map stores the Product ID and how many they want to buy
        private Map<String, Integer> shoppingCart;

        public Order(String orderId, String customerName) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.shoppingCart = new HashMap<>();
        }

        // Customer adds an item to their cart
        public void addItem(String productId, int quantity) {
            if (quantity > 0) {
                shoppingCart.put(productId, quantity);
            }
        }

        public String getOrderId() { return orderId; }
        public String getCustomerName() { return customerName; }
        public Map<String, Integer> getShoppingCart() { return shoppingCart; }
    }
