package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`product`")
@Data
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Category category;

    public Product(Category category,String name,int stock,double price,String description) {
        this.category = category;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public int getproductID() { return productID; }
    public void setproductID(int productID) { this.productID = productID; }

    public Category getCategoryID() { return category; }
    public void setCategoryID(Category category) { this.category = category; }

    public String getProductName() { return name; }
    public void setProductname(String name) { this.name = name; }

    public int getProductStock() { return stock; }
    public void setProductStock(int stock) { this.stock = stock; }

    public double getProductPrice() { return price; }
    public void setProductPrice(double price) { this.price = price; }

    public String getProductDescription() { return description; }
    public void setProductDescription(String description) { this.description = description; }
}
