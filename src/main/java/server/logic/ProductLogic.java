package server.logic;

import server.entity.Product;

import java.util.List;

public interface ProductLogic {
    List<Product> findbyCategory(int categoryid);
}
