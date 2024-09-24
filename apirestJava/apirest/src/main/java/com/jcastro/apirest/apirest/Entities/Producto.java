package com.jcastro.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    // Para los set utilizamos void y especificamos lo que devolvemos
    public  void setId(Long id){
        this.id = id;
    }

    // Para los get especificamos el TIPO de variable que devolvemos y retornamos la variable.
    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }



}
