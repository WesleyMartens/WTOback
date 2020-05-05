package server.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.entity.Product;
import server.repositories.ProductRepository;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    public ProductController(){}

    Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/product/getProduct/{id}")
    public List<Product> GetProductByCategory(@PathVariable String id){
        int category = Integer.parseInt(id);
        return productRepo.findProductByCategoryID(category);
    }

//    @GetMapping("/product/getCompatibleProduct/{category}/{product}")
//    public List<Product> GetCompatibleProduct(@PathVariable String category, @PathVariable String product){
//        int Category = Integer.parseInt(category);
//        int Product = Integer.parseInt(product);
//        return productRepo.findCompatibleProduct(Category,Product);
//    }
}
