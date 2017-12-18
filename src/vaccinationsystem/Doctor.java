package vaccinationsystem;


import java.io.Serializable;
import java.util.ArrayList;


/**
 * test editing 1
 * other functionality might be added to this class
 */
public class Doctor extends staff implements Serializable{
    
   
    public final String doctorFileName = "doctor.bin";
   
    public static ArrayList<Doctor> Doctors = new ArrayList<Doctor>();
    
            
    
public Doctor(int pId, int pAge, String pFirstName, String pLastName, String pEmail, String sUserName, String sPassword, double sSalary) {
    super(pId, pAge, pFirstName, pLastName, pEmail, sUserName, sPassword, sSalary);
              
}

public Doctor() {
       
    
}
     ArrayList<Reservation> reserv =new ArrayList<>();

public void displayReservation(){
    Reservation r = new Reservation();
     reserv = r.ListAllReservation();
}
    


public boolean adddoctor() {
    loadFromFile();
    Doctors.add(this);
    return commitToFilee();
}
      
 
    public boolean commitToFilee() {
        return FManger.write(doctorFileName ,Doctors);
   }

    private void loadFromFile() {
        
           Doctors =(ArrayList <Doctor>)this.FManger.read(doctorFileName);
 
    }
   
    private int getDocIndex(int id){
        for (int i = 0; i < Doctors.size(); i++)
            if(Doctors.get(i).getPId()== id)
                return i;
        
        return -1;
    }
    
    public Doctor searchDoctorById(int id){
     Doctor temp = new Doctor  ();
        loadFromFile();
        int index = getDocIndex(id);
        if(index != -1){
        return   Doctors.get(index);
        }
        else {
            return temp; 
        }
 }
  
    
   public ArrayList<Doctor> listDoctors() {
        loadFromFile();
        return Doctors;
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


    
    @Override
    public String toString() {
        return "I'm doctor : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary + "\tEmail: " + pEmail;
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
