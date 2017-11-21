package vaccinationsystem;

/**
 *
 *
 */
public class ReservOfficer extends Staff{
/**
 * create instance of Reservation class
 * use it to access Reservation methods as aggregation
 */
    private Reservation reservation;

    public void set_reservation(Reservation reservation){
        this.reservation = reservation;
    }
}
