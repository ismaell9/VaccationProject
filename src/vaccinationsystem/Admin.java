package vaccinationsystem;



import java.util.ArrayList;

public class Admin extends staff{

private final String adminFileName = "admin.txt";
  FileManger FManger = new FileManger();
    public static ArrayList<Admin> Admins = new ArrayList<Admin>();

   

    

public Admin (int pId,int pAge,String pFirstName,String pLastName ,String pEmail,String sUsername,String sPassword,double sSalary){
   super(pId,pAge,pFirstName,pLastName,pEmail,sUsername,sPassword,sSalary);
}

   public Admin() {
    }


   
  
public boolean addadmin() {
        if (this.FManger.write(this.getadminData(), adminFileName, true)) {
            return true;
        } else {
            return false;
        }
}
         private String getadminData() {
        return this.pId + "@" + this.pFirstName + "@" + this.pLastName + "@" + this.pAge + "@" + this.pEmail + "@" + this.sUserName + "@" + this.sPassword+ "@" + this.sSalary + "@";
    }
    
        
public void addNewAdmin(int pId,int pAge,String pFirstName,String LastName ,String pEmail,String sUsername,String sPassword,double sSalary)
{
        Admin x = new Admin(pId, pAge,pFirstName ,pFirstName, pEmail,sUsername,sPassword,sSalary);
        if( x.addadmin())
            System.out.println(x.toString() + "Added Successfully ... !"); 
        else
            System.out.println("Failed to insert ... !");
    }
        
 @Override
    public String toString() {
        return "I'm admin : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary;
    }
  public void displayadmins() {
        Admin a = new Admin();
        System.out.println(a.displayAllAdmins());
    }

  
   private void loadFromFile() {
            Admins= (ArrayList<Admin>) (Object) FManger.read("admin.txt");
    }
  public String displayAllAdmins() {
        loadFromFile();
        String A = "\nAll Admin Data:\n";
        for (Admin x : Admins) {
            A = A + x.toString();
        }
    return A;
  }
        
        
  private int getAdminIndex(int id){
        for (int i = 0; i < Admins.size(); i++)
            if(Admins.get(i).getPId()== id)
                return i;
        
        return -1;
    }
    
        
     public String searchAdmin(int id){
        loadFromFile();
        int index = getAdminIndex(id);
        if(index != -1)
            return "\nFound ...!" + Admins.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
  
    public void searchForAdmin(int id) {
        Admin x = new Admin();
        System.out.println(x.searchAdmin(id));
    }

     public void commitToFile() {
        FManger.write(Admins.get(0).getadminData(), "Admin.txt", false);
        for (int i = 1; i < Admins.size(); i++) {
            FManger.write(Admins.get(i).getadminData(), "Admin.txt", true);
        }

    }
  
    public void updateAdmin(int oldID, Admin x){
        loadFromFile();
        int index = getAdminIndex(oldID);
        Admins.set(index, x);
        commitToFile();
    } 
    
     public void updateAdmins(int oldID, Admin newAdminValues) {
        Admin x = new Admin();
        x.updateAdmin(oldID, newAdminValues);
        System.out.println("Updated Successfully ... !");
    }
    
      public void deleteAdmin(int id){
        loadFromFile();
        int index = getAdminIndex(id);
        Admins.remove(index);
        commitToFile();
    } 
      
    public void deleteAdmins(int Id) {
        Admin x = new Admin();
        x.deleteAdmin(Id);
        System.out.println("deleted Successfully ... !");
    }
    
 public void addNewDoctor(int pId,int pAge,String pFirstName,String LastName ,String pEmail,String sUsername,String sPassword,double sSalary){
        Doctor x = new Doctor(pId, pAge,pFirstName ,pFirstName, pEmail,sUsername,sPassword,sSalary);
        if( x.adddoctor() )
            System.out.println(x.toString() + "Added Successfully ... !"); 
        else
            System.out.println("Failed to insert ... !");
    }

 
   public void displayDoctors() {
        Doctor x = new Doctor();
        System.out.println(x.displayAllDoctors());
    }
 
    public void searchForDoctor(int id) {
        Doctor x = new Doctor();
        System.out.println(x.searchDoctor(id));
    }

 
      public void updateDoctor(int oldID, Doctor newDocValues) {
        Doctor x = new Doctor();
        x.updateDoc(oldID, newDocValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteDoctor(int Id) {
        Doctor x = new Doctor();
        x.deleteDoc(Id);
        System.out.println("deleted Successfully ... !");
    }
  
 public void addNewStoreKeeper(int pId,int pAge,String pFirstName,String LastName ,String pEmail,String sUsername,String sPassword,double sSalary){
        StoreKeeper x = new StoreKeeper(pId, pAge,pFirstName ,pLastName, pEmail,sUsername,sPassword,sSalary);
        if( x.addstorekeeper() )
            System.out.println(x.toString() + "Added Successfully ... !");
        else 
            System.out.println("Failed to insert ... !");
    }
public void displaySroeKeeper() {
        StoreKeeper x = new StoreKeeper();
        System.out.println(x.displayAllStoreKeeper());
    }
 
    public void searchForStoreKeeper(int id) {
        StoreKeeper x = new StoreKeeper();
        System.out.println(x.searchStoreKeeper(id));
    }

 
      public void updateStoreKeeper(int oldID, StoreKeeper newstkValues) {
        StoreKeeper x = new StoreKeeper();
        x.updateStore(oldID, newstkValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteStore(int Id) {
        StoreKeeper x = new StoreKeeper();
        x.deleteStore(Id);
        System.out.println("deleted Successfully ... !");
    }
 
 public void addNewReservOfficer(int pId,int pAge,String pFirstName,String LastName ,String pEmail,String sUsername,String sPassword,double sSalary){
        ReservOfficer x = new ReservOfficer(pId, pAge,pFirstName ,pLastName, pEmail,sUsername,sPassword,sSalary);
        if( x.addReservOfficer() )
            System.out.println(x.toString() + "Added Successfully ... !");
        else 
            System.out.println("Failed to insert ... !");
    }
   
   public void displayReservOfficer() {
        ReservOfficer x = new ReservOfficer();
        System.out.println(x.displayAllReservOfficers());
    }
 
    public void searchForReservOfficer(int id) {
        ReservOfficer x = new ReservOfficer();
        System.out.println(x.searchReservOfficer(id));
    }

 
      public void updateReservOfficer(int oldID, ReservOfficer newResValues) {
        ReservOfficer x = new ReservOfficer();
        x.updateRes(oldID, newResValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteReservOfficer(int Id) {
        ReservOfficer x = new ReservOfficer();
        x.deleteRes(Id);
        System.out.println("deleted Successfully ... !");
    }
  
 
 
 
      
}
