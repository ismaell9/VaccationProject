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
    
    protected int cPhoneNumber;
    protected String cAdress;
    protected String cGender;
    
    final static String FILE_NAME = "Client.bin";
    public static ArrayList<Client> clients = new ArrayList<Client>();
    
    public Client(){
        
    }
    public Client(int pId ,int pAge, String pFirstName, String pLastName, String pEmail,int cPhoneNumber, String cAdress, String cGender) {
        
        super(pId, pAge, pFirstName, pLastName, pEmail);
       
        this.cPhoneNumber = cPhoneNumber;
        this.cAdress = cAdress;
        this.cGender = cGender;
        
        
    }
/**
 * Setters and Getters
 * @param value
 */
   
    public void set_cPhoneNumber(int cPhoneNumber){
        this.cPhoneNumber = cPhoneNumber;
    }
    public void set_cAdress(String cAdress){
        this.cAdress = cAdress;
    }

    public void set_cGender(String cGender){
        this.cGender = cGender;
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
 * @param c
 * @return true if added, false if not
 */
   public boolean addClient() {
        loadFromFile();
        clients.add(this);
        return commitToFile();
    }
   
   
   public boolean commitToFile() {
        return FManger.write(FILE_NAME, clients);
    }
   
   public void loadFromFile() {
        clients = (ArrayList<Client>) FManger.read(FILE_NAME);
    }
   
   private int getClientIndex(int id) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getPId() == id) {
                return i;
            }
        }

        return -1;
    }
   
    public Client searchClientById(int id) {
        Client temp = new Client();
        loadFromFile();
        int index = getClientIndex(id);
        if (index != -1) {
            return clients.get(index);
        } else {
            return temp;
        }
    }
    
     public ArrayList<Client> listClients() {
        loadFromFile();
        return clients;
    }
     
     public boolean updateClient() {
        loadFromFile();
        int index = getClientIndex(this.getPId());

        if (index != -1) {
            clients.set(index, this);

            return commitToFile();
        }

        return false;
    }
     
     public boolean deleteClient(int id) {
        loadFromFile();
        int index = getClientIndex(id);

        if (index != -1) {
            clients.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    


   
    
}
