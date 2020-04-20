package server.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="`category`")
@Data



public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name="`category_id`")
    List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public int getcategoryID() { return categoryID; }
    public void setcategoryID(int categoryID) { this.categoryID = categoryID; }

    public String getcategoryName() { return name; }
    public void setcategoryName(String name) { this.name = name; }
}
