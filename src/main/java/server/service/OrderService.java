package server.service;

import server.dto.AddressDTO;
import server.dto.OrderDTO;
import server.entity.Address;
import server.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrder(int userid);
}
