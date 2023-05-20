/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Repository.CRUD;

import Model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dgall
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
