package vaccinationsystem;

import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import static vaccinationsystem.Reservation.reservation;

public class Invoice implements Serializable {
   
   
    public static ArrayList<Invoice> Invoices = new ArrayList <Invoice>();
    private final String InvoiceFileName = "Invoices.bin";
    FileMangerBinary2 FManger =new FileMangerBinary2();

    protected final int service = 100;    
    private String invoiceDAte;
    protected int InvoiceNumber;
    public Date currentdate ;
    private Client cli = new Client ();
    private Vaccine vac= new Vaccine ();
    Person per = new Person ();
    Appointment appoint = new Appointment ();
    Reservation rev = new Reservation  ();
    Invoice inv = new Invoice();

   public Invoice (){
    }
     
   public Invoice  (Date invoiceDate , double voiceCost, int cID, String cGender ,String pEmail  ,String pLastName
    , String pFirstName, int pAge, String cAdress , int cPhoneNumber ,String date, int service  , double price )
     {
    
         
         cli.set_cAdress(cAdress);
         cli.set_cGender(cGender);
         cli.set_cPhoneNumber(cPhoneNumber); 
         per.pAge = pAge;
         per.pEmail =pEmail;
         per.pFirstName = pFirstName;
         per.pLastName = pLastName;
         rev.date = date; //appointment date
         vac.get_price();
         vac.get_vacTradeName();
         vac.get_vacType();
         vac.get_vacId();
         vac.set_price(price);
         vac.get_vacAbbreviation();
         //enti kda msh bt3mli haga e3mli invoice de static w e3mlelha increment lma t3mli add new invoice
        this.InvoiceNumber= InvoiceNumber;
        this.currentdate = currentdate;
}
    
    
  public void setinvoiceNumber (int INumber) {
        this.InvoiceNumber = InvoiceNumber;
    }
 public void setcurrentdate (Date currentdate) {
        this.currentdate = currentdate;
    }
 
    
 
  public int  getinvoiceNumber () {
        return this.InvoiceNumber;
    }
 public String getcurredate () throws InterruptedException{
 
 return this.calcCurrentdate();
 
 }
     public  String calcCurrentdate ()throws InterruptedException{
     
        long start = System.currentTimeMillis();
        System.out.println(new Date() + "\n");
//ana msh fahm bgd :D
        Thread.sleep (5 * 60 * 10);
        System.out.println(new Date() + "\n");

        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Difference is : " + diff);
       System.out.println(currentdate.toString());
     
       return "";
     }
        
    public double  invoiceSum(double Totalcost, int service){
        
        double  TotalCost=0; 
        TotalCost = service + vac.get_price() ; 
      
        return TotalCost ;
    }

    void Generateinvoices(Date invoiceDate , double voiceCost, String cGender ,String pEmail  ,String pLastName
    , String pFirstName, int pAge, String cAdress , int cPhoneNumber ,String date/*appointment date*/ , double Totalcost
   , int vacId, String vacTradeName , String vacAbbreviation, String vacType, double price
       ){
         ReadFromFile();
         System.out.println( " Invoice Information" );
         System.out.printf( "Invoice Number number: \n", getinvoiceNumber() );
System.out.printf( " Invoice Description : \n"+ "CLIENT NAME : "+cli.getPFirstName()+cli.getPLastName()+System.lineSeparator(),
        "GENDER : "+cli.get_cGender()+System.lineSeparator(),
        "CLIENT AGE : "+cli.getPAge()+System.lineSeparator(),
 "CLIENT EMAIL : "+cli.getPEmail()+System.lineSeparator(),
 "CLIENT PHONE NUMBER : "+cli.get_cPhoneNumber()+System.lineSeparator(),
 "CLIENT AGE : "+cli.get_cAdress()+System.lineSeparator(),
 "VACCINE ID : "+vac.get_vacId()+System.lineSeparator(),
 "VACCINE TRADE NAME : "+vac.get_vacTradeName()+System.lineSeparator(),
 "VACCINE ABBREVIATION : "+vac.get_vacAbbreviation()+System.lineSeparator(),
 "VACCINE TYPE : "+vac.get_vacType()+System.lineSeparator(),
 "VACCINE PRICE : "+vac.get_price()+System.lineSeparator(),
 " APPOINTMENT DATE : "+rev.date+System.lineSeparator(),
"INOICE NUMBER : "+ inv.InvoiceNumber+System.lineSeparator(),
"DATE : "+inv.currentdate+System.lineSeparator()
);
     commitToFile() ;
     
    }
   
      private void ReadFromFile() {
           Invoices = (ArrayList<Invoice>) FManger.read(InvoiceFileName);
       }
      
      public boolean commitToFile() {
        return FManger.write (InvoiceFileName, Invoices);
    }   
        
public int getInvoiceIndex  (int InvoiceNumber){
for (int i = 0; i < Invoices.size(); i++)
            if(Invoices.get(i).getinvoiceNumber()==(InvoiceNumber))
                return i;
        return -1;
   
       }
  

    public boolean  deleteAppointment ( int appointmentNumber){
          ReadFromFile();
        int index = getInvoiceIndex ( appointmentNumber); 
    Invoices.remove(index);
    commitToFile();
        return true;
    }

   
 public String DisplayAllInvoices() {
     ReadFromFile();
        String AllInvoices = "\n All Appointments :\n";
        for (Invoice  k : Invoices) {
            AllInvoices = AllInvoices + k.toString();
        }
        return AllInvoices ;
    }

}

