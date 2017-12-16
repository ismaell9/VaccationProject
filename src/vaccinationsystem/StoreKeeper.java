package vaccinationsystem;
//Nagham 
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StoreKeeper extends staff implements Serializable{
    
    private static final long serialVersionUID = 5L;
    private final Vaccine vac = new Vaccine(); //use "vac" object to use methods in "vaccine" class
    private final Store store = new Store();  //use "store" object to use methods in "Store" class
    FileMangerBinary2 Fmanger =new FileMangerBinary2();
    private final String storekeeperFileName = "StoreKeeper.bin";
    private final File file = new File(storekeeperFileName);
    public static ArrayList<StoreKeeper> StoreKeepers= new ArrayList<>();
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private double salary;
    private int Id;
    private String password;
    private int age;
    
    public StoreKeeper(int pId,int pAge,String pFirstName,String pLastName ,String pEmail,String sUsername,String sPassword,double sSalary){
        super(pId,pAge,pFirstName,pLastName,pEmail,sUsername,sPassword,sSalary);
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

   public StoreKeeper() {
        if(!this.file.exists()){
            try {
            this.file.createNewFile();
            } catch (IOException ex) {
             Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
   }
    
    public boolean addstorekeeper() {
        if(file.length()!= 0){
            loadFromFile();
            StoreKeepers.add(this);
            return commitToFilee();
        }
        return false;
}
    /*
    private String getStoreKeeperData() {
        return this.pId + "@" + this.pFirstName + "@" + this.pLastName + "@" + this.pAge + "@" + this.pEmail + "@" + this.sUserName + "@" + this.sPassword+ "@" + this.sSalary + "@";
    }
         */
    private void loadFromFile() {
           
        StoreKeepers = (ArrayList<StoreKeeper>) this.Fmanger.read("StoreKeeper.bin");
    }           
    
    public ArrayList<StoreKeeper> displayAllStoreKeeper() {
        loadFromFile();

        return StoreKeepers;
    }
    
    
        public StoreKeeper searchStoreById(int id) {
        StoreKeeper temp = new StoreKeeper();
        loadFromFile();
        int index = getStoreKeeperIndex(id);
        if (index != -1) {
            return StoreKeepers.get(index);
        } else {
            return temp;
        }
    }
  public boolean UpdateStore() {
        loadFromFile();
        int index = getStoreKeeperIndex(this.pId);

        if (index != -1) {
            StoreKeepers.set(index, this);

            return commitToFilee();
        }

        return false;
    }

  public boolean commitToFilee() {
        return Fmanger.write(storekeeperFileName,StoreKeepers);
    }
  
  
  
public boolean deleteStoree(int id) {
        loadFromFile();
        int index = getStoreKeeperIndex(id);

        if (index != -1) {
            StoreKeepers.remove(index);

            return commitToFilee();
        }
        
        return false;
}
    
   
    
         
    private int getStoreKeeperIndex(int id){
        for (int i = 0; i < StoreKeepers.size(); i++)
            if(StoreKeepers.get(i).getPId()== id)
                return i;
        
        return -1;
    }
     
  
    public StoreKeeper searchStoreKeeper(int id){
       StoreKeeper temp = new StoreKeeper();
        loadFromFile();
        int index = getStoreKeeperIndex(id);
        if(index != -1)
            return StoreKeepers.get(index);
        else 
            return temp;
    }    
    
 
 
    public boolean updateStore(int oldID, StoreKeeper x){
        loadFromFile();
        int index = getStoreKeeperIndex(this.pId);
        if(index!= -1){
            StoreKeepers.set(index, this);
        
                   return commitToFilee();

        }       
        return false;
        
    } 
    public boolean deleteStore(int id) {
        loadFromFile();
        int index = getStoreKeeperIndex(id);

        if (index != -1) {
            StoreKeepers.remove(index);

            return commitToFilee();
        }
        return false;
    }

    
  
    
    @Override
    public String toString() {
        return "I'm Store Keeper : " + firstName + " " + lastName + "\n" + "ID : " + Id + " Age : " + age + "\n"
                + "\nUserName: " + userName + "\t Password: " + password + "\nSalary: " + salary + "\tEmail: " + email;
    }


/*    

    //msh fahm brdo, w leh elfunction mtkrara bnfs elimplementation??
   private int getvacIndex(int vacId){
        
       //Implemented in Store [CLASS]\\
       
       /*for (int i = 0; i < vac.size(); i++)
             if(vac.get(i).get_vacId()== vacId)
                return i;
        return -1;
       return 0;
    }


   //msh fahm 3yza t3mli eh?? w ezai??\\
     public boolean searchVac(int vacId){
        loadFromFile();
       int index = getvacIndex(vacId);
        if(index != -1)
            //return "\nFound ...!" + Store.get(index).toString();
            return true;
        else 
            //return "\nNot Found ...!";
            return false;
    }
*/
    
    
    @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (StoreKeeper x : StoreKeepers) {
            if (userName.equals(x.sUserName) && Pass.equals(x.sPassword)) {
                return true;
            }
        }
        return false;
    }
}
