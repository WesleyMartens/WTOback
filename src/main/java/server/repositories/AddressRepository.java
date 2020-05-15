package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.entity.Address;
import server.entity.User;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("select a.addressID,a.city,a.country,a.number,a.street,a.zipcode FROM Address a where a.user.userID = :userid")
    List<Address> findByUser(@Param("userid")int userid);
}
