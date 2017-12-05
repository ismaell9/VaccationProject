package vaccinationsystem;
//Nagham 
import java.util.*;

public class StoreKeeper extends staff{

    private final Vaccine vac = new Vaccine();
    private final String storekeeperFileName = "StoreKeeper.txt";
    FileManger FManger = new FileManger();
    public static ArrayList<StoreKeeper> StoreKeepers= new ArrayList<>();
        //use "store" object to use methods in "Store" class
    private final Store store = new Store();
  
    public StoreKeeper(int pId,int pAge,String pFirstName,String pLastName ,String pEmail,String sUsername,String sPassword,double sSalary){
        super(pId,pAge,pFirstName,pLastName,pEmail,sUsername,sPassword,sSalary);
    }   

    StoreKeeper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public String displayAllStoreKeeper() {
        loadFromFile();
        String S = "\nAll Professors Data:\n";
        for (StoreKeeper x : StoreKeepers) {
            S = S + x.toString();
        }
        return S;
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
    
    //use "vac" object to use methods in "Vaccine" class
   /* public void set_vac(Vaccine vac){
        this.vac = vac;
    
    }*/
 
    
    
/**
 * Create instance of Store class for aggregation
 * It's completely changeable
 */
    

    
    /*public void set_store(Store store){
        this.store = store;
    }*/
    //msh fahm brdo, w leh elfunction mtkrara bnfs elimplementation??
   private int getvacIndex(int vacId){
        
       //Implemented in Store [CLASS]\\
       
       /*for (int i = 0; i < vac.size(); i++)
             if(vac.get(i).get_vacId()== vacId)
                return i;
        return -1;*/
       return 0;
    }

/**
 * access modifier is changeable 
 * remember it's better to stay "private"
 * @return true if found, false if not
 */
   
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

}
