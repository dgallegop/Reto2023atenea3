/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Repository;

import Model.Gama;
import Model.Repository.CRUD.GamaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dgall
 */
@Repository
public class GamaRepository {
    @Autowired
    private GamaCrudRepository gamaCrudRepository;
    
    public List<Gama> findAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    
    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);      
    }
    
    public Gama save (Gama gama){
        return gamaCrudRepository.save(gama);
    }
  
    public void delete (Gama gama){
        gamaCrudRepository.delete(gama);
    }       
}
