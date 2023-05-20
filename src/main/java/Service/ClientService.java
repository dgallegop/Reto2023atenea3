/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Client;
import Model.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dgall
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional <Client> clientEncontrado = getClient(client.getIdClient());
            if (clientEncontrado.isEmpty()){
                return clientRepository.save(client);        
            }else {
                return client;
            }
        }
    }
    
    public Client update (Client client){
        if(client.getIdClient()!=null){
            Optional <Client> clientEncontrado= getClient(client.getIdClient());
            if (clientEncontrado.isPresent() ){
                if (client.getEmail()!=null){
                    clientEncontrado.get().setEmail(client.getEmail());
                }
                if (client.getName()!=null){
                    clientEncontrado.get().setName(client.getName());
                }
                if (client.getAge()!=null){
                    clientEncontrado.get().setAge(client.getAge());
                }
                if (client.getPassword()!=null){
                    clientEncontrado.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientEncontrado.get());
            } else {
                return client;
            }
            
        }else{
            return client;
        }
    }
    public boolean deleteClient (int id){
        boolean respuesta = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        //Date fecha = new Date()
        return respuesta;
    }    
}
