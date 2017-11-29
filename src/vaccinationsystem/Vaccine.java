package vaccinationsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


/**
 *
 * 
 */
public class Vaccine implements Serializable{
/**
 * access modifiers are better to stay private 
 * but they are changeable if needed
 */
    private static int vacId = 0;
    private int vacExpirationYear;
    private String vac;
    private String vacTradeName;
    private String vacAbbreviation;
    private String vacType;
    private String vacComment;
    final private FileMangerBinary file = new FileMangerBinary();
    final static String FILE_NAME = "E:\\VaccinationSystem\\Vaccine.bin";
    ArrayList<Vaccine> vacs;
    
    Vaccine(String vac, String vacTradeName, String vacAbbreviation, String vacType, String vacComment,int vacExpirationYear){
        this.vacs = new ArrayList<Vaccine>();
        this.vac = vac;
        this.vacTradeName = vacTradeName;
        this.vacAbbreviation = vacAbbreviation;
        this.vacType = vacType;
        this.vacExpirationYear = vacExpirationYear;
        this.vacComment = vacComment;
        this.vacs = new ArrayList<Vaccine>();
    }
    Vaccine(){
        this.vacs = new ArrayList();
        
    }
// setters and getters
   
    public void set_vac(String vac){
        this.vac = vac;
    }
    public void set_vacTradeName(String vacName){
        this.vacTradeName = vacName;
    }
    public void set_vacAbbreviation(String vacAbbreviation){
        this.vacAbbreviation = vacAbbreviation;
    }

    public void set_vacType(String vacType){
        this.vacType = vacType;
    }
        
    public void set_vacExpirationYear(int vacExpirationYear){
        this.vacExpirationYear = vacExpirationYear;
    }
    
    public void set_comments(String vacComment){
        this.vacComment = vacComment;
    }
    public int get_vacId(){
        return Vaccine.vacId;
    }
    public String get_vac(){
        return this.vac;
    }
    public String get_vacTradeName(){
        return this.vacTradeName;
    }
    public String get_vacAbbreviation(){
        return this.vacAbbreviation;
    }
    public String get_vacType(){
        return this.vacType;
    }
    public int get_vacExpirationYear(){
        return this.vacExpirationYear;
    }
    public String get_vacComment(){
        return this.vacComment;
    }
    
// end setters and getters        
    

/**
 * access modifier is changeable "it's better when private"
 * @param vac
 * @return true if added, false if not
*/
    public boolean addVac(Vaccine vac){
        Vaccine.vacId++;
        //Write inside vaccine file
        this.vacs = ArrayList.class.cast(this.file.read(Vaccine.FILE_NAME));
        vacs.add(vac);
        boolean write = this.file.write(Vaccine.FILE_NAME, vacs);
        //Object o = this.file.read(Vaccine.FILE_NAME);
        //System.out.println(o);
        //if(write)System.out.println("Done writing in file."); else System.out.println("File error.");
        //System.out.println(Vaccine.vacId + "\t" + this.vac + "\t" + this.vacTradeName + "\t" +  
        //        this.vacAbbreviation + "\t" + this.vacType + "\t" + this.vacExpirationYear + "\t" + this.vacComment);
        
        return write;
    }

/**
 * access modifier is changeable "it's better when private"
 * @param vac
 * @return true if deleted, false if not
 */
    public boolean deleteVac(String vac){
        //serach file for vac
        if("VACID".equals(vac)){
            //delete from file
            return true;
        }else
        return false;
    }
    public boolean deleteVac(int vacExpirationYear){
        //search file for all vac
        if(1==vacExpirationYear){
            //delete from file
        }
        return true;
    }
    public boolean deleteVac(int vacId , boolean flag){
        //search file for vac
        //if found delete from file
        return true;
    }

/**
 * access modifier is changeable "it's better when private"
     * @param vac
 * return array of vaccine objects stored in vaccine file
 * NOT FINISHED YET
 */
    public void listVac(){
        ArrayList readVac = ArrayList.class.cast(this.file.read(Vaccine.FILE_NAME));
        
        for (Iterator it = readVac.iterator(); it.hasNext();) {
            Object v = it.next();
            Vaccine vs = Vaccine.class.cast(v);
            System.out.println("Vaccine:  " + vs.vac + "\tVaccine Abbreviation:  " + vs.vacAbbreviation + "\tComments:  " + vs.vacComment + "\tVaccine type:  " + vs.vacType);
            
        }
    }
/**
 * NOT FINISHED YET
 * @param vac
 * @return 
 */
    public int searchVac(String vac){
        return 0;
    }
}

