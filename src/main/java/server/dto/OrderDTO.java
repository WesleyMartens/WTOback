package server.dto;

import lombok.Data;
import server.entity.Address;
import server.entity.Order;

import javax.validation.constraints.NotNull;

@Data
public class OrderDTO {

    int orderID;


    @NotNull(message = "Please provide: description")
    String status;

    public OrderDTO(){
    }

    public OrderDTO(Order order){
        this.orderID = order.getOrderID();
        this.status = order.getStatus();
    }
}
