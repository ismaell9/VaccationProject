/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinationsystem;

/**
 *
 * 
 * nagham test test XD jjjjjj
 *
 */
public class StoreKeeper extends Staff{


/**
 * Create instance of Vaccine class for aggregation
 * It's completely changeable
 */
    private Vaccine vac;
    
    public void set_vac(Vaccine vac){
        this.vac = vac;
    }
//use "vac" object to use methods in "Vaccine" class

    
/**
 * Create instance of Store class for aggregation
 * It's completely changeable
 */
    private Store store;
    
    public void set_store(Store store){
        this.store = store;
    }
//use "store" object to use methods in "Store" class
 
    
/**
 * access modifier is changeable 
 * remember it's better to stay "private"
 * @return true if found, false if not
 */
    public boolean searchVac(){
        return true;
    }

}
