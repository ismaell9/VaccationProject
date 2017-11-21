package vaccinationsystem;

import java.util.Date;

/**
 *
 * 
 */
public class Vaccine {
/**
 * access modifiers are better to stay private 
 * but they are changeable if needed
 */
    private int vacId;
    private String vacName;
    private String vacType;
    private Date vacExpirationDate;

/**
 * access modifier is changeable "it's better when private"
 * @return true if added, false if not
 */
    public boolean addVac(){
        return true;
    }

/**
 * access modifier is changeable "it's better when private"
 * @return true if deleted, false if not
 */
    public boolean deleteVac(){
        return true;
    }

/**
 * access modifier is changeable "it's better when private"
 * @return true if updated, false if not
 */
    public boolean updateVac(){
        return true;
    }

/**
 * access modifier is changeable "it's better when private"
 * @return array of vaccine objects stored in vaccine file
 */
    public Object[] listVac(){
        return null;
    }
    
}
