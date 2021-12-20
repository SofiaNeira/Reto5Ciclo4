/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto5Ciclo4.Controller;

import com.exampleG8.Reto5Ciclo4.Model.Clothe;
import com.exampleG8.Reto5Ciclo4.Service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author raque
 */
@RestController
@RequestMapping("/api/clothe")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService ProdService;
    
    @GetMapping("/all")
    public List<Clothe> getAll() {
        return ProdService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Clothe> getByRef(@PathVariable("reference") String ref) {
        return ProdService.getByRef(ref);
    }
    
    @GetMapping("/price/{price}")
    public List<Clothe> Price(@PathVariable("price") double price) {
        return ProdService.getPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<Clothe> Description(@PathVariable("description") String description) {
        return ProdService.getDescription(description);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe save(@RequestBody Clothe prod) {
        return ProdService.save(prod);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe prod) {
        return ProdService.update(prod);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String ref) {
        return ProdService.delete(ref);
    }
}

