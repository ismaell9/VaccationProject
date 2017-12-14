package vaccinationsystem;
//Nagham 
import java.util.*;

public class Store {

    private int storeId;
    private static int storeCapacity;
    private static int storeFreeSpace;

    private final String StoreFileName = "Store.txt";
    private final Vaccine vac = new Vaccine();
    FileManger FManger = new FileManger();
    public static ArrayList<Store> store = new ArrayList<>();
    
    public Store(int storeCapacity, int storeId, int storeFreeSpace) {
             
        Store.setstoreCapacity(storeCapacity);
        this.storeId = storeId;
        Store.setstoreFreeSpace(storeFreeSpace);
    }
    public Store(){
    }
    
    //setter
    public static void setstoreCapacity(int storeCapacity) {
        Store.storeCapacity = storeCapacity;
    }
    
    public static void setstoreFreeSpace(int storeFreeSpace) {
        Store.storeFreeSpace = storeFreeSpace;
    }
    
    public void setstoreId(int storeId) {
        this.storeId = storeId;
    }


    //getter
    public int getstoreId() {
        return this.storeId;
    }

    public int getstoreFreeSpace() {
        return Store.storeFreeSpace;
    }

    public int getsetstoreCapacity() {
        return Store.storeCapacity;
    }

    
    
    // msh fahm 3yza t3mli eh??
    private int getvacIndex(int vacId){
        //gets all vaccine IDs
        ArrayList<ArrayList>s = this.vac.vacData();
        Iterator<ArrayList> it = s.iterator();
        while(it.hasNext()){
            it.next().get(0);
        }
        return 0;
        /*
         for (int i = 0; i < Store.size(); i++) {
            if (vac.get(i).get_vacId() == vacId) {
                return i;
            }
        }
        */
    }
    
    
    private String getstoreData() {
        return this.storeId + "@" + Store.storeFreeSpace + "@" + Store.storeCapacity + "@" ;
    }
    
    private ArrayList<Store> loadFromFile() {
        
        store = (ArrayList<Store>) (Object) FManger.read(StoreFileName);
        return store;
    }
    
    public void commitToFile() {
        
        FManger.write(store.get(0).getstoreData(), StoreFileName, false);
        for (int i = 1; i < store.size(); i++) {
            FManger.write(store.get(i).getstoreData(), StoreFileName, true);
        }
    }
   
 
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
        ArrayList<Store> s = loadFromFile();
        //read storeFreeSpace from last index of arraylist written in file and compare it to zero
       if(this.getstoreFreeSpace() == 0)
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
        for (Store x : store) {
            S = S + x.toString();
        }
        return S;
    }
 
/*    public String showVaccineinstore(){
        loadFromFile();
        
        
        
    }

    
   
    */
    
    
    
}
