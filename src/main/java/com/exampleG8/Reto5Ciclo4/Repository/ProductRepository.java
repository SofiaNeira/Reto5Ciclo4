/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto5Ciclo4.Repository;

import com.exampleG8.Reto5Ciclo4.Interface.ProductInterface;
import com.exampleG8.Reto5Ciclo4.Model.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raque
 */
@Repository
public class ProductRepository {
    @Autowired
    private ProductInterface ProdCrud;
    
    public List<Clothe> getAll(){
        
        return ProdCrud.findAll();
    }
    
    public Optional<Clothe> getByRef (String ref){
        
        return ProdCrud.findById(ref);
        
    }
    
    public List<Clothe> getPrice(double price) {
        return ProdCrud.findByPrice(price);
    }
    
    public List<Clothe> getDescription(String description) {
        return ProdCrud.findByDescriptionContainingIgnoreCase(description);
    }
    
    public Clothe save(Clothe Prod){
        
        return ProdCrud.save(Prod);
    }
    
    public void update(Clothe prod) {
        ProdCrud.save(prod);
    }
    
    
    public void delete(Clothe prod){
        ProdCrud.delete(prod);
    }
}
