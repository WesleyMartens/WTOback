package server.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import server.dto.ProductDTO;
import server.entity.Product;
import server.logic.ProductLogic;
import server.repositories.CategoryRepository;
import server.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductController {
    private final ProductLogic productLogic;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    CategoryRepository categoryRepo;

    public ProductController(ProductLogic productLogic){ this.productLogic = productLogic; }

    Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/product/category")
    public List<ProductDTO> GetProductByCategory(@RequestHeader (name="categoryid") String categoryid){
        return productLogic.findbyCategory(Integer.parseInt(categoryid));
    }

//    @PostMapping("/product/getCompatibleProduct/")
//    public List<ProductDTO> GetCompatibleProduct(@RequestHeader (name="productid") String productid,@RequestHeader (name="categoryid") String categoryid){
////        return productRepo.findCompatibleProduct(Integer.parseInt(categoryid),Integer.parseInt(productid));
//    }
}
