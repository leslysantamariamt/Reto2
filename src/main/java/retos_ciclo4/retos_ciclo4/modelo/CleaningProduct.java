/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retos_ciclo4.retos_ciclo4.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author LESLY SANTAMARIA
 */
@Document(collection = "cleaningproducts")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CleaningProduct {

    @Id
    private Integer id;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private Double price;
    private boolean availability = true;
    private Integer quantity;
    private String photography;

}
