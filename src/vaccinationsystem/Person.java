package vaccinationsystem;


public class Person {
    
    protected int pId ;
    protected int pAge ;
    protected String pFirstName ;
    protected String pLastName ;
    protected String pEmail ;

   
    
    FileManger FManger = new FileManger();
    
    public Person(){
        
    }
    
    public Person(int pId , int pAge , String pFirstName , String pLastName , String pEmail)
  {
      this.pId = pId ;
      this.pAge = pAge ;
      this.pFirstName = pFirstName ;
      this.pLastName = pLastName ;
      this.pEmail = pEmail ;
      
      }
    //OverRide ...
 //   @Override
    
   //public abstract String toString(); 
    
 //Setter
    public void setPId(int id){
        this.pId = id ;
    }    
    
    public boolean setPAge(int age){ // this function to check if age true or false
        if(pAge < 0){
          return false ;
       } else {
         this.pAge = pAge ;
           return true ;
      }
    }  
    public void setPFirstName(String fname){
        this.pFirstName = fname ;
    }
        
    public void setPLastName(String lname){
        this.pLastName = lname ;
    }  
    
    public boolean setPEmail(String email){ // this function to check if Ema@il true or false
        if(!pEmail.contains("@") || !pEmail.contains(".") ){
            return false ;
       } else {
         this.pEmail = pEmail ;
            return true ;
              }
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
