package vaccinationsystem;

import java.io.File;
import StaffPersonGUI.LoginFrame;


public class VaccinationSystem {

    
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
	checkDirectoryContents(currentDir);
        
         new LoginFrame().setVisible(true);
 
    }
    
     public static void checkDirectoryContents(File dir){
        
        
         File[] files = dir.listFiles();
        boolean reservationOfficerFile = true ;
        boolean storeKeeperFile = true;
        boolean doctorFile = true;
        boolean clientFile = true;
        boolean reservationFile = true;

        
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
       
       
    }
    
}
