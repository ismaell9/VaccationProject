package vaccinationsystem;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * test editing 1
 * other functionality might be added to this class
 */
public class Doctor extends staff implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Date appointmentDate;
    private boolean isAvilable;
    public final String doctorFileName = "doctor.bin";
    File file = new File(doctorFileName);
    public static ArrayList<Doctor> Doctors = new ArrayList<Doctor>();
    FileMangerBinary2 Fmanger =new FileMangerBinary2();
    private String firstName;
    private String lastName ;
    private String email    ;
    private String userName ;
    private double salary   ;
    private int    Id       ;
    private String password ;
    private int    age      ;
            
    
public Doctor(int pId, int pAge, String pFirstName, String pLastName, String pEmail, String sUserName, String sPassword, double sSalary) {
    super(pId, pAge, pFirstName, pLastName, pEmail, sUserName, sPassword, sSalary);
        firstName = this.getPFirstName();
        lastName = this.getPLastName();
        email = this.getPEmail();
        userName = this.getUserName();
        salary = this.getSalary();
        Id = this.getPId();
        password = this.getPassword();
        age = this.getPAge();
        if(!this.file.exists()){
            try {
            this.file.createNewFile();
            } catch (IOException ex) {
             Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
}

public Doctor() {
        if(!this.file.exists()){
            try {
            this.file.createNewFile();
            } catch (IOException ex) {
             Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}

    
public void displayReservation(){
    Reservation r = new Reservation();
    String se = r.displayAllReservation();
    System.out.println(se);
}
    


public boolean adddoctor() {
    loadFromFile();
    Doctors.add(this);
    return commitToFilee();
}
      

    private void loadFromFile() {
      if(file.length()!=0){ 
           Doctors =(ArrayList <Doctor>)this.Fmanger.read(doctorFileName);
      }

    }

    
    
   public ArrayList<Doctor> displayAllDoctors() {
        loadFromFile();
        return Doctors;
    }

    private int getDocIndex(int id){
        for (int i = 0; i < Doctors.size(); i++)
            if(Doctors.get(i).getPId()== id)
                return i;
        
        return -1;
    }
     
    

  
 public Doctor searchDoctor(int id){
     Doctor temp = new Doctor  ();
        loadFromFile();
        int index = getDocIndex(id);
        if(index != -1){
        return   Doctors.get(index);
        }
        else {
            return temp; }
 }
  

    
 
   public boolean commitToFilee() {
        return Fmanger.write(doctorFileName ,Doctors);
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
        commitToFilee();
    } 
    
    public void deleteDoc(int id){
        loadFromFile();
        int index = getDocIndex(id);
        Doctors.remove(index);
        commitToFilee();
    } 
    
    @Override
    public String toString() {
        return "I'm doctor : " + firstName + " " + lastName + "\n" + "ID : " + Id + " Age : " + age + "\n"
                + "\nUserName: " + userName + "\t Password: " + password + "\nSalary: " + salary + "\tEmail: " + email;
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
    
    public void set_firstName(String firstName){
        this.setPFirstName(firstName);
    }
    
    public String get_firstName(){
        return this.getPFirstName();
    }
    
    public void set_lastName(String lastName){
        this.setPLastName(lastName);
    }
    
    public String get_lasttName(){
        return this.getPLastName();
    }
    
    public void set_email(String email){
        this.setPEmail(email);
    }
    
    public String get_email(){
        return this.getPEmail();
    }
    
    public void set_Id(int Id){
        this.setPId(Id);
    }
    
    public int get_Id(){
        return this.getPId();
    }
    
    public void set_age(int age){
        this.setPAge(age);
    }
    
    public int get_age(){
        return this.getPAge();
    }
    
    public void set_password(String password){
        this.setPassword(password);
    }
    
    public String get_password(){
        return this.getPassword();
    }
    
    public void set_userName(String userName){
        this.setUserName(userName);
    }
    
    public String get_userName(){
        return this.getUserName();
    }
    
    public void set_salary(double salary){
        this.setSalary(salary);
    }
    
    public double get_salary(){
        return this.getSalary();
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
