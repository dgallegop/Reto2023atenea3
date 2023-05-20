 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dgall
 */
@Entity
@Table (name="message")

public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    //carros
    
    @ManyToOne 
    @JoinColumn (name = "carId")
    @JsonIgnoreProperties({"messages" , "reservations"})
    private Car car;

        //(cascade = {cascadeType.PERSIST}, mappedBy = "car")
    //cliente
    
    @ManyToOne
    @JoinColumn (name ="clientId")
    @JsonIgnoreProperties ({"messages" , "reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
