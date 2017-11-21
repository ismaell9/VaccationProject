package vaccinationsystem;

import java.util.Date;

/**
 *
 * invoice file must be created within this class 
 */
class Invoice {
    private Date invoiceDate;
    private double invoiceCost;
    
/**
 * access modifier is changeable but it's better to stay "private"
 * @return sum
 */
    public int invoiceSum(){
        return 0;
    }
/**
 * add invoice to invoice file
 * return type is changeable
 * @return true if added, false if not
 */    
    public boolean addInvoice(){
        return true;
    }
/**
 * delete invoice from invoice file
 * return type is changeable
 * @return true if deleted, false if not
 */    
    public boolean deleteInvoice(){
        return true;
    }
/**
 * edit invoice in invoice file
 * return type is changeable
 * @return true if updated, false if not
 */    
    public boolean updateInvoice(){
        return true;
    }
/**
 * prints all invoices in invoice file
 * return type is changeable
 * @return object array of all invoices from invoices file
 */    
    public Object[] listInvoice(){
        return null;
    }

}
