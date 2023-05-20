/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Repository.ReservationRepository;
import Model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dgall
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation car){
        if(car.getIdReservation()==null){
            return reservationRepository.save(car);
        }else{
            Optional <Reservation> carEncontrado = getReservation(car.getIdReservation());
            if (carEncontrado.isEmpty()){
                return reservationRepository.save(car);        
            }else {
                return car;
            }
        }
    }
    
    public Reservation update (Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional <Reservation> reservationEncontrado= getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isPresent() ){
                if (reservation.getStartDate()!=null){
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getStatus()!=null){
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                if (reservation.getDevolutionDate()!=null){
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                return reservationRepository.save(reservationEncontrado.get());
            } else {
                return reservation;
            }
            
        }else{
            return reservation;
        }
    }
    public boolean deleteReservation (int id){
        boolean respuesta = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        //Date fecha = new Date()
        return respuesta;
    }    
}
