/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto5Ciclo4.Service;

import com.exampleG8.Reto5Ciclo4.Model.Clothe;
import com.exampleG8.Reto5Ciclo4.Repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class ProductService {
/**
     * Instancia de repositorio
     */
    @Autowired
    private ProductRepository ProdRepo;
    
    /**
     * Método Listar todos los usuarios
     * @return 
     */
    public List<Clothe> getAll(){
        return ProdRepo.getAll();
    }
    
    /**
     * Consultar producto por ID
     * @param ref
     * @return 
     */
    public Optional <Clothe> getByRef(String ref){
        return ProdRepo.getByRef(ref);
    }
    
    /**
     * Método Crear nuevo product
     * @param prod
     * @return 
     */
    public Clothe save(Clothe prod){
        if(prod.getReference() == null){
            return prod;
        }else{
            return ProdRepo.save(prod);
        }
        
    }
    
    /**
     * Método para obtener precio
     * @param price
     * @return 
     */
    public List<Clothe> getPrice(double price) {
        return ProdRepo.getPrice(price);
    }
    
    /**
     * Método para obtener descripción
     * @param description
     * @return 
     */
    public List<Clothe> getDescription(String description) {
        return ProdRepo.getDescription(description);
    }
    
    /**
     * Método Actualizar Producto
     * @param prod
     * @return 
     */
    public Clothe update(Clothe prod){
        if (prod.getReference() != null) {
            Optional<Clothe> prodDb = ProdRepo.getByRef(prod.getReference());
            if (!prodDb.isEmpty()) {
                if (prod.getCategory() != null) {
                    prodDb.get().setCategory(prod.getCategory());
                }
                if (prod.getSize() != null) {
                    prodDb.get().setSize(prod.getSize());
                }

                if (prod.getDescription() != null) {
                    prodDb.get().setDescription(prod.getDescription());
                }
                prodDb.get().setAvailability(prod.isAvailability());
                if (prod.getPrice() != 0.0) {
                    prodDb.get().setPrice(prod.getPrice());
                }
                if (prod.getQuantity() != 0) {
                    prodDb.get().setQuantity(prod.getQuantity());
                }
                if (prod.getPhotography() != null) {
                    prodDb.get().setPhotography(prod.getPhotography());
                }
                
                ProdRepo.update(prodDb.get());
                return prodDb.get();
            } else {
                return prod;
            }
        } else {
            return prod;
        }
    }
    
    /**
     * Método Eliminar usuario por ID
     * @param ref
     * @return 
     */
    public boolean delete(String ref) {
        Boolean aBoolean = getByRef(ref).map(reference -> {
            ProdRepo.delete(reference);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
