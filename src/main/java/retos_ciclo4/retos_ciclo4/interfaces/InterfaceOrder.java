/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos_ciclo4.retos_ciclo4.interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import retos_ciclo4.retos_ciclo4.modelo.Order;

/**
 *
 * @author LESLY SANTAMARIA
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer>{
  
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
