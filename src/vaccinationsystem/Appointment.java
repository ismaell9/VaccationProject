package vaccinationsystem;

import java.util.Date;
import java.util.ArrayList;
/**
 * appointment file must be created within this class
 * 
 */
public class Appointment {
    protected Date appointmentDate;
    Person pFirstName;
    Person pLastName;
    Client appointmentNumber;
   
   
    public static ArrayList<Appointment> Appointments = new ArrayList <Appointment>();
    private final String AppointmentFileName = "Appointment.txt";
    FileManger FManger = new FileManger();
  
    public Appointment (){
    }
    
    public Appointment (Date appointmentDate , Person pFirstName,Person pLastName, Client appointmentNumber ) {
        this.appointmentDate = appointmentDate;
        this. pFirstName= pFirstName;
        this.pLastName = pLastName;
        this.appointmentNumber = appointmentNumber; 
    }
      public void setappontmentdate (Date appointmentDate) {
        this.appointmentDate = appointmentDate;
      }
      
      
    public void setappointNumber (Client  appointmentNumber) {
        this.appointmentNumber= appointmentNumber;
    }

    public Date getappointmentDate (Date appointmentDate) {
        return this.appointmentDate;
    }
 public Client  getappointmentNumber() {
        return this.appointmentNumber;
    }
  /**
 * add appointment to appointment file
 * return type is changeable
 * @return true if added, false if not
 */    
    public boolean addAppointment(){
        
        if (FManger.write(getData(), AppointmentFileName, true)) 
                  
        return true;
       
                  else {
            return false;
        }
    }
      private String  getData() {
       return "The First Name :  "+ this.pFirstName + " //3wzah ynzl str lt7t " +  "The Last NAme : "+
               this.pLastName + "@" +"The Appointment Number :"+this.appointmentNumber +"The Appointment Date :" 
               + this.appointmentDate + "@";
    
      }
      
           
    //write in file
      private void ReadFromFile() {
           Appointments = (ArrayList<Appointment>) (Object) FManger.read(AppointmentFileName);
       }
      //update eldata b3d el search w el delete 
         private void updateToFile() {
        FManger.write(Appointments.get(0).getData(), AppointmentFileName, false);
        for (int i = 1; i < Appointments.size(); i++) {
            FManger.write(Appointments.get(i).getData(),AppointmentFileName, true);
        }

    }

    
        private int getAppointmentIndex(int Number){
        for (int i = 0; i < Appointments.size(); i++)
            if(Appointments.get(i).getappointmentNumber().equals(Number))
                return i;
        
        return -1;
    }
    
       
/**
 * delete appointment from appointment file
 * return type is changeable
 * @return true if deleted, false if not
 */    
    public boolean  deleteAppointment ( int appointmentNumber){
          ReadFromFile();
        int index = getAppointmentIndex ( appointmentNumber); 
    Appointments.remove(index);
     //na2s yms7 mn el ile w y update 
        return true;
        
    }
   
/**
 * 
 * edit appointment in appointment file
 * return type is changeable
 * @return true if updated, false if not
 */    
 

    public boolean updateAppointments (int oldAppnumber , Appointment x){
        ReadFromFile();
        DisplayAllAppointments();
        int index= getAppointmentIndex(oldAppnumber);
        Appointments.set(index , x);
        updateToFile();
        return true;
    } 
    /**
 * prints all appointments in appointment file
 * return type is changeable
 * @return object array of all invoices from invoices file
 */    
    

 public String DisplayAllAppointments() {
     ReadFromFile();
        String AllApp = "\n All Appointments :\n";
        for (Appointment x : Appointments) {
            AllApp = AllApp + x.toString();
        }
        return AllApp ;
    }

   public  boolean Check(String _vac) {
       return false;
    }
 
}