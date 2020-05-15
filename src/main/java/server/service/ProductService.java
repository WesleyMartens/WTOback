package server.service;

import server.entity.Category;
import server.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findbyCategory(int categoryid);
}
