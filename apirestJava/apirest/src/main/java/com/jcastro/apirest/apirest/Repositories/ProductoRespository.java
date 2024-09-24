package com.jcastro.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcastro.apirest.apirest.Entities.Producto;

//Indicamos el nombre de la entidad y el tipo de identificados que es;
public interface ProductoRespository extends JpaRepository<Producto, Long>{

    
    

}
