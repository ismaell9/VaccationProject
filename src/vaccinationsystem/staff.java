package vaccinationsystem;

/**
 *
 * @author Reputation
 */
public  class staff extends Person{
    
    protected String sUserName;
    protected String sPassword;
    protected double sSalary;
    
public staff()
{
}   
    
    public staff(int pId,int pAge,String pFirstName,String pLastName,String pEmail,String sUserName,String sPassword,double sSalary){
        
      super(pId,pAge,pFirstName,pLastName,pEmail);
        
        this.sSalary=sSalary;
        this.sPassword=sPassword;
        this.sUserName=sUserName;
    }
    public void setSalary(double sSalary) {
        this.sSalary = sSalary;
    }

    public double getSalary() {
        return this.sSalary;
    }
        
        
        public void setsUsername(String sUsername) {
        this.sUserName = sUserName;
    }

    public String getsUsername() {
        return this.sUserName;
    }
        
        public void setPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getPassword() {
        return this.sPassword;
    }
        
        
    
    
    
    

    public boolean login(String userName , String Pass) {
       if ( userName.equals("Admin@yahoo.com") && Pass.equals("12345678")){
           return true ;
       }
       else {
           System.out.println("the em@il and the password is false ! please try again");
           return false ;
       }
        
    }
/***
 * 
 * Person class setters && getters
 * Initializing Person attributes by setters and using it by getters
 * 
 ***/
    
    /**
     * Person class setters &;&; getters
 Initializing Person attributes by setters and using it by getters
     * @param username
     */
    public void set_sUserName(String username){
        this.sUserName = username ;
    }
    public void set_sPassword(String pass){
        this.sPassword = pass ;
    }
    public void set_sSalary(double salary){
        this.sSalary = salary ;
    }
 
    public String get_sUserName(){
        return this.sUserName;
    }
    public String get_sPassword(){
        return this.sPassword;
    }
    public double get_sSalary(){
        return this.sSalary;
    }
/***
 * 
 * This method is used to login into the system
 * @param sUserName is first parameter
 * @param sPassword is second parameter
 * @return true if login, false if not
 * return type is changeable
 */
 }