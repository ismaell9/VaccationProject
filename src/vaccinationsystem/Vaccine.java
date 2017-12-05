package vaccinationsystem;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * 
 */
public class Vaccine implements Serializable{
/**
 * access modifiers are better to stay private 
 * but they are changeable if needed
 */
    private static int vacId;
    private int vacExpirationYear;
    private String vac;
    private String vacTradeName;
    private String vacAbbreviation;
    private String vacType;
    private String vacComment;
    final private FileMangerBinary file = new FileMangerBinary();
    final static String FILE_NAME = "E:\\VaccinationSystem\\Vaccine.bin";
    File tmpFile = new File(FILE_NAME);
    private static ArrayList<ArrayList> vacs = new ArrayList<>();
    
    Vaccine(String vac, String vacTradeName, String vacAbbreviation, String vacType, String vacComment,int vacExpirationYear){
        if(vacs.isEmpty()){
            Vaccine.set_vacId(1);
        }
        this.vac = vac;
        this.vacTradeName = vacTradeName;
        this.vacAbbreviation = vacAbbreviation;
        this.vacType = vacType;
        this.vacExpirationYear = vacExpirationYear;
        this.vacComment = vacComment;
        
        if(!tmpFile.exists()){
            try{
                boolean creation = tmpFile.createNewFile();
                if(creation)System.out.println("''Vaccine'' File successfully created");
            }catch(IOException e){
                System.out.println(e+ "  couldn't create ''Vaccine'' file..");
            }
        }
    }
// setters and getters
       public static void set_vacId(int value){
        Vaccine.vacId = value;
    }

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
        ArrayList s = new ArrayList<>();
        if(!Vaccine.vacs.isEmpty() ){
            Vaccine.vacs = (ArrayList)(this.file.read(Vaccine.FILE_NAME));
            Vaccine.set_vacId(((int)(vacs.get(vacs.size()-1).get(0))+1));
        }
        s.add(vac.get_vacId());
        s.add(vac.get_vac());
        s.add(vac.get_vacAbbreviation());
        s.add(vac.get_vacTradeName());
        s.add(vac.get_vacType());
        s.add(vac.get_vacExpirationYear());
        s.add(vac.get_vacComment());
        Vaccine.vacs.add(s);
        
        boolean write = this.file.write(Vaccine.FILE_NAME, Vaccine.vacs);

        return write;
    }
    public boolean deleteVac(int value){
        ArrayList s = (ArrayList)(this.file.read(Vaccine.FILE_NAME));
        boolean write = false;
        Iterator<ArrayList> i = s.iterator();
        while(i.hasNext()){
            if((int)i.next().get(5)==value || (int)i.next().get(5) == value ){
                i.remove();
            }
            
            write = this.updateVac(s);
        }
        return write;
    }


    private boolean updateVac(ArrayList vacs){
        Vaccine.vacs = vacs;
        boolean write = this.file.write(Vaccine.FILE_NAME, Vaccine.vacs);
    
        return write;
    }

/**
 * method return type maybe changed
 */
    public void listVac(){
        if(tmpFile.length()!=0 || !tmpFile.exists()){
            
        }
        ArrayList s = (ArrayList) (this.file.read(Vaccine.FILE_NAME));
        //System.out.println(s.get(0).getPLastName());
        for(Object cs: s){
            System.out.println(cs);
        }
    }    
 
    public boolean searchVac(String vac){
        ArrayList s = (ArrayList)(this.file.read(Vaccine.FILE_NAME));
        for(Object cs: s){
            ArrayList l = (ArrayList)cs;
            String f = (String)l.get(1);
            if(f.equals(cs)){
                System.out.println(cs);    
            return true;
            }
            
        }
            return false;
        }
    }

