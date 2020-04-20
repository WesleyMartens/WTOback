package server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="`rol`")
@Data
public class Rol {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolID;

    @Column(name = "name")
    private String name;

    public Rol(String name) {
        this.name = name;
    }

    public Rol() {
    }

    public int getrolID() { return rolID; }
    public void setrolID(int rolID) { this.rolID = rolID; }

    public String getrolName() { return name; }
    public void setrolName(String name) { this.name = name; }
}
