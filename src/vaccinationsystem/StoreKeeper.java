package vaccinationsystem;
//Nagham 
import java.util.*;

public class StoreKeeper extends staff{

    private final Vaccine vac = new Vaccine(); //use "vac" object to use methods in "vaccine" class
    private final Store store = new Store();  //use "store" object to use methods in "Store" class
    FileManger FManger = new FileManger();
    private final String storekeeperFileName = "StoreKeeper.txt";
    public static ArrayList<StoreKeeper> StoreKeepers= new ArrayList<>();
   
    
    public StoreKeeper(int pId,int pAge,String pFirstName,String pLastName ,String pEmail,String sUsername,String sPassword,double sSalary){
        super(pId,pAge,pFirstName,pLastName,pEmail,sUsername,sPassword,sSalary);
    }   

   public StoreKeeper() {
    }
    
    public boolean addstorekeeper() {
        return this.FManger.write(this.getStoreKeeperData(), "StoreKeeper.txt" , true);
}
    private String getStoreKeeperData() {
        return this.pId + "@" + this.pFirstName + "@" + this.pLastName + "@" + this.pAge + "@" + this.pEmail + "@" + this.sUserName + "@" + this.sPassword+ "@" + this.sSalary + "@";
    }
         
    private void loadFromFile() {
           StoreKeepers = (ArrayList<StoreKeeper>) (Object) FManger.read("StoreKeeper.txt");
    }           
    
    public ArrayList<StoreKeeper> displayAllStoreKeeper() {
        loadFromFile();
        String S = "\nAll Professors Data:\n";
        for (StoreKeeper x : StoreKeepers) {
            S = S + x.toString();
        }
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
        return FManger.write(storekeeperFileName,StoreKeepers);
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
     
    public String searchStoreKeeper(int id){
        loadFromFile();
        int index = getStoreKeeperIndex(id);
        if(index != -1)
            return "\nFound ...!" + StoreKeepers.get(index).toString();
        else 
            return "\nNot Found ...!";
    }    
    
    private void commitToFile() {
        FManger.write(StoreKeepers.get(0).getStoreKeeperData(), storekeeperFileName, false);
        for (int i = 1; i <StoreKeepers.size(); i++) {
            FManger.write(StoreKeepers.get(i).getStoreKeeperData(), storekeeperFileName, true);
        }

    }
 
    public void updateStore(int oldID, StoreKeeper x){
        loadFromFile();
        int index = getStoreKeeperIndex(oldID);
        StoreKeepers.set(index, x);
        commitToFile();
    } 
    
    public void deleteStore(int id){
        loadFromFile();
        int index = getStoreKeeperIndex(id);
        StoreKeepers.remove(index);
        commitToFile();
    } 
    
    @Override
    public String toString() {
        return "I'm Store Keeper : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary;
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
}
