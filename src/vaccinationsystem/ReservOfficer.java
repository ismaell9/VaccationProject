package vaccinationsystem;

import java.util.ArrayList;
import java.util.Date;

/*
import static vaccinationsystem.Doctor.Doctors;
*/

public class ReservOfficer extends staff{
    
   
   private final String ReservOfficerFileName = "ReservOfficer.txt";
   
   FileManger FManger = new FileManger();
   
   public static ArrayList<ReservOfficer> reservOfficers = new ArrayList<ReservOfficer>();
  
    ReservOfficer() {
    }
    
       public ReservOfficer(int pId, int pAge, String pFirstName, String pLastName, String pEmail, String sUserName, String sPassword, double sSalary) 
   {         super(pId, pAge, pFirstName, pLastName, pEmail, sUserName, sPassword, sSalary);
   
   }
   
     Reservation reservation;
   public void AddNewReservation (int ID ,String Fname,String Lname, int age, String Email,String Gender, Appointment apoint, String VaccineName){
       
       this.reservation = new Reservation (ID, Fname, Lname, age,  Email, Gender, apoint,VaccineName);
    if (reservation.AddReservation()) {
       System.out.println(reservation.toString() + "added successfully");
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
        if (this.FManger.write(this.getReservOfficerData(),ReservOfficerFileName, true)) 
        {
            return true;
        } else {
            return false;
        }
}
         private String getReservOfficerData() {
        return this.pId + "@" + this.pFirstName + "@" + this.pLastName + "@" + this.pAge + "@" + this.pEmail + "@" + this.sUserName + "@" + this.sPassword+ "@" + this.sSalary + "@";
    }
     
         private void loadFromFile() {
            reservOfficers = (ArrayList<ReservOfficer>) (Object) FManger.read("ReservOfficer.txt");
    }
    
    
  public String displayAllReservOfficers() {
        loadFromFile();
        String S = "\nAll Professors Data:\n";
        for (ReservOfficer x : reservOfficers) {
            S = S + x.toString();
        }
        return S;
    }

    private int getReservOfficersIndex(int id){
        for (int i = 0; i < reservOfficers.size(); i++)
            if(reservOfficers.get(i).getPId()== id)
                return i;
        
        return -1;
    }
    
  
 public String searchReservOfficer(int id){
        loadFromFile();
        int index = getReservOfficersIndex(id);
        if(index != -1)
            return "\nFound ...!" + reservOfficers.get(index).toString();
        else 
            return "\nNot Found ...!";
    }

  private void commitToFile() {
        FManger.write(reservOfficers.get(0).getReservOfficerData(),ReservOfficerFileName, false);
        for (int i = 1; i < reservOfficers.size(); i++) {
            FManger.write(reservOfficers.get(i).getReservOfficerData(), ReservOfficerFileName, true);
        }

    }
 
public void updateRes(int oldID, ReservOfficer x){
        loadFromFile();
        int index = getReservOfficersIndex(oldID);
        reservOfficers.set(index, x);
        commitToFile();
    } 
    
    public void deleteRes(int id){
        loadFromFile();
        int index = getReservOfficersIndex(id);
        reservOfficers.remove(index);
        commitToFile();
    } 
           
    @Override
    public String toString() {
        return "I'm Reservation Officer : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary;
    } 
    
       
}