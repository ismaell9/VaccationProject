package vaccinationsystem;

/**
 *
 * @author Reputation
 */
public class Staff extends Person {
    
    private String sUserName;
    private String sPassword;
    private double sSalary;
    
/***
 * 
 * Person class setters && getters
 * Initializing Person attributes by setters and using it by getters
 * 
 ***/
    
    public void set_sUserName(){
        
    }
    public void set_sPassword(){
        
    }
    public void set_sSalary(){
        
    }
 
    public String get_sUserName(){
        return "";
    }
    public String get_sPassword(){
        return "";
    }
    public double get_sSalary(){
        return 0.0;
    }
 
/***
 * 
 * This method is used to login into the system
 * @param sUserName is first parameter
 * @param sPassword is second parameter
 * @return true if login, false if not
 * return type is changeable
 */
    public boolean login(String sUserName, String sPassword){
        return true;
    }
    
/***
 * 
 * This method is used to login into the system
 * @return true if logout, false if not
 * return type is changeable
 */
    public boolean logout(){
        return true;
    }
    
    
    
}
