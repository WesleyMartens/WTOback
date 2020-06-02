package server.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @Data
public class ProductOrderKey implements Serializable {

    @Column(name = "product_id")
    int productID;

    @Column(name = "order_id")
    int orderID;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
