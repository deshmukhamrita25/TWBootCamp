package parking;

import java.util.List;

/**
 * Created by HP2 on 12/03/2015.
 */
public class ParkingAttendant implements ParkingObservers{
    List<Park> parkingLotList;//removely fully Parked from list

    public ParkingAttendant(List<Park> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    ParkingAttendant (Park park){
        park.addChangeListener(this);
    }

    public Park selectParkingLotAndPark() throws ParkingNotAvailableException {
        if(parkingLotList.isEmpty())
            throw new ParkingNotAvailableException();
        Park selectedParkingLot = new Park(0);
        for(Park park:parkingLotList){

            if(selectedParkingLot.availableSpaceCount() < park.availableSpaceCount())
                selectedParkingLot = park;
        }
        return selectedParkingLot;
    }


    public Park selectNearestParkingLotAndPark() throws ParkingNotAvailableException {
        if(parkingLotList.isEmpty())
            throw new ParkingNotAvailableException();
        Park selectedParkingLot = parkingLotList.get(0);
        for(Park park:parkingLotList){
            if(selectedParkingLot.getDistance() > park.getDistance())
                selectedParkingLot = park;
        }
        return selectedParkingLot;
    }

    public Park selectCheapestParkingLot() throws ParkingNotAvailableException {
        if(parkingLotList.isEmpty())
            throw new ParkingNotAvailableException();
        Park selectedParkingLot = parkingLotList.get(0);
        for(Park park:parkingLotList){
            if(selectedParkingLot.getParkingRent() > park.getParkingRent())
                selectedParkingLot = park;
        }
        return selectedParkingLot;
    }

    @Override
    public void parkingIsFull() {

    }

    @Override
    public void parkingIsFull(Park park) {
        parkingLotList.remove(park);
    }

    @Override
    public void spaceIsAvailable() {

    }

    @Override
    public void spaceIsAvailable(Park park) {
        parkingLotList.add(park);
    }
}
