package vaccinationsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

/*
import static vaccinationsystem.Doctor.Doctors;
*/

public class ReservOfficer extends staff implements Serializable  {
    
   
    public final String ReservOfficerFileName = "ReservOfficer.bin";
    File file = new File(ReservOfficerFileName);
   
    FileMangerBinary2 Fmanger =new FileMangerBinary2();

    public static ArrayList<ReservOfficer> reservOfficers = new ArrayList<ReservOfficer>();
  
    public ReservOfficer() {}
    
   
    
    public ReservOfficer(int pId, int pAge, String pFirstName, String pLastName, String pEmail, String sUserName, String sPassword, double sSalary) {
        super(pId, pAge, pFirstName, pLastName, pEmail, sUserName, sPassword, sSalary);
   
   }
   /*
     Reservation reservation;
   public void AddNewReservation (int ID ,String Fname,String Lname, int age, String Email,String Gender, Appointment apoint, String VaccineName){
       
       this.reservation = new Reservation (ID, Fname, Lname, age,  Email, Gender, apoint,VaccineName);
       
    if (reservation.AddReservation()) {
       System.out.println(reservation.toString() + "added successfully");
    } else {
       System.out.println("Failed to insert ... !");
    }
       }
   */
  
   Reservation reservation;
   Invoice INVO;
   
   public void AddNewReservation (int ID ,String Fname,String Lname, int age, String Email,String Gender, String date , String VaccineName){
       
       this.reservation = new Reservation (ID, Fname, Lname, age,  Email, Gender, date ,VaccineName);
       
    if (reservation.AddReservation()) {
       System.out.println(reservation.toString() + "added successfully");
        //INVO.Generateinvoices(Fname + Lname , age , date , VaccineName);

    } else {
       System.out.println("Failed to insert ... !");
    }
       }
   
  /*
    public void set_reservation(Reservation reservation){
        this.reservation = reservation;
    }
    */
   
   public boolean addReservOfficer() {
        loadFromFile();
        reservOfficers.add(this);
        return commitToFilee();
}
         
         private void loadFromFile() {
            if(file.length()!=0)
             reservOfficers = (ArrayList<ReservOfficer>) this.Fmanger.read(ReservOfficerFileName);
    }
     public ArrayList<ReservOfficer> displayAllReservOfficers() {
        loadFromFile();
        return reservOfficers;
    }

    

    private int getReservOfficersIndex(int id){
        for (int i = 0; i < reservOfficers.size(); i++)
            if(reservOfficers.get(i).getPId()== id)
                return i;
        
        return -1;
    }
   



  public ReservOfficer searchResById(int id) {
        ReservOfficer temp = new ReservOfficer();
        loadFromFile();
        int index = getReservOfficersIndex(id);
        if (index != -1) {
            return reservOfficers.get(index);
        } else {
            return temp;
        }
    }
  
   public boolean commitToFilee() {
        return Fmanger.write( ReservOfficerFileName,reservOfficers);
    }
  
  
  
  
  
   public boolean UpdateRes() {
        loadFromFile();
        int index = getReservOfficersIndex(this.pId);

        if (index != -1) {
            reservOfficers.set(index, this);

            return commitToFilee();
        }

        return false;
    }

public boolean deleteRess(int id) {
        loadFromFile();
        int index = getReservOfficersIndex(id);

        if (index != -1) {
            reservOfficers.remove(index);

            return commitToFilee();
        }

        return false;
    }
  
public void updateRes(int oldID, ReservOfficer x){
        loadFromFile();
        int index = getReservOfficersIndex(oldID);
        reservOfficers.set(index, x);
        commitToFilee();
    } 
    
    public void deleteRes(int id){
        loadFromFile();
        int index = getReservOfficersIndex(id);
        reservOfficers.remove(index);
        commitToFilee();
    } 
           
    @Override
    public String toString() {
        return "I'm Reservation Officer : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary;
    } 
    @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (ReservOfficer x : reservOfficers ) {
            if (userName.equals(x.sUserName) && Pass.equals(x.sPassword)) {
                return true;
            }
        }
        return false;
    }
       
}
