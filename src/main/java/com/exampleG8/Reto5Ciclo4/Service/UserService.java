/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto5Ciclo4.Service;

import com.exampleG8.Reto5Ciclo4.Model.User;
import com.exampleG8.Reto5Ciclo4.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class UserService {
    /**
     * Instancia de Repositorio
     */
    @Autowired
    private UserRepository UserRepo;
    
    /**
     * Método Listar todos los usuarios
     * @return 
     */
    public List<User> getAll(){
        return UserRepo.getAll();
    }
    
    /**
     * Método consultar usuario por ID
     * @param identifir 
     * @return 
     */
    public Optional<User> getById(Integer identifir){
        return UserRepo.getById(identifir);
    }
      
    /**
     * Consultar email existente
     * @param email
     * @return 
     */
    public boolean existsEmail(String email){
        return UserRepo.existsEmail(email);
    }
    
    /**
     * Consultar combinación email/contraseña
     * @param email
     * @param password
     * @return 
     */
    public User loginUser(String email, String password){
        Optional <User> usuario = UserRepo.getEmailAndPass(email, password);
        if(usuario.isEmpty()){
            return new User();
        }else{
            return usuario.get();
        }
        
    }
    
    /**
     * Método para obtener día de cumpleaños
     * @param month
     * @return 
     */
    public List<User> getMonth(String month) {
        return UserRepo.getMonth(month);
    }
    
    
    /**
     * Método Crear usuario
     * @param user
     * @return 
     */
    public User save(User user){
        
        if(user.getId() == null){
            return user;
        } else {
            Optional <User> event = UserRepo.getById(user.getId());
            if(event.isEmpty()){
                if(existsEmail(user.getEmail()) == false){
                    return UserRepo.save(user);
                } else {
                    return user;
                }  
            } else {
                return user;
            }
        } 
    }
    
    /**
     * Método Actualizar Usuario
     * @param user
     * @return 
     */
    public User update(User user){


          if(user.getId() != null){
              
              Optional <User> existUser = UserRepo.getById(user.getId());
              if(!existUser.isEmpty()){
                  if(user.getIdentification() != null){
                      existUser.get().setIdentification(user.getIdentification());
                  }
                  if(user.getName() != null){
                      existUser.get().setName(user.getName());
                  }
                  if(user.getAddress() != null){
                      existUser.get().setAddress(user.getAddress());
                  }
                  if(user.getCellPhone() != null){
                      existUser.get().setCellPhone(user.getCellPhone());
                  }
                  if(user.getEmail() != null){
                      existUser.get().setEmail(user.getEmail());
                  }
                  if(user.getPassword() != null){
                      existUser.get().setPassword(user.getPassword());
                  }
                  if(user.getZone() != null){
                      existUser.get().setZone(user.getZone());
                  }
                  if(user.getType() != null){
                      existUser.get().setType(user.getType());
                  }
                  
                  UserRepo.save(existUser.get());
                  return existUser.get();
              } else{
                  return user;
              } 
   
          } else {
              return user;
          }
          
    }
    
    /**
     * Método Eliminar usuario por ID
     * @param identifir 
     * @return  
     */
    public boolean delete(Integer identifir){
        boolean usuario= getById(identifir).map(user -> {
            UserRepo.delete(user);
            return true;
        }).orElse(false);
        return usuario;
    }
}
