package com.solvd.carinaexample.api.assignment.domain;

public class Product {
        private int productId;
        private int quantity;

        public Product() {
        }

        public Product(int productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }
        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}
