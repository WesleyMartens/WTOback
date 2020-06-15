package server.service;

import org.springframework.stereotype.Service;
import server.dto.AddressDTO;
import server.dto.OrderDTO;
import server.entity.Address;
import server.repositories.AddressRepository;
import server.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepo;

    public OrderServiceImpl(OrderRepository orderRepo) { this.orderRepo = orderRepo; }

    @Override
    public List<OrderDTO> getOrder(int userid) { return orderRepo.getOrder(userid); }

}
