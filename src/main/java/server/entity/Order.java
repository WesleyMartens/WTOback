package server.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@Table(name="`orders`")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @ManyToOne
    private User user;

    @ManyToOne
    private Address address;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "order")
    List<ProductOrder> productOrders;

    public Order(User userid, Address addressid, String status){
        this.user = userid;
        this.address = addressid;
        this.status = status;
    }

    public Order(){
    }

}
