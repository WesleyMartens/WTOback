package server.entity;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="`product`")
@Data
public class Product {
    @Id
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

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(
            joinColumns={@JoinColumn(name="product_id")},
            inverseJoinColumns={@JoinColumn(name="compatible_id")})
    private Set<Product> compatibleTo = new HashSet<>();

    @ManyToMany(mappedBy="compatibleTo", fetch = FetchType.EAGER)
    private Set<Product> compatibleProducts = new HashSet<>();

    public Product(Category category,String name,int stock,double price,String description) {
        this.category = category;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

}
