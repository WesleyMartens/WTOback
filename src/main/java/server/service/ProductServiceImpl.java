package server.service;

import org.springframework.stereotype.Service;
import server.dto.ProductDTO;
import server.entity.Category;
import server.entity.Product;
import server.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) { this.productRepo = productRepo; }


    @Override
    public List<ProductDTO> findbyCategory(int categoryid) {
        return productRepo.findByCategory(categoryid);
    }

//    @Override
//    public List<ProductDTO> findcompatibleproduct(int categoryid, int productid) {
//        return productRepo.getCompatibleProductsByEntity(productid,categoryid);
//    }
}
