package vaccinationsystem;
/**
 *
 * @author Reputation
 */
public abstract class Person {
    
    protected int pId;
    protected int pAge;
    protected String pFirstName;
    protected String pLastName;
    protected String pEmail;

    
    public Person(int pId , int pAge , String pFirstName , String pLastName , String pEmail)
  {
        this.pId = pId ;
        this.pAge = pAge ; 
        this.pFirstName = pFirstName ;
        this.pLastName = pLastName ;
        this.pEmail = pEmail ;
  }
    //OverRide ...
    @Override
    public abstract String toString();
    
 //Setter
    public void setPId(int id){
        this.pId = id ;
    }    
    public void setPAge(int age){
        this.pAge = age ;
    }
        
    public void setPFirstName(String fname){
        this.pFirstName = fname ;
    }
        
    public void setPLastName(String lname){
        this.pLastName = lname ;
    }    
    public void setPEmail(String email){
        this.pEmail = email ;
    }    
    //Getter
    public int getPId(){
        
        return this.pId;
    }    
    public int getPAge(){
        
        return this.pAge;
    }
        
    public String getPFirstName(){
        return this.pFirstName;
    }
        
    public String getPLastName(){
        return this.pLastName;
    }    
    public String getPEmail(){
        return this.pEmail;
    }
    
 
    
}
