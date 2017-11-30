package vaccinationsystem;

/**
 *     

 * @author Reputation
 */
public class Client extends Person{
    
    private int cPhoneNumber;
    private String cAdress;
    private String cGender;

    public Client(int pId, int pAge, String pFirstName, String pLastName, String pEmail,int cPhoneNumber, String cAdress, String cGender) {
        super(pId, pAge, pFirstName, pLastName, pEmail);
        this.cPhoneNumber = cPhoneNumber;
        this.cAdress = cAdress;
        this.cGender = cGender;
    }
/**
 * Setters && Getters
 * @param cPhoneNumber 
 */
    public void set_cPhoneNumber(int cPhoneNumber){
        this.cPhoneNumber = cPhoneNumber;
    }
    public void set_cAdress(String cAdress){
        this.cAdress = cAdress;
    }

    public void set_cGender(String cGender){
        this.cGender = cGender;
    }

    public int get_cPhoneNumber(){
        return this.cPhoneNumber;
    }
    public String get_cAdress(){
        return this.cAdress;
    }
    public String get_cGender(){
        return this.cGender;
    }
/**
 * -----------------------------------------------------------------------------------------------------------------------------------------------------
 */
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

    @Override
    public String toString() {
        return null;
    }

    
}
