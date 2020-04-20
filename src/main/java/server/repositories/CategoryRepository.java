package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.entity.Address;
import server.entity.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
