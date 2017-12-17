package vaccinationsystem;
//Nagham

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Store implements Serializable {

    private int storeId;
    private static int storeCapacity;
    private static int storeFreeSpace;
    public final Vaccine vac = new Vaccine();

    private final String StoreFileName = "Store.txt";
    private final File file = new File(StoreFileName);
    
    FileMangerBinary2 Fmanger = new FileMangerBinary2();
    private final String storekeeperFileName = "StoreKeeper.bin";

    public static ArrayList<Store> stores = new ArrayList<>();

    
    public Store(int storeCapacity, int storeId, int storeFreeSpace) {

        Store.setstoreCapacity(storeCapacity);
        this.storeId = storeId;
        Store.setstoreFreeSpace(storeFreeSpace);
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Store() {
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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

    
    
    private String getstoreData() {
        return this.storeId + "@" + Store.storeFreeSpace + "@" + Store.storeCapacity + "@";
    }

    private ArrayList<Store> loadFromFile() {

        stores = (ArrayList<Store>) (Object) Fmanger.read(StoreFileName);
        return stores;
    }

    public boolean commitToFile() {
        return Fmanger.write(StoreFileName, stores);
    }

    private int getvacIndex(int vacId) {
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).vac.get_vacId() == vacId) {
                return i;
            }
        }

        return -1;
    }
    
    
    public Store searchVacById(int vacId) {
        Store temp = new Store();
        loadFromFile();
        int index = getvacIndex(vacId);
        if (index != -1) {
            return stores.get(index);
        } else {
            return temp;
        }
    }

    public boolean storeIsFull() {
        ArrayList<Store> s = loadFromFile();
        //read storeFreeSpace from last index of arraylist written in file and compare it to zero
        if (this.getstoreFreeSpace() == 0) {
            //System.out.println("Store Is FULL");
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return string of all information about the store
     */
/*    public String storeReport() {
        loadFromFile();
        String S = "\nAll Store Data:\n";
        for (Store x : stores) {
            S = S + x.toString();
        }
        return S;
    }*/

    public ArrayList<Store> listStore() {
        loadFromFile();
        return stores;
    }

}