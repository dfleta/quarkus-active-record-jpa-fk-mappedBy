package org.pingpong.restjson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "Farmer")
// @JsonIgnoreProperties({"id", "location"})
// @JsonFormat(shape = Shape.STRING)
public class Farmer extends PanacheEntity {

    @Column(unique = true)
    public String name;

    @Column
    public String location;
    
    public Farmer() {}

    public Farmer(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
