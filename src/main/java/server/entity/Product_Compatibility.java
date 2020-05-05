package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`product_compatibility`")
@Data
public class Product_Compatibility {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCompatibilityId;


    @Column(name ="compatibilityproducta")
    Integer producta;


    @Column(name = "compatibilityproductb")
    Integer productb;

    public Product_Compatibility() {
    }
}


