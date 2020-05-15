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

    public int getaddressID() { return addressID; }
    public void setaddressID(int addressID) { this.addressID = addressID; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getaddressStreet() { return street; }
    public void setaddressStreet(String street) { this.street = street; }

    public String getaddressZipcode() { return zipcode; }
    public void setaddressZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getaddressCity() { return city; }
    public void setaddressCity(String city) { this.city = city; }

    public String getaddressNumber() { return number; }
    public void setaddressNumber(String number) { this.number = number; }

    public String getaddressCountry() { return country; }
    public void setaddressCountry(String country) { this.country = country; }
}
