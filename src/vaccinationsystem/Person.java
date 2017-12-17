package vaccinationsystem;

//import java.io.Serializable;

import java.io.Serializable;



public class Person implements Serializable{
    //private static final long serialVersionUID = 0L;

    protected int pId ;
    protected int pAge ;
    protected String pFirstName ;
    protected String pLastName ;
    protected String pEmail ;

       
    FileMangerBinary2 FManger = new FileMangerBinary2();
    
    static MyException MyEX = new MyException("Vaccination Exception");

    
    public Person(){
        
    }
    
    public Person(int pId , int pAge , String pFirstName , String pLastName , String pEmail)
  {
      
    
      if (pId < 0) {
            this.pId = MyEX.checkPositive("ID");
        } else {
            this.pId = pId;
        }
      
      if (pAge < 0) {
            this.pAge = MyEX.checkPositive("Age");
        } else {
            this.pAge = pAge;
        }
      
        this.pFirstName = pFirstName;
        this.pLastName = pLastName;
        
        if (!pEmail.contains("@") && !pEmail.contains(".")) {
                this.pEmail = MyEX.checkEmail("Email");
        } else {
            this.pEmail= pEmail;
        }
      
      }
   
    
 //Setter
    public void setPId(int id){
        this.pId = id ;
    }    
    
    public void setPAge(int age){ // this function to check if age true or false
               this.pAge = pAge ;
            }
      
    public void setPFirstName(String fname){
        this.pFirstName = fname ;
    }
        
    public void setPLastName(String lname){
        this.pLastName = lname ;
    }  
    
    public void setPEmail(String email){ // this function to check if Ema@il true or false
        
        this.pEmail = pEmail ;
           
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
