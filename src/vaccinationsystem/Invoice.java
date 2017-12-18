package vaccinationsystem;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
//import org.faceless.pdf2.*;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

public class Invoice implements Serializable {

    public static ArrayList<Invoice> Invoices = new ArrayList <>();
    private final String InvoiceFileName = "Invoices.bin";
    FileMangerBinary2 FManger =new FileMangerBinary2();
    protected final int service = 30;    
    //private String invoiceDAte;
    //protected int InvoiceNumber;
    double TotalCost = 0;
   // public Date currentdate ;

    Vaccine vac= new Vaccine ();
    Reservation rev = new Reservation  ();
    private Email generatEmail;
    //  Invoice inv = new Invoice();
    
   public Invoice (){
        
       
   }
   
   //   public void AddNewReservation (int RId , int cID, String Fname,String Lname, int Age, String Email, int PhoneNumber, String Address,String Gender, String date, Vaccine v){
    Reservation reserv;
    Client c;
     public Invoice (int RId , int cID, String Fname,String Lname, int Age, String Email, int PhoneNumber, String Address,String Gender, String date, Vaccine v){
         
         
         reserv.ReserId = RId;
        this.c = new Client (cID,Age,Fname,Lname,Email,PhoneNumber, Address, Gender);

        reserv.date = date;
        this.vac= v; 
     }
     /*
    public Invoice  (int invoiceNumber,String invoiceDate , double voiceCost, 
           int cID, String cGender ,String pEmail  ,String pLastName, 
           String pFirstName, int pAge, String cAdress , int cPhoneNumber ,
           String date, int service  , double price ){
           
        this.TotalCost = 0;
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
        this.InvoiceNumber = invoiceNumber;
       //this.currentdate = currentdate;
       
       
}*/
    
    /*
  public void setinvoiceNumber (int INumber) {
        this.InvoiceNumber = INumber;
    }
 public void setcurrentdate (Date currentdate) {
        this.currentdate = currentdate;
    }
 
    
 
  public int  getinvoiceNumber () {
        return this.InvoiceNumber;
    }
 public Date getcurrentDate(){
 
    return this.currentdate;
 }*/
        
    public double invoiceSum(double Totalcost, int service){
        
        TotalCost = service + vac.get_price() ; 
        return TotalCost ;
    }
/*
    void Generateinvoices(Date invoiceDate , double voiceCost, String cGender ,String pEmail  ,String pLastName
    , String pFirstName, int pAge, int cPhoneNumber ,String date , double Totalcost
   , int vacId, String vacTradeName , String vacAbbreviation, String vacType, double price
       ){
         ReadFromFile();
     commitToFile() ;
     
    }*/
   
      private void loadFromFile() {
           Invoices = (ArrayList<Invoice>) this.FManger.read(InvoiceFileName);
       }
      
      public boolean commitToFile() {
        return FManger.write (InvoiceFileName, Invoices);
    }   
        
public int getInvoiceIndex  (int id){ //InvoiceNumber
        for (int i = 0; i < Invoices.size(); i++)
            if(Invoices.get(i).reserv.ReserId== id)
                return i;
        
        return -1;
    }

public Invoice searchInvoiceById(int id) {
        Invoice temp = new Invoice();
        loadFromFile();
        int index = getInvoiceIndex(id);
        if (index != -1) {
            return Invoices.get(index);
        } else {
            return temp;
        }
    }
   public boolean UpdateInvoice() {
        loadFromFile();
        int index = getInvoiceIndex(reserv.ReserId);

        if (index != -1) {
            Invoices.set(index, this);

            return commitToFile();
        }

        return false;
    }

public boolean deleteInvoice(int id) {
        loadFromFile();
        int index = getInvoiceIndex(id);

        if (index != -1) {
           Invoices.remove(index);

            return commitToFile();
        }

        return false;
    }
  
    
   /*
 public String DisplayAllInvoices() {
     ReadFromFile();
        String AllInvoices = "\n All Appointments :\n";
        for (Invoice  k : Invoices) {
            AllInvoices = AllInvoices + k.toString();
        }
        return AllInvoices ;
    }
*/
 
   /* public void invoicePdf() throws IOException, MessagingException{ 
        PDF pdf = new PDF();

        PDFPage page = pdf.newPage("A4");

        PDFStyle mystyle = new PDFStyle();
        mystyle.setFont(new StandardFont(StandardFont.TIMES), 19);
        mystyle.setFillColor(Color.black);
        int start = page.getHeight()-50;
        page.setStyle(mystyle);
        /*Date invoiceDate , double voiceCost, String cGender ,String pEmail  ,String pLastName
        , String pFirstName, int pAge, String cAdress , int cPhoneNumber ,String date appointment date , double Totalcost
       , int vacId, String vacTradeName , String vacAbbreviation, String vacType, double price*/
    /*   String name    = "Name           :  ";
        name = name + cli.getPFirstName() + " " + cli.getPLastName();
                
        String Date    = "CheckOut Date  :  12.7.2017";
        String DateApp = "AppointmentDate:  12.8.2017";
    
        String Cost    = "Total cost     :  ";
        Cost = Cost + String.valueOf(TotalCost) + "$"; 
        
        String vacName = "Vaccine Name   :  ";
        vacName = vacName + vac.get_vac();
        String Price   = "Vac price      :  ";
        Price = Price + String.valueOf(vac.get_price())+"$";
        String Service = "Service price  :  100$";
        
        page.drawText(Date, 50, start);
        start-=50;
        page.drawText(name, 50, start);
        start-=50;
        page.drawText(vacName, 50, start);
        start-=50;
        
        page.drawText(Price, 50, start);
        start-=50;
        page.drawText(Service, 50, start);
        start-=50;
        page.drawText(Cost, 50, start);
        start-=50;
        page.drawText(DateApp, 50, start);


        File f = new File("Invoice.pdf");
        if(f.exists()){
           f.delete();
           f.createNewFile();
        }
        try (FileOutputStream out = new FileOutputStream(f)) {
            pdf.render(out);
           
            //"muhammad.a.esmael@gmail.com","ahussien753@gmail.com","Invoice details","Invoice chechout"
            this.generatEmail = new Email("muhammad.a.esmael@gmail.com","ahussien753@gmail.com","Invoice details","Invoice checkout","Invoice.pdf","C:\\Users\\Reputation\\Documents\\NetBeansProjects\\FinalProject\\FinalProject\\Invoice.pdf");
        }   this.generatEmail.generateAndSendEmail();
   }*/

}

        /* System.out.println( " Invoice Information" );
         System.out.printf( "Invoice Number number: \n", getinvoiceNumber() );
        System.out.printf( " Invoice Description : \n"+ "CLIENT NAME : "
        +cli.getPFirstName()+cli.getPLastName()+System.lineSeparator(),
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
        " APPOINTMENT DATE : "+rev.date+System.lineSeparator()
        );//,"INOICE NUMBER : "+ inv.InvoiceNumber+System.lineSeparator(),
        //"DATE : "+inv.currentdate+System.lineSeparator()
//);*/


     /*public  String calcCurrentdate ()throws InterruptedException{
     
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
     }*/
