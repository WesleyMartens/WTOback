package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.entity.Category;
import server.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p.productID,p.name,p.description,p.stock,p.price FROM Product p where p.category.categoryID = :categoryid")
    List<Product> findByCategory(@Param("categoryid")int categoryid);

    @Query("select p.productID, p.name, p.description,p.stock,p.price from Product p INNER JOIN  p.compatibleTo c on p.productID = c.compatibleProducts WHERE (p.category.categoryID = :category AND c.compatible_id = :product)")
    List<Product> findCompatibleProduct(@Param("category")int category,@Param("product")int product);

//    List<Product> findByCompatibleProducts(Category category);
}
