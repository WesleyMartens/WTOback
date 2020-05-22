package server.logic;

import org.springframework.stereotype.Component;
import server.dto.ProductDTO;
import server.entity.Category;
import server.entity.Product;
import server.service.ProductService;

import java.util.List;
import java.util.Optional;

@Component
public class ProductLogicImpl implements ProductLogic{
    private final ProductService productService;

    public ProductLogicImpl(ProductService productService) { this.productService = productService; }

    @Override
    public List<ProductDTO> findbyCategory(int categoryid) {
        return productService.findbyCategory(categoryid);
    }
}
