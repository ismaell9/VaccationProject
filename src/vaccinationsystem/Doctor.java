package vaccinationsystem;

import java.util.ArrayList;
import java.util.Date;

/**
 * test editing 1
 * other functionality might be added to this class
 */
public class Doctor extends staff{
    
    private Date appointmentDate;
    private boolean isAvilable;
   public final String doctorFileName = "doctor.txt";
     public static ArrayList<Doctor> Doctors = new ArrayList<Doctor>();
  FileManger FManger = new FileManger();

    
    public Doctor(int pId, int pAge, String pFirstName, String pLastName, String pEmail, String sUserName, String sPassword, double sSalary) {
        super(pId, pAge, pFirstName, pLastName, pEmail, sUserName, sPassword, sSalary);
    }

    public Doctor() {
    }

    
public void displayReservation(){
    Reservation r = new Reservation();
    String se = r.displayAllReservation();
    System.out.println(se);
}
    


public boolean adddoctor() {
        if (this.FManger.write(this.getDoctorData(), "doctor.txt", true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getDoctorData() {
        return this.pId + "@"+ this.pAge+ "@" +this.pFirstName + "@" + this.pLastName + "@" + this.pEmail + "@" + this.sUserName + "@" + this.sPassword + "@" + this.sSalary+ "@" ;
   
    } 

      private void loadFromFile() {
            Doctors = (ArrayList<Doctor>) (Object) FManger.read("doctor.txt");
    }

    
    
   public ArrayList<Doctor> displayAllDoctors() {
        loadFromFile();
        String S = "\nAll Doctors Data:\n";
        for (Doctor x : Doctors) {
            S = S + x.toString();
        }
        return Doctors;
    }

    private int getDocIndex(int id){
        for (int i = 0; i < Doctors.size(); i++)
            if(Doctors.get(i).getPId()== id)
                return i;
        
        return -1;
    }
    

  
 public String searchDoctor(int id){
        loadFromFile();
        int index = getDocIndex(id);
        if(index != -1)
            return "\nFound ...!" + Doctors.get(index).toString();
        else 
            return "\nNot Found ...!";
    }

  private void commitToFile() {
        FManger.write(Doctors.get(0).getDoctorData(), doctorFileName, false);
        for (int i = 1; i < Doctors.size(); i++) {
            FManger.write(Doctors.get(i).getDoctorData(), doctorFileName, true);
        }

    }
 
   public boolean commitToFilee() {
        return FManger.write(doctorFileName ,Doctors);
    }
  
  
  
  
  
   public boolean UpdateDoc() {
        loadFromFile();
        int index = getDocIndex(this.pId);

        if (index != -1) {
            Doctors.set(index, this);

            return commitToFilee();
        }

        return false;
    }

public boolean deleteDocc(int id) {
        loadFromFile();
        int index = getDocIndex(id);

        if (index != -1) {
            Doctors.remove(index);

            return commitToFilee();
        }

        return false;
    }
public void updateDoc(int oldID, Doctor x){
        loadFromFile();
        int index = getDocIndex(oldID);
        Doctors.set(index, x);
        commitToFile();
    } 
    
    public void deleteDoc(int id){
        loadFromFile();
        int index = getDocIndex(id);
        Doctors.remove(index);
        commitToFile();
    } 
    
    @Override
    public String toString() {
        return "I'm doctor : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary;
    }
    
    
     public Doctor searchDocById(int id) {
        Doctor temp = new Doctor();
        loadFromFile();
        int index = getDocIndex(id);
        if (index != -1) {
            return Doctors.get(index);
        } else {
            return temp;
        }
    }
    
    
  @Override 
     public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Doctor x : Doctors) {
            if (userName.equals(x.sUserName) && Pass.equals(x.sPassword)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
   
    
  
}
