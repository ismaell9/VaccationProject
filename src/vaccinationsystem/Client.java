package vaccinationsystem;

/**
 *
 * @author Reputation
 */
public class Client extends Person{
    
    private int cPhoneNumber;
    private String cAdress;
    private String cGender;
    
/**
 * Constructor
 * @param 
 */
    public Client(){
        
    }
    
/**
 * method return type may be changed to "void"
 * @return true if found, false if not
 */    
    public boolean searchForAppointment(){
        return true;
    }

/**
 * @return true if reserved, false if not
 */
    public boolean reserveAppointment(){
        return true;
    }
    
/**
 * 
 */
    public void evaluateService(){
        
    }
    
/**
 * @return true if added, false if not
 */
    public boolean addClient(){
        return true;
    }
/**
 * @return true if deleted, false if not
 */
    public boolean deleteClient(){
        return true;
    }
/**
 * @return true if updated, false if not
 */
    public boolean updateClient(){
        return true;
    }

/**
 * method return type maybe changed
 * @return array of client objects from clients file
 */
    public Object[] listClient(){
        return null;
    }

    
}
