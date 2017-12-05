package vaccinationsystem;
//Nagham 
import java.util.*;

public abstract class Store {

    private int storeId;
    private int storeCapacity;
    private int storeFreeSpace;

    private final String StoreFileName = "Store.txt";
    FileManger FManger = new FileManger();
    public static ArrayList<Store> Store = new ArrayList<Store>();
    
    public Store(int storeCapacity, int storeId, int storeFreeSpace) {
             
        this.storeCapacity = storeCapacity;
        this.storeId = storeId;
        this.storeFreeSpace = storeFreeSpace;
    }
    //setter
    public void setstoreCapacity(int storeCapacity) {
        this.storeCapacity = storeCapacity;
    }

    public void setstoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setstoreFreeSpace(int storeFreeSpace) {
        this.storeFreeSpace = storeFreeSpace;
    }
    //getter
    public int getstoreId() {
        return this.storeId;
    }

    public int getstoreFreeSpace() {
        return this.storeFreeSpace;
    }

    public int getsetstoreCapacity() {
        return this.storeCapacity;
    }

    
    private int getvacIndex(int vacId){
        for (int i = 0; i < Store.size(); i++)
            if(Store.get(i).get_vacId() == vacId)
                return i;
        return -1;
    }
    
    
    private String getstoreData() {
        return this.storeId + "@" + this.storeFreeSpace + "@" + this.storeCapacity + "@" ;
    }
    
    private void loadFromFile() {
        
        Store = (ArrayList<Store>) (Object) FManger.read(StoreFileName);
    }
    
    private void commitToFile() {
        
        FManger.write(Store.get(0).getstoreData(), StoreFileName, false);
        for (int i = 1; i < Store.size(); i++) {
        FManger.write(Store.get(i).getstoreData(), StoreFileName, true);
        }
    }
   /* 
 */
 
/**
 * search for vaccine by id
 * @param vacId
 * @return true if found, false if not
 */
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
    
/**
 * @return true if store is full, false if not
 */
    public boolean storeIsFull(){
       loadFromFile();
       if(storeFreeSpace>=storeCapacity)
       {
           //System.out.println("Store Is FULL");
            return true;
            
       }else{
              return false;
       }
    }        
/**
 * @return string of all information about the store
 */    
    public String storeReport(){
        loadFromFile();
        String S = "\nAll Store Data:\n";
        for (Store x : Store) {
            S = S + x.toString();
        }
        return S;
    }
}
