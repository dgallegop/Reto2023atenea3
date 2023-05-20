/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Message;
import Model.Repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dgall
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional <Message> messageEncontrado = getMessage(message.getIdMessage());
            if (messageEncontrado.isEmpty()){
                return messageRepository.save(message);        
            }else {
                return message;
            }
        }
    }
    
    public Message update (Message message){
        if(message.getIdMessage()!=null){
            Optional <Message> messageEncontrado= getMessage(message.getIdMessage());
            if (messageEncontrado.isPresent() ){
                if (message.getMessageText()!=null){
                    messageEncontrado.get().setMessageText(message.getMessageText());
                }

                return messageRepository.save(messageEncontrado.get());
            } else {
                return message;
            }
            
        }else{
            return message;
        }
    }
    public boolean deleteMessage (int id){
        boolean respuesta = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        //Date fecha = new Date()
        return respuesta;
    }    
}
