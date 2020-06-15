package server.logic;

import server.dto.AddressDTO;
import server.dto.OrderDTO;

import java.util.List;

public interface OrderLogic {

    List<OrderDTO> getOrder(int userid);
}
