package com.jcastro.apirest.apirest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcastro.apirest.apirest.Entities.Producto;
import com.jcastro.apirest.apirest.Repositories.ProductoRespository;

@RestController
// Indicamos nustra URL
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    // Reacliza nuestra conexion directa con nuestra DB
    // JPA trae todas las herramientas para nuestra DB
    private ProductoRespository productoRespository;

    @GetMapping
    public List<Producto> getAllProducto() {
        return productoRespository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto product) {
        System.out.println(product);
        return productoRespository.save(product);
        
    }

    @DeleteMapping("/{id}")
    public Producto deleteProduct(@PathVariable Long id) {
        Producto product = productoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el id del producto"));

        productoRespository.delete(product);

        return product;
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se pudo obtener el id del producto"));
    }

    @PutMapping
    public Producto updatepProducto(@PathVariable Long id, @RequestBody Producto detalleProducto) {
        Producto producto = productoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontró el id del producto"));

        // prducto => llama al metodo para ajustar el nombre => conseguir el nombre
        // Setea el nombre que va a obtener
        producto.setName(detalleProducto.getName());
        producto.setPrice(detalleProducto.getPrice());

        return productoRespository.save(producto);

    }

}
