/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinationsystem;

import java.util.Date;

/**
 * composition relationship with Invoice
 * composition relationship with Appointment
 */
class Reservation {
    
// Access modifier is changeable but it's better to stay "private"
    private int reservationId;
    private final Appointment appointment;
    private final Invoice invoice;
/**
  * constructor method implements composition relationship
  * remember: you cannot override the constructor in this case. 
 */ 
    Reservation(Appointment appointment,Invoice invoice){
        this.appointment = appointment;
        this.invoice = invoice;
    }

/**
 * @return appointmentDate 
 */
    public Date reserveAppointment(){
        return null;
    }

}
