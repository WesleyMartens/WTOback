package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class ProductOrder {

    @EmbeddedId
    ProductOrderKey id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    Order order;

    double price;

    int quantity;


    public ProductOrder() {
    }

}


