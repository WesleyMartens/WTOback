package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.entity.Address;
import server.entity.User;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
//    Address findByUserID(int userID);
}
