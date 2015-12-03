package parking;

/**
 * Created by HP2 on 12/02/2015.
 */
public interface ParkingObservers {
    void parkingIsFull();
    void parkingIsFull(Park park);
    void spaceIsAvailable();
    void spaceIsAvailable(Park park);
}
