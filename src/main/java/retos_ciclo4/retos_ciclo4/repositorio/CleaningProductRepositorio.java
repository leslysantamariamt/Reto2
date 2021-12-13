/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos_ciclo4.retos_ciclo4.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import retos_ciclo4.retos_ciclo4.interfaces.InterfaceCleaningProduct;
import retos_ciclo4.retos_ciclo4.modelo.CleaningProduct;

/**
 *
 * @author LESLY SANTAMARIA
 */
@Repository
public class CleaningProductRepositorio {
    
    @Autowired
    private InterfaceCleaningProduct repository;
    
    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getCleaningProduct(Integer id) {
        return repository.findById(id);
    }
    
    public CleaningProduct create(CleaningProduct cleaningProduct) {
        return repository.save(cleaningProduct);
    }

    public void update(CleaningProduct cleaningProduct) {
        repository.save(cleaningProduct);
    }
    
    public void delete(CleaningProduct cleaningProduct) {
        repository.delete(cleaningProduct);
    }
}
