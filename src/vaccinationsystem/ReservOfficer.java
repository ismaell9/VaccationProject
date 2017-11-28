package vaccinationsystem;

import java.util.ArrayList;
import static vaccinationsystem.Doctor.Doctors;

/**
 *
 *
 */
public class ReservOfficer extends staff{
/**
 * create instance of Reservation class
 * use it to access Reservation methods as aggregation
 */
    private Reservation reservation;
private final String ReservOfficerFileName = "=ReservOfficer.txt";
  FileManger FManger = new FileManger();
  public static ArrayList<ReservOfficer> ReservOfficers = new ArrayList<ReservOfficer>();
    ReservOfficer() {
    }

    ReservOfficer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    public void set_reservation(Reservation reservation){
        this.reservation = reservation;


    }
    
    public ReservOfficer (int pId,int pAge,String pFirstName,String pLastName ,String pEmail,String sUsername,String sPassword,double sSalary){
   super(pId,pAge,pFirstName,pLastName,pEmail,sUsername,sPassword,sSalary);
}

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
            Doctors = (ArrayList<Doctor>) (Object) FManger.read("doctor.txt");
    }

    
    
  public String displayAllReservOfficers() {
        loadFromFile();
        String S = "\nAll Professors Data:\n";
        for (ReservOfficer x : ReservOfficers) {
            S = S + x.toString();
        }
        return S;
    }

    private int getReservOfficersIndex(int id){
        for (int i = 0; i < ReservOfficers.size(); i++)
            if(ReservOfficers.get(i).getPId()== id)
                return i;
        
        return -1;
    }
    

  
 public String searchReservOfficer(int id){
        loadFromFile();
        int index = getReservOfficersIndex(id);
        if(index != -1)
            return "\nFound ...!" + ReservOfficers.get(index).toString();
        else 
            return "\nNot Found ...!";
    }

  private void commitToFile() {
        FManger.write(ReservOfficers.get(0).getReservOfficerData(),ReservOfficerFileName, false);
        for (int i = 1; i < ReservOfficers.size(); i++) {
            FManger.write(ReservOfficers.get(i).getReservOfficerData(), ReservOfficerFileName, true);
        }

    }
 
 
 

public void updateRes(int oldID, ReservOfficer x){
        loadFromFile();
        int index = getReservOfficersIndex(oldID);
        ReservOfficers.set(index, x);
        commitToFile();
    } 
    
    public void deleteRes(int id){
        loadFromFile();
        int index = getReservOfficersIndex(id);
        ReservOfficers.remove(index);
        commitToFile();
    } 
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
    @Override
    public String toString() {
        return "I'm ReservOfficer : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary;
    }

    
    
    
    
    
    
    
    
    
    
    
    
}


