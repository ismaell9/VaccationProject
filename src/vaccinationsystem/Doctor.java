package vaccinationsystem;

import java.util.Date;

/**
 *
 * other functionality might be added to this class
 */
public class Doctor extends Staff{
    
    private Date appointmentDate;
    private boolean isAvilable;
    
/**
 *
 * access modifier is changeable "it's better when private"
 * @return returns the client state after Doctor examination
 * return type is changeable
 */
   
    public String examineClient(){
        return "";
    }
    
/**
 *
 * access modifier is changeable "it's better when private"
 * @return returns vaccine name that the client should take
 * return type is changeable
 */
   
    public String assignVac(){
        return "";
    }
    
    
  
}
