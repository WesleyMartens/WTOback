package server.logic;

import server.dto.ProductDTO;
import server.entity.Product;

import java.util.List;

public interface ProductLogic {
    List<ProductDTO> findbyCategory(int categoryid);
}
