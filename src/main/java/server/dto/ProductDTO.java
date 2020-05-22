package server.dto;

import lombok.Data;
import server.entity.Product;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProductDTO {

    int productid;


    @NotNull(message = "Please provide: description")
    String description;

    @NotNull(message = "Please provide: name")
    String name;

    @NotNull(message = "Please provide: price")
    double price;

    @NotNull(message = "Please provide: stock")
    int stock;

    @NotNull(message = "Please provide: category")
    int category_id;

    public ProductDTO(){
    }

    public ProductDTO(Product product){
        this.productid = product.getProductID();
        this.description = product.getDescription();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.category_id = product.getCategory().getcategoryID();
    }
}
