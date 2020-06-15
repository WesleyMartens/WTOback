package server.logic;

import org.springframework.stereotype.Component;
import server.dto.AddressDTO;
import server.dto.OrderDTO;
import server.entity.Address;
import server.entity.User;
import server.repositories.UserRepository;
import server.responses.VerifyResponse;
import server.service.AddressService;
import server.service.OrderService;

import java.util.List;

@Component
public class OrderLogicImpl implements OrderLogic{
    private final OrderService orderService;

    public OrderLogicImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public List<OrderDTO> getOrder(int userid) { return orderService.getOrder(userid); }
}
