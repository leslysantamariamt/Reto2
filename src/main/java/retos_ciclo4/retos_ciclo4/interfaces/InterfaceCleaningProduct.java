/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos_ciclo4.retos_ciclo4.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import retos_ciclo4.retos_ciclo4.modelo.CleaningProduct;

/**
 *
 * @author LESLY SANTAMARIA
 */
public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, Integer> {
}
