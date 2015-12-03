package parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP2 on 12/02/2015.
 */
public class ParkingLotManager implements ParkingObservers{

    List<Park> parkingLotList = new ArrayList<>();
    ParkingAttendant parkingAttendant;

    boolean isParkingFull = false;

    ParkingLotManager(Park park){
        parkingLotList.add(park);
        park.addChangeListener(this);
    }

    public Park directParkingToAttendant() throws ParkingNotAvailableException {
        parkingAttendant = new ParkingAttendant(parkingLotList);
        return parkingAttendant.selectParkingLotAndPark();
    }

    public Park directParkingToAttendantToNearest() throws ParkingNotAvailableException {
        parkingAttendant = new ParkingAttendant(parkingLotList);
        return parkingAttendant.selectNearestParkingLotAndPark();
    }


    public Park directParkingToAttendantToCheapest() throws ParkingNotAvailableException {
        parkingAttendant = new ParkingAttendant(parkingLotList);
        return parkingAttendant.selectCheapestParkingLot();
    }

    public void addParkingLot(Park park){
        parkingLotList.add(park);
    }

    public void parkingIsFull() {
        isParkingFull = true;
    }

    @Override
    public void parkingIsFull(Park park) {

    }

    public void spaceIsAvailable() {
        isParkingFull = false;
    }

    @Override
    public void spaceIsAvailable(Park park) {

    }


}
