package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.dto.ProductDTO;
import server.entity.Category;
import server.entity.Product;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select new server.dto.ProductDTO(p) FROM Product p where p.category.categoryID = :categoryid")
    List<ProductDTO> findByCategory(@Param("categoryid")int categoryid);

//    @Query("select new server.dto.ProductDTO(p) from Product p INNER JOIN  p.compatibleTo c on p.productID = c.productID WHERE (p.category.categoryID = :category AND c.compatibleProducts = :product)")
//    List<ProductDTO> findCompatibleProduct(@Param("category")int category,@Param("product")int product);

//    List<Product> findByCompatibleProducts(Category category);
//
//    List<ProductDTO> findCompatibleProduct(@Param("category")int category,@Param("product")int product);

//    @Procedure
//    List<Product> FIND_COMPATIBLE_PRODUCTS(@Param("product_in") int productid,@Param("category_in") int categoryid);

//    @Query(value = "CALL compatible_products(:product_in,:category_in);", nativeQuery = true)
//    List<ProductDTO> getCompatibleProductsByEntity(@Param("product_in") int product_in,@Param("category_in") int category_in);
}
