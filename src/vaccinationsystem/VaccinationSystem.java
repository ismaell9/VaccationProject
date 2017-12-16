package vaccinationsystem;

import java.io.File;
import StaffPersonGUI.LoginFrame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class VaccinationSystem {

    
    public static void main(String[] args) {
        /*String projectPath = System.getProperty("user.dir");
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
       
        //ReservOfficer r =new ReservOfficer(1, 20, null, null, null, null, null, 20);
        //r.addReservOfficer();
       
        ReservOfficer d = new ReservOfficer(1, 20, "Muhammad","Ahmed", "muhammad.a.esmael@gmail.com", "Reputation", "535348843", 52);
        d.addReservOfficer();
        //Doctor d2 = new Doctor();
        /*d2.setPAge(20);
        d2.setPFirstName("Muhammad");
       
        d2.setPLastName("ahH");
        d2.setSalary(100.5);
        System.out.println(d2.getSalary());
        System.out.println(d2.getPFirstName());
        d2.adddoctor(d2);
        */
        for( ReservOfficer s : (d.displayAllReservOfficers())){
            System.out.println(s.toString());
            
        }
        
       
    }
    
}
