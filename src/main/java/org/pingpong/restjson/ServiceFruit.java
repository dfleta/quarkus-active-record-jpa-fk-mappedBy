package org.pingpong.restjson;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceFruit {

    public ServiceFruit() { 
        // CDI
    }

    public Set<Fruit> list() {
        // stream requiere una transaction
        Stream<Fruit> fruits = Fruit.streamAll();
        return fruits.collect(Collectors.toSet());
    }

    public void add(Fruit fruit) {
        // Es necesario meter en el Persistence Context el objeto Farmer de Fruit
        // antes de hacer flush sobre la bbdd para evitar error entity en transient state
        // Buscamos el objeto Farmer de la peticion POST en la bbdd para ponerlo MANAGED con find()
        Optional<Farmer> supplier = Farmer.find("name", fruit.farmer.name).firstResultOptional();
        if (supplier.isPresent()) {
            // Si el Farmer existe, ese objeto managed se asigna a Fruit
            fruit.farmer = supplier.get();
        } else {
            // Si no existe, se ha creado un NEW Farmer en memoria
            // y lo ponemos en MANAGED con persist()
            fruit.farmer.persist();
        }
        // Persisir el NEW Fruit con Farmer ya en Managed y persist-ido.
        fruit.persist();
    }

    public void remove(String name) {
        Optional<Fruit> fruit = Fruit.find("name", name).firstResultOptional();
        if (fruit.isPresent()) {
            fruit.get().delete();
        }
    }

    public Optional<Fruit> getFruit(String name) {
        return name.isBlank()? 
            Optional.ofNullable(null) : 
            Fruit.find("name", name).firstResultOptional();
    }
}
