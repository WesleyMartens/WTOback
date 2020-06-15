package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.dto.AddressDTO;
import server.dto.OrderDTO;
import server.entity.Address;
import server.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("select new server.dto.OrderDTO(o) FROM Order o where o.user.userID = :userid")
    List<OrderDTO> getOrder(@Param("userid")int userid);
}
