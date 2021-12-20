/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto5Ciclo4.Service;

import com.exampleG8.Reto5Ciclo4.Model.Order;
import com.exampleG8.Reto5Ciclo4.Repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
    
    public Optional<Order> getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }
    
    public Order create(Order order){
        if(order.getId()!= null){
            return orderRepository.create(order);
        }else{
            return order;
        }
    }
    
    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orden = orderRepository.getOrder(order.getId());
            if(!orden.isEmpty()) {

                if (order.getId() != null) {
                    orden.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    orden.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orden.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orden.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(orden.get());
                return orden.get();
            }else{
                return order;
            }
        } else {
            return order;
        }
    }
    
    public boolean delete(Integer id) {
        return getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);        
    }
    
    public List<Order> getZone(String zone){
        return orderRepository.getZone(zone);
    }

    public List<Order> getBySalesManId(Integer id){
        return orderRepository.getBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderRepository.getBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay,id);
    }
}
