package vaccinationsystem;

/**
 *
 * @author Reputation
 */
public class VaccinationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vaccine v = new Vaccine("DT","Generic","DT","sanofi","Age range 6 months through 6 years",1978);
        //v.addVac(v);
        //v.addVac(v);
        v.addVac(v);
        v.listVac();
        
    }
    
}
