package vaccinationsystem;

import java.io.File;
import StaffPersonGUI.LoginFrame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class VaccinationSystem {

    
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
	checkDirectoryContents(currentDir);
        
        
              
    }
    
     public static void checkDirectoryContents(File dir){
        
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            LoginFrame f = new LoginFrame();
            //JFrame frame = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //frame.getContentPane().
            f.pack();
            f.setVisible(true);
        }
    });
       
      /*   File[] files = dir.listFiles();
        boolean reservationFile = true ;
        boolean storeFile = true;
        boolean adminFile = true;
        
        for (File file : files) {
            
  
            if (file.getName().contains("Reservation.bin")) {
                 reservationFile = false;
            }            

            /*
            if (file.getName().contains("Store.txt")) {
                storeFile = false;
            } else if (file.getName().contains("admin.txt")) {
                adminFile = false;
            } */
        /*}
        
        if (reservationFile) {
            Reservation x = new Reservation();
            x.commitToFile();
        }
        /*
        if (storeFile) {
            Store x = new Store();
            x.commitToFile();
        } 
        
        if (adminFile) {
            Admin  x = new Admin();
            x.commitToFile();
        } */
       
    }
    
}
