package vaccinationsystem;

import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import static vaccinationsystem.Reservation.reservation;

public class Appointment {
  public String appointmentDate;

    Client appointmentNumber;
   
   
    final static String FILE_NAME = "Appointment.bin";
  
    public static ArrayList<Appointment> Appointments = new ArrayList <Appointment>();
    FileMangerBinary2 FManger =new FileMangerBinary2();
  
    public Appointment (){
    }
    
    public Appointment (String appointmentDate , Client appointmentNumber ) {
        this.appointmentDate = appointmentDate;
        this.appointmentNumber = appointmentNumber; 
    }
      public void setappontmentdate (String appointmentDate) {
        this.appointmentDate = appointmentDate;
      }
      
      
    public void setappointNumber (Client  appointmentNumber) {
        this.appointmentNumber= appointmentNumber;
    }


    public String getappointmentDate () {
        return this.appointmentDate;
    }
 public Client  getappointmentNumber() {
        return this.appointmentNumber;
    }
    
    
           
      private void ReadFromFile() {
           Appointments = (ArrayList<Appointment>) FManger.read(FILE_NAME);
       }
      
      public boolean commitToFile() {
        return FManger.write (FILE_NAME, Appointments);
    }   
        

   public  boolean Check(String appointmentDate) {
      


   for (int k=0 ; k <Appointments.size(); k++ )

           if (Appointments.get(k).getappointmentDate().equals (appointmentDate))
               return true;

      for (Appointment Appointment : Appointments) {
          if (Appointment.getappointmentDate().equals(appointmentDate)) {
              return true;
          }
      }

          return false;
    }
 
   
   
    
        private int getAppointmentIndex(int Number){
        for (int i = 0; i < Appointments.size(); i++)
            if(Appointments.get(i).getappointmentNumber().equals(Number))
                return i;
        
        return -1;
   
       }
  

    protected boolean  deleteAppointment ( int appointmentNumber){
          ReadFromFile();
        int index = getAppointmentIndex ( appointmentNumber); 
    Appointments.remove(index);
    commitToFile();
        return true;
        
    }
    
   
 protected  String DisplayAllAppointments() {
     ReadFromFile();
        String AllApp = "\n All Appointments :\n";
        for (Appointment x : Appointments) {
            AllApp = AllApp + x.toString();
        }
        return AllApp ;
    }

}


  
