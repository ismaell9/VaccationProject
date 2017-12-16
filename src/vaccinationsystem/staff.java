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
        
       
          this.sUserName = sUserName;
       
        
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
      @Override
    public boolean equals(Object o) {
        staff u = (staff) o;
        return pId == u.pId && pFirstName.equals(u.pFirstName) && pLastName.equals(u.pLastName) && pAge == u.pAge && pEmail.equals(u.pEmail) && sSalary == u.sSalary ;
    }
        
} 
    
    
  