/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos_ciclo4.retos_ciclo4.interfaces;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import retos_ciclo4.retos_ciclo4.modelo.CleaningProduct;

/**
 *
 * @author LESLY SANTAMARIA
 */
public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, Integer> {
    public List<CleaningProduct> findByPriceLessThanEqual(double precio);
    //Reto 5

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByDescriptionLike(String description);
}
