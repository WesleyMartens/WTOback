package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`product_order`")
@Data
public class Product_Order {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @Column(name = "order_id")
    private int orderID;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    public Product_Order(int productID, int orderID, double price, int quantity) {
        this.productID = productID;
        this.orderID = orderID;
        this.price = price;
        this.quantity = quantity;
    }

    public Product_Order() {
    }
}


