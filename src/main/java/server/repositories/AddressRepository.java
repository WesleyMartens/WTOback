package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.dto.AddressDTO;
import server.entity.Address;
import server.entity.User;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("select new server.dto.AddressDTO(a) FROM Address a where a.user.userID = :userid")
    List<AddressDTO> findByUser(@Param("userid")int userid);
}
