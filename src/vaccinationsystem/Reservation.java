package vaccinationsystem;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;




public class Reservation implements Serializable {
    
    public int ReserId;
    private String comments;

    public String date ;
    private final String ReservationFileName ="Reservation.bin";
    FileMangerBinary2 Fmanger =new FileMangerBinary2();
    public static ArrayList<Reservation> reservation =new ArrayList<>();
    
    public Vaccine vac;
  
    public Reservation(){
           
        
    }
     
    Client c;
    
   public Reservation(int RId ,int cID, String Fname,String Lname, int Age, String Email, int PhoneNumber, String Address,String Gender, String date, Vaccine v){
        /*c.pId= ID;
        c.pFirstName= Fname;
        c.pLastName= Lname;
        c.pAge= Age;
        c.pEmail= Email;
        c.set_cGender(Gender);*/
        this.ReserId = RId;
        this.c = new Client (cID,Age,Fname,Lname,Email,PhoneNumber, Address, Gender);

        this.date = date;
        this.vac= v; 
            
    }
   //Setter & getter
   public void setRID(int RID){
        this.ReserId= RID ;
    }    
    
    public int getRID(){
       return this.ReserId;
    }    
   
    public void setDate(String date){
        this.date = date ;
    }    
    
    public String getDate(){
       return this.date;
    }    
   
   public boolean check (String date ){
       for (Reservation x : reservation){
           if(x.date.equalsIgnoreCase(date))
               return true;
       }
       return false;
   }
    //
      
   
   
      public boolean AddReservation(){
          loadFromFile();
       reservation.add(this);
       return commitToFile();
        }
      /*
      //20150280@Shenouda Farouk@20@Shenouda@yahoo.com@01126524979@Ramsis@Male@Sun Dec 03 01:52:55 EET 2017@swine flu){
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
   
    public Reservation SearchReservationById (int id)
    {
        Reservation temp = new Reservation();
        loadFromFile();
        int index = getReservationIndex(id);
        if (index != -1)
            return  reservation.get(index);
        else 
            return temp;
    }
    
    public ArrayList<Reservation> ListAllReservation (){
        loadFromFile();
        return reservation;
           }
    
        public boolean commitToFile() {
        return Fmanger.write(ReservationFileName, reservation);
    }   
        
    public boolean updateReservation (){
        loadFromFile();
        int index = getReservationIndex(this.ReserId);
        if (index != -1){
             reservation.set(index,this);
             return commitToFile();
        }
        return false;
    }
    
     public boolean deleteReservation (int id)
     {
         loadFromFile();
         int index = getReservationIndex(id);
         if (index != -1){
             reservation.remove(index);
             return commitToFile();
        }
        return false;
    }
         
     
      //20150280@Shenouda Farouk@20@Shenouda@yahoo.com@01126524979@Ramsis@Male@Sun Dec 03 01:52:55 EET 2017@swine flu){

    @Override
    public String toString(){
        return "\n Client Name : " + c.pFirstName + " " + c.pLastName + "\n" + "ID : " + c.pId + " Age : " + c.pAge + "\n"
               +"phone Number : "+ c.cPhoneNumber + "Address : " + c.cAdress + "\n" + "Email : " + c.pEmail + " Gender: " + c.cGender  + "\nAppointment :" + date + "\nVaccineName : " + vac.get_vac() + "\n";
    }
        /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
  
