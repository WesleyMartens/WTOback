package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.entity.Category;
import server.entity.Product;
import server.entity.Rol;
import server.entity.Product_Compatibility;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p.productID,p.name,p.description,p.stock,p.price FROM Product p where p.category.categoryID = :category")
    List<Product> findProductByCategoryID(@Param("category")int category);

//    @Query("select p.productID, p.name, p.description,p.stock,p.price from Product p INNER JOIN Product_Compatibility c on p.productID = c.producta WHERE (p.category.categoryID = :category AND c.productb = :product)")
//    List<Product> findCompatibleProduct(@Param("category")int category,@Param("product")int product);
}
