package org.pingpong.restjson;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="fruit")
@JsonPropertyOrder({"name", "decription"})
@JsonIgnoreProperties({"id"})
public class Fruit extends PanacheEntity {

    // Las propiedades han de ser publicas para que jackson
    // pueda acceder a ellar por reflection o configurar getter y setter
    // Internamente Quarkus hace la propiedad public
    // Mantengo el getter porque lo uso en los casos test

    @NotBlank
    @Column(unique = true)
    public String name;
    
    @NotEmpty
    @Column
    public String description;

    @JsonUnwrapped
    @NotNull
    @OneToOne
    @JoinColumn(name = "farmer_name")
    public Farmer farmer;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
