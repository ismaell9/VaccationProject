package vaccinationsystem;

import java.util.Arrays;

/**
 *
 * @author Reputation
 */
public  abstract class staff extends Person implements Ilogin{
    
    protected String sUserName;
    protected String sPassword;
    protected double sSalary;
    
    
public staff()
{
    
}   
    
    public staff(int pId,int pAge,String pFirstName,String pLastName,String pEmail,String sUserName,String sPassword,double sSalary){
        
      super(pId,pAge,pFirstName,pLastName,pEmail);
        
      /*
        this.sUserName=sUserName;
        this.sPassword=sPassword;
        this.sSalary=sSalary;
      
      */
        
        if (!sUserName.contains("@") || !sUserName.contains(".") ){
            this.sUserName = MyEX.checkEmail("UserName");
            } else {
            this.sUserName = sUserName;
        }
        
         if (sPassword.length() < 8) {
            this.sPassword = MyEX.checkPassLength("Password");
        } else {
            this.sPassword = sPassword;
        }
         
         if (sSalary < 0){
             this.sSalary = MyEX.checkPositive("Salary");
         } else {
             this.sSalary = sSalary ;
         }
        
}
        
        
        
/**
 * Person class setters and getters
 *Initializing Person attributes by setters and using it by getters
 * @param username
 */
    public void setUserName(String username){
        this.sUserName = username ;
    }
    public void setPassword(String pass){
        this.sPassword = pass ;
    }
    public void setSalary(double salary){
        this.sSalary = salary ;
    }
 
    public String getUserName(){
        return this.sUserName;
    }
    public String getPassword(){
        return this.sPassword;
    }
    public double getSalary(){
        return this.sSalary;
    }
        
    
    
    
    

    public boolean login(String userName , char[] password) {
        char[] c;
        try{
            c = this.getPassword().toCharArray();
        }catch(NullPointerException e){
            System.out.println(e);
            return false;
        }
        if ( userName.equals(this.getUserName()) && Arrays.equals(c, password)){
            return true ;
        }
        else {
            System.out.println("the em@il and the password is false ! please try again");
            return false ;
        }
        
    }   
}