package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`address`")
@Data
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressID;

    @ManyToOne
    private User user;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "number")
    private String number;

    @Column(name = "country")
    private String country;

    public Address(User user, String street, String zipcode, String city, String number, String country) {
        this.user = user;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.number = number;
        this.country = country;
    }

    public Address() { }
}
