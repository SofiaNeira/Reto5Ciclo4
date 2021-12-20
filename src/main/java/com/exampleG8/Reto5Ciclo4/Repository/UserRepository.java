/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto5Ciclo4.Repository;


import com.exampleG8.Reto5Ciclo4.Interface.UserInterface;
import com.exampleG8.Reto5Ciclo4.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raque
 */
@Repository
public class UserRepository {
    @Autowired
    private UserInterface UserCrud;
    
    public List<User> getAll(){
        return UserCrud.findAll();
    }
    
    public Optional<User> getById (Integer id){
        
        return UserCrud.findById(id);
        
    }
    
    public boolean existsEmail(String email){
        Optional <User> usuario = UserCrud.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional <User> getEmailAndPass(String email, String password){
        return UserCrud.findByEmailAndPassword(email, password);
         
    }
    
    public List<User> getMonth(String month){
        return (List<User>) UserCrud.findByMonthBirthtDay(month);
    }
    
    public User save(User user){
        
        return UserCrud.save(user);
    }
    
//    public void update(User user){
//        UserCrud.save(user);
//    }
    
    public void delete(User user){
        UserCrud.delete(user);
    }
}
