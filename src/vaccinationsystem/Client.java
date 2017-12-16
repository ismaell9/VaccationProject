package vaccinationsystem;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class Client extends Person implements Serializable{
    private static final long serialVersionUID = 11L;
    private static int cId;
    private int cPhoneNumber;
    private String cAdress;
    private String cGender;
    final private FileMangerBinary file = new FileMangerBinary();
    final static String FILE_NAME = "E:\\VaccinationSystem\\Client.bin";
    final static String EVALUATION_FILE = "E:\\VaccinationSystem\\Evaluation.bin";
    File tmpFile = new File(FILE_NAME);
    File evalTmpFile = new File(EVALUATION_FILE);
    private static ArrayList<ArrayList> clients = new ArrayList<>();
    private static ArrayList<ArrayList> rate = new ArrayList<>();
    
    public Client(){
        
    }
    public Client(int pAge, String pFirstName, String pLastName, String pEmail,int cPhoneNumber, String cAdress, String cGender) {
        
        super(Client.cId, pAge, pFirstName, pLastName, pEmail);
        if(clients.isEmpty()){
            Client.set_cId(1);
        }
        this.cPhoneNumber = cPhoneNumber;
        this.cAdress = cAdress;
        this.cGender = cGender;
        if(!tmpFile.exists()){
            try{
                boolean creation = tmpFile.createNewFile();
                if(creation)System.out.println("''Client'' File successfully created");
                
            }catch(IOException e){
                System.out.println(e+ "  couldn't create ''Client'' file..");
            }
        }
        if(!evalTmpFile.exists()){
            try{
                boolean creation = evalTmpFile.createNewFile();
                if(creation)System.out.println("''Evaluation'' File successfully created");
            }catch(IOException e){
                System.out.println(e+ "  couldn't create ''Evaluation'' file..");
            }
        }
        
    }
/**
 * Setters and Getters
 * @param value
 */
    public static void set_cId(int value){
        Client.cId = value;
    }
    public void set_cPhoneNumber(int cPhoneNumber){
        this.cPhoneNumber = cPhoneNumber;
    }
    public void set_cAdress(String cAdress){
        this.cAdress = cAdress;
    }

    public void set_cGender(String cGender){
        this.cGender = cGender;
    }
    
    public int get_cId(){
        return Client.cId;
    }

    public int get_cPhoneNumber(){
        return this.cPhoneNumber;
    }
    public String get_cAdress(){
        return this.cAdress;
    }
    public String get_cGender(){
        return this.cGender;
    }
/**
 * -----------------------------------------------------------------------------------------------------------------------------------------------------
 */
/**
 * method return type may be changed to "void"
 * @return true if found, false if not
 */    
    public boolean searchForAppointment(){
        return true;
    }

/**
 * @return true if reserved, false if not
 */
    public boolean reserveAppointment(){
        return true;
    }
    
/**
 * 
 * @param rate
 * @param newSuggestions
 * @param comments
 * @return 
 */
    public boolean evaluateService(int rate, String newSuggestions , String comments){
        ArrayList<Object> evaluation = new ArrayList<>();
        if(!(rate<1 || rate>5)){
            this.addClient(this);
            evaluation.add(Client.cId);
            evaluation.add(rate);
            evaluation.add(newSuggestions);
            evaluation.add(comments);
        if(evalTmpFile.length()!=0 || !evalTmpFile.exists()){
            Client.rate = (ArrayList<ArrayList>)(this.file.read(Client.EVALUATION_FILE));           
        }
        Client.rate.add(evaluation);
        
        boolean write = this.file.write(Client.EVALUATION_FILE,Client.rate);
        return write;
        //file.write(, clients)
        }else{
            return false;
        }
    }
    
    public void listEvaluation(){
        if(evalTmpFile.length()!=0 || !evalTmpFile.exists()){
            ArrayList<ArrayList> s = (ArrayList<ArrayList>) (this.file.read(Client.EVALUATION_FILE));
            //System.out.println(s.get(0).getPLastName());
            for(Object cs: s){
                System.out.println(cs);
            }
        }
    }
/**
 * @param c
 * @return true if added, false if not
 */
    public boolean addClient(Client c){
        ArrayList<Object> s = new ArrayList<>();
        if(!Client.clients.isEmpty() ){
            Client.clients = (ArrayList<ArrayList>)(this.file.read(Client.FILE_NAME));
            Client.set_cId(((int)(clients.get(clients.size()-1).get(0))+1));
        }
        s.add(c.get_cId());
        s.add(c.getPFirstName());
        s.add(c.getPLastName());
        s.add(c.getPEmail());
        s.add(c.getPAge());
        s.add(c.get_cPhoneNumber());
        s.add(c.get_cAdress());
        s.add(c.get_cGender());
        Client.clients.add(s);
        
        boolean write = this.file.write(Client.FILE_NAME, Client.clients);

        return write;
    }
/**
 * @param id
 * @return true if deleted, false if not
 */
    public boolean deleteClient(int id){
        ArrayList<ArrayList> s = (ArrayList)(this.file.read(Client.FILE_NAME));
        boolean write = false;
        Iterator<ArrayList> i = s.iterator();
        while(i.hasNext()){
            if((int)i.next().get(0)== id){
                i.remove();
            }
            
            write = this.updateClient(s);
        }
        return write;
    }
    public boolean deleteClient(String email){
        ArrayList<ArrayList> s = (ArrayList)(this.file.read(Client.FILE_NAME));
        boolean write = false;
        Iterator<ArrayList> i = s.iterator();
        while(i.hasNext()){
            String f = (String)i.next().get(5);
            if(f.equals(email)){
                i.remove();
            }
            
            write = this.updateClient(s);
        }
        return write;
        }

    public boolean deleteEvaluation(int cId){
        ArrayList<ArrayList> s = (ArrayList)(this.file.read(Client.EVALUATION_FILE));
        boolean write = false;
        Iterator<ArrayList> i = s.iterator();
        while(i.hasNext()){
            if((int)i.next().get(0) == cId){
                i.remove();
            }
            
            write = this.updateEvaluation(s);
        }
        return write;                   
    }
    /**
 * @param clients
 * @return true if updated, false if not
 */
    private boolean updateClient(ArrayList<ArrayList> clients){
        Client.clients = clients;
        boolean write = this.file.write(Client.FILE_NAME, Client.clients);
        return write;
    }
    private boolean updateEvaluation(ArrayList<ArrayList> rate){
        Client.rate = rate;
        boolean write = this.file.write(Client.EVALUATION_FILE, Client.rate);
        return write;
    }

/**
 * method return type maybe changed
 */
    public void listClient(){
        if(!tmpFile.exists()){
            
            ArrayList<ArrayList> s = (ArrayList<ArrayList>) (this.file.read(Client.FILE_NAME));
            //System.out.println(s.get(0).getPLastName());
            for(Object cs: s){
                System.out.println(cs);
            }
        }
    }
    @Override
    public String toString() {
        return null;
    }

    
}
