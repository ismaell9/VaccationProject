package vaccinationsystem;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * invoice file must be created within this class 
 */
class Invoice {
    private Date invoiceDate;
    private double invoiceCost;
    protected int INumber;
   
public static ArrayList<Invoice> Invoices = new ArrayList <Invoice>();
  
   public Invoice (){
    }
     public Invoice  (Date invoiceDate , double voiceCost ) {
        this.invoiceDate = invoiceDate;
        this.invoiceCost= invoiceCost ;
 this.INumber= INumber;
    }
      public void setinvoicedate (Date invoiceDate) {
        this.invoiceDate = invoiceDate;
      }
      
      
    public void setinvoiceCost (double invoceCost) {
        this.invoiceCost = invoiceCost;
    }
  public void setinvoiceNumber (int INumber) {
        this.INumber = INumber;
    }

    public Date getinvoicedate (Date invoiceDate) {
        return this.invoiceDate;
    }
 public double   getinvoiceCost () {
        return this.invoiceCost;
    }
  public int  getinvoiceNumber () {
        return this.INumber;
    }
 
     
     
           
/**
 * access modifier is changeable but it's better to stay "private"
 * @return sum
 */
    public double  invoiceSum(){
        
        double  TotalCost=0; 
        TotalCost = TotalCost + this.invoiceCost; 
      
        return TotalCost ;
    }
}
/*
 * add invoice to invoice file
 * return type is changeable
 * @return true if added, false if not
 */ 