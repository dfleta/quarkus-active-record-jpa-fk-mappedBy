package org.pingpong.restjson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "farmer")
@JsonIgnoreProperties({"location"})
public class Farmer extends PanacheEntityBase {

    @Id
    @Column(unique = true)
    @JsonProperty(value = "farmer")
    public String name;

    @Column
    public String location;
    
    public Farmer() {}

    public Farmer(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
