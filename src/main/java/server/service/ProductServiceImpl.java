package server.service;

import org.springframework.stereotype.Service;
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
    public List<Product> findbyCategory(int categoryid) {
        return productRepo.findByCategory(categoryid);
    }
}
