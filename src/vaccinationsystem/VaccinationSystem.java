package vaccinationsystem;

import java.io.File;
import StaffPersonGUI.LoginFrame;


public class VaccinationSystem {


    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
	checkDirectoryContents(currentDir);
          
        Vaccine sa = new Vaccine();
         String y = "flue";
        sa.set_vac(y);
         new LoginFrame().setVisible(true);
         ReservOfficer x = new ReservOfficer();
               //20150280@Shenouda Farouk@20@Shenouda@yahoo.com@01126524979@Ramsis@Male@Sun Dec 03 01:52:55 EET 2017@swine flu){
//   public void AddNewReservation (int RId , int cID, String Fname,String Lname, int Age, String Email, int PhoneNumber, String Address,String Gender, String date, Vaccine v){

        // x.AddNewReservation( 1 , 1, "Shenouda", "Farouk", 20 ,"Shenouda@yahoo.com" ,01126, "ramsis" , "male" , "mon"  , sa );
 
    }
    
     public static void checkDirectoryContents(File dir){
        
        
         File[] files = dir.listFiles();
        boolean reservationOfficerFile = true ;
        boolean storeKeeperFile = true;
        boolean doctorFile = true;
        boolean clientFile = true;
        boolean reservationFile = true;
        boolean emailFile =true;

        
        for (File file : files) {
            
            if (file.getName().contains("ReservOfficer.bin")) {
                 reservationOfficerFile = false;
            }  else if (file.getName().contains("StoreKeeper.bin")) {
                storeKeeperFile = false;
            } else if (file.getName().contains("doctor.bin")) {
                doctorFile = false;
            }  else if (file.getName().contains("Client.bin")) {
                clientFile = false;
            } else if (file.getName().contains("Reservation.bin")) {
                reservationFile = false;
            }      
            else if (file.getName().contains(" Email.bin")) {
                emailFile = false;
            }         
        }
           
                
        if (reservationOfficerFile) {
            ReservOfficer x = new ReservOfficer();
            x.commitToFilee();
        }
        
        if (storeKeeperFile) {
            StoreKeeper x = new StoreKeeper();
            x.commitToFilee();
        } 
        
        if (doctorFile) {
            Doctor  x = new Doctor();
            x.commitToFilee();
        } 
        
        if (clientFile) {
            Client  x = new Client();
            x.commitToFile();
        } 
        
        if (reservationFile) {
            Reservation  x = new Reservation();
            x.commitToFile();
        } 
       if (emailFile) {
            Email  x = new Email();
            x.commitToFile();
        } 
       
    }
    
}
