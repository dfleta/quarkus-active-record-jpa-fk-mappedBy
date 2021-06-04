package org.pingpong.restjson;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="fruit")
//@JsonPropertyOrder({"name", "description"})
//@JsonIgnoreProperties({"id"})
public class Fruit extends PanacheEntityBase {

    // Las propiedades han de ser publicas para que jackson
    // pueda acceder a ellar por reflection o configurar getter y setter
    // Internamente Quarkus hace la propiedad public
    // Mantengo el getter porque lo uso en los casos test

    @NotBlank
    @Id
    @Column(unique = true)
    public String name;
    
    @NotEmpty
    @Column
    public String description;

    //@JsonUnwrapped
    //@NotNull
    @ManyToOne
    @JoinColumn(name = "farmer_name")
    public Farmer farmer;

    public Fruit() {
    }

    public Fruit(String name, String description, Farmer farmer) {
        this.name = name;
        this.description = description;
        this.farmer = farmer;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
