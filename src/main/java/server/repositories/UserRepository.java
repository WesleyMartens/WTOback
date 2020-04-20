package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByName(String name);
}
