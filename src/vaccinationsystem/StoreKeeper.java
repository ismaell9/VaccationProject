package vaccinationsystem;

import java.io.Serializable;
import java.util.ArrayList;


public class StoreKeeper extends staff implements Serializable{
    
 
    private final String storekeeperFileName = "StoreKeeper.bin";
    public static ArrayList<StoreKeeper> StoreKeepers= new ArrayList<>();
   
    
    public StoreKeeper(int pId,int pAge,String pFirstName,String pLastName ,String pEmail,String sUsername,String sPassword,double sSalary){
        super(pId,pAge,pFirstName,pLastName,pEmail,sUsername,sPassword,sSalary);
        

    }   

   public StoreKeeper() {        
    
   }
    
    public boolean addstorekeeper() {       
            loadFromFile();
            StoreKeepers.add(this);
            return commitToFilee();        
}
    
    public boolean commitToFilee() {
        return FManger.write(storekeeperFileName,StoreKeepers);
    }
    
    private void loadFromFile() {
           
        StoreKeepers = (ArrayList<StoreKeeper>) this.FManger.read("StoreKeeper.bin");
    }      
    
    private int getStoreKeeperIndex(int id){
        for (int i = 0; i < StoreKeepers.size(); i++)
            if(StoreKeepers.get(i).getPId()== id)
                return i;
        
        return -1;
    }
    
     public StoreKeeper searchStoreKeeperById(int id) {
        StoreKeeper temp = new StoreKeeper();
        loadFromFile();
        int index = getStoreKeeperIndex(id);
        if (index != -1) {
            return StoreKeepers.get(index);
        } else {
            return temp;
        }
    }
    
    public ArrayList<StoreKeeper> ListStoreKeepers() {
        loadFromFile();
        return StoreKeepers;
    }
    
    
       
  public boolean UpdateStoreKeeper() {
        loadFromFile();
        int index = getStoreKeeperIndex(this.pId);

        if (index != -1) {
            StoreKeepers.set(index, this);

            return commitToFilee();
        }

        return false;
    }

  
  
  
  
public boolean deleteStoreKeeper(int id) {
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
        return "I'm Store Keeper : " + pFirstName + " " + pLastName + "\n" + "ID : " + pId + " Age : " + pAge + "\n"
                + "\nUserName: " + sUserName + "\t Password: " + sPassword + "\nSalary: " + sSalary + "\tEmail: " + pEmail;
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
