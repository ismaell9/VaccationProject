/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinationsystem;

/**
 *
 * @author Reputation
 */
public class Store {

/**
 * it's a good practice to stay "private"
 * however it's changeable
 */    
    private int storeCapacity;
    private int storeId;
    private int storeFreeSpace;

/**
 * setters && getters
 */

/**
 * search for vaccine by id
 * @param vacId
 * @return true if found, false if not
 */
    public boolean searchVac(int vacId){
        return true;
    }
/**
 * @return true if store is full, false if not
 */
    public boolean storeIsFull(){
        return true;
    }
    
/**
 * @return string of all information about the store
 */    
    public String storeReport(){
        return "";
    }
}
