package server.service;

import server.dto.ProductDTO;
import server.entity.Category;
import server.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findbyCategory(int categoryid);

//    List<ProductDTO> findcompatibleproduct(int categoryid, int productid);
}
