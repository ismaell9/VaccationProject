package vaccinationsystem;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Reservation implements Serializable {
    Appointment appoint;
    public String date ;
    private static final long serialVersionUID = 6L;
    private final String ReservationFileName ="Reservation.bin";
    private final File file = new File(ReservationFileName);
    FileMangerBinary2 Fmanger =new FileMangerBinary2();
    public static ArrayList<Reservation> reservation =new ArrayList<>();
    
    Client c = new Client ();
    Vaccine v= new Vaccine ();
  
    public Reservation(){
        if(!this.file.exists()){
            try {
            this.file.createNewFile();
            } catch (IOException ex) {
             Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    
   public Reservation(int ID, String Fname,String Lname, int Age, String Email,String Gender, String date, String VaccineName){
        c.pId= ID;
        c.pFirstName= Fname;
        c.pLastName= Lname;
        c.pAge= Age;
        c.pEmail= Email;
        c.set_cGender(Gender);

        this.date = date;
        /*this.appoint= appoint;*/
        v.set_vac(VaccineName);
        if(!this.file.exists()){
            try {
            this.file.createNewFile();
            } catch (IOException ex) {
             Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }

    //setter
      
    public void setAppointment (Appointment appoint)
    {
        this.appoint = appoint;
    }
       
   
      public boolean AddReservation(){
          loadFromFile();
       reservation.add(this);
       return commitToFile();
        }
      /*
      //20150280@Shenouda Farouk@20@Shenouda@yahoo.com@Male@Sun Dec 03 01:52:55 EET 2017@swine flu){
   private String getReservationData (){
       return   c.pId + "@" + c.pFirstName + "@" + c.pLastName + "@" + c.pAge + "@" + c.pEmail + "@" + c.get_cGender() + "@" + this.appoint + v.get_vac() ;
   }
  */
   private void loadFromFile (){
        reservation = (ArrayList <Reservation>)this.Fmanger.read(ReservationFileName);
   }
   private int getReservationIndex (int id)
   {
       for (int i=0 ; i <reservation.size(); i++ )
           if (reservation.get(i).c.getPId()== id)
               return i;
       
          return -1;
    }
    public String SearchReservation (int id)
    {
        loadFromFile();
        int index = getReservationIndex(id);
        if (index != -1)
            return "\nFound ...!" + reservation.get(index).toString();
        else 
            return "\nNot Found";        
    }
    public String displayAllReservation (){
        loadFromFile();
        String s = "\n All Reservation Data:\n";
                for (Reservation x : reservation){
                   s =s + x.toString();
                   }
                return s;
           }
    
        public boolean commitToFile() {
        return Fmanger.write(ReservationFileName, reservation);
    }   
        
    public void updateReservation (int oldID, Reservation x){
        loadFromFile();
        int index = getReservationIndex(oldID);
        reservation.set(index, x);
        commitToFile();
    }
     public void deleteReservation (int id)
     {
         loadFromFile();
         int index = getReservationIndex(id);
         reservation.remove(index);
         commitToFile();
     }
    
    @Override
    public String toString(){
        return "\n Client Name : " + c.pFirstName + " " + c.pLastName + "\n" + "ID : " + c.pId + " Age : " + c.pAge + "\n"
                + "Email : " + c.pEmail + " Gender: " + c.get_cGender() + "\nAppointment :" + appoint + "\nVaccineName : " + v.get_vac() + "\n";
    }
}
  
