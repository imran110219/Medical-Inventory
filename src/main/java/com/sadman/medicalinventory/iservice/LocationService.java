package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Location;

import java.util.List;

/**
 * @author Sadman
 */
public interface LocationService {
    List<Location> getAllLocations();

    Location getLocationById(Long id) throws RecordNotFoundException;

    Location createLocation(Location location);

    Location updateLocation(Location newLocation, Long id);

    void deleteLocationById(Long id);
}
