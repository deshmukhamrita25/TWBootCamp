package parking;

/**
 * Created by HP2 on 12/02/2015.
 */
public class AirportSecurityPersonal implements ParkingObservers{

    public boolean isNotified;

    public AirportSecurityPersonal(Park park) {

        park.addChangeListener(this);
    }

    public void parkingIsFull() {
        isNotified = true;
    }

    @Override
    public void parkingIsFull(Park park) {
        isNotified = true;
    }

    public void spaceIsAvailable() {
        isNotified = false;
    }

    @Override
    public void spaceIsAvailable(Park park) {
        isNotified = true;
    }
}
