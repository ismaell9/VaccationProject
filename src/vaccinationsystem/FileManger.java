package vaccinationsystem;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * 
 */
public class FileManger {
    
   
    public boolean write(String Query, String FilePath,boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter((new FileWriter(new File((String) FilePath),appendType)));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException ex) {
        } finally {
            writter.close();
        }
        return false;
    }
    
    public ArrayList<Object> read(String FilePath) {
        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);
            File Path = new File(FilePath);

            Reader = new Scanner(Path);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("Admin.txt")) {

            ArrayList<Admin> Admins = new ArrayList<Admin>();
            

            while (Reader.hasNext()) {

               Admin a;
                a = new Admin();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 20140011@Ahmed@Ali@20@2@3.5@CS@STU_1@12345678@
                a.pId=(Integer.parseInt(seprated[0]));
               a.pAge=(Integer.parseInt(seprated[1]));
               
                a.pFirstName=(seprated[2]);
                a.pLastName=(seprated[3]);
                a.pEmail=((seprated[4]));
                a.sSalary=(Double.parseDouble(seprated[5]));
                a.sUserName=(seprated[6]);
                a.sPassword=(seprated[7]);

                Admins.add(a);
         
            }
         return (ArrayList<Object>) (Object) Admins;

        }
         else if (FilePath.equals("doctor.txt")) {

            ArrayList<Doctor> Doctors = new ArrayList<Doctor>();
            Doctor x;

            while (Reader.hasNext()) {

                x = new Doctor();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 1@Ayman@Ezzat@30@8000.0@Mon 12pm to 2pm@CS@Prof_1@12345678@
                x.setPId(Integer.parseInt(seprated[0]));
                x.pFirstName=(seprated[1]);
                x.pLastName=(seprated[2]);
                x.setPAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));
                x.setPassword(seprated[5]);          
                x.sUserName=(seprated[7]);
               x.pEmail=(seprated[6]);
                Doctors.add(x);
            }

            return (ArrayList<Object>) (Object) Doctors;
    
         }

    else if (FilePath.equals("StoreKeeper.txt")) {

            ArrayList<StoreKeeper> StoreKeepers = new ArrayList<StoreKeeper>();
            StoreKeeper x;

            while (Reader.hasNext()) {

                x = new StoreKeeper();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 1@Ayman@Ezzat@30@8000.0@Mon 12pm to 2pm@CS@Prof_1@12345678@
                x.setPId(Integer.parseInt(seprated[0]));
                x.pFirstName=(seprated[1]);
                x.pLastName=(seprated[2]);
                x.setPAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));
                x.setPassword(seprated[5]);          
                x.sUserName=(seprated[7]);
               x.pEmail=(seprated[6]);
                StoreKeepers.add(x);
            }

            return (ArrayList<Object>) (Object) StoreKeepers;
   
    }
     else if (FilePath.equals("ReservOfficer.txt")) {

            ArrayList<ReservOfficer> ReservOfficers = new ArrayList<ReservOfficer>();
            ReservOfficer x;

            while (Reader.hasNext()) {

                x = new ReservOfficer();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 1@Ayman@Ezzat@30@8000.0@Mon 12pm to 2pm@CS@Prof_1@12345678@
                x.setPId(Integer.parseInt(seprated[0]));
                x.pFirstName=(seprated[1]);
                x.pLastName=(seprated[2]);
                x.setPAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));
                x.setPassword(seprated[5]);          
                x.sUserName=(seprated[7]);
               x.pEmail=(seprated[6]);
               ReservOfficers.add(x);
            }

            return (ArrayList<Object>) (Object) ReservOfficers;
    
    
   
     }
    
     else{
         return null;
     }
    }

    boolean write(String doctorFileName, ArrayList<Doctor> Doctors) {
        return true;
        
    }

    boolean write(String storekeeperFileName, ArrayList<StoreKeeper> StoreKeepers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean write(String ReservOfficerFileName, ArrayList<ReservOfficer> reservOfficers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
