package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import server.dto.AddressDTO;
import server.dto.OrderDTO;
import server.logic.AddressLogic;
import server.logic.IAuthenticatieLogic;
import server.logic.OrderLogic;
import server.repositories.UserRepository;
import server.responses.VerifyResponse;

import java.util.List;

@RestController
public class OrderController {
    private final OrderLogic orderLogic;

    @Autowired
    UserRepository userRepo;

    private IAuthenticatieLogic authLogic;

    public OrderController(IAuthenticatieLogic authLogic, OrderLogic orderLogic) {
        this.authLogic = authLogic;
        this.orderLogic = orderLogic;
    }

    @PostMapping("/order/")
    public List<OrderDTO> getAddress(@RequestHeader(name="Token") String token){
        VerifyResponse user = authLogic.verify(token,userRepo);
        return orderLogic.getOrder(user.getId());
    }
}
