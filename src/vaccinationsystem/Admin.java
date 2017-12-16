package vaccinationsystem;



import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends staff implements Serializable{

    private static final long serialVersionUID = 4L;    
    private final String adminFileName = "admin.bin";
    FileMangerBinary2 Fmanger =new FileMangerBinary2();
    private final File file = new File(adminFileName);


public static ArrayList<Admin> Admins = new ArrayList<>();

   

    

public Admin (int pId,int pAge,String pFirstName,String pLastName ,String pEmail,String sUsername,String sPassword,double sSalary){
   super(pId,pAge,pFirstName,pLastName,pEmail,sUsername,sPassword,sSalary);
                   
        }


   public Admin(){
        
        }
       
  
   
    @Override
    public String toString() {
        return "I'm admin : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary;
    }
    @Override
    public boolean login(String userName, String Pass) {

        if (userName.equals("Shenoudafarouk") && Pass.equals("1234567899")) {
            return true;
        }
        return false;

    }
  
 
     
}
