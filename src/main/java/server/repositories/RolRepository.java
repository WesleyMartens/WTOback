package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Rol findByName(String name);
}
