/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos_ciclo4.retos_ciclo4.repositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import retos_ciclo4.retos_ciclo4.interfaces.InterfaceOrder;
import retos_ciclo4.retos_ciclo4.modelo.Order;


/**
 *
 * @author LESLY SANTAMARIA
 */
@Repository
public class OrderRepositorio {
    @Autowired
    private InterfaceOrder orderCrudRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

    public Optional<Order> lastUserId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    
    //Métodos del reto 4
    //Reto 4: Ordenes de un asesor
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();
        
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        
        List<Order> order = mongoTemplate.find(query, Order.class);
        
        return order;
        
    }
    
    //Reto 4: Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                            .and("status").is(state);
        
        query.addCriteria(criterio);
        
        List<Order> order = mongoTemplate.find(query,Order.class);
        
        return order;
    }
    
    //Reto 4: Ordenes de un asesor x Fecha
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
			.gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
			.lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
			.and("salesMan.id").is(id);
        
        query.addCriteria(dateCriteria);
        
        List<Order> order = mongoTemplate.find(query,Order.class);
        
        return order;       
    }
}
