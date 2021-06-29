package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.LocationService;
import com.sadman.medicalinventory.model.Location;
import com.sadman.medicalinventory.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository repository;

    public List<Location> getAllLocations() {
        return repository.findAll();
    }

    public Location getLocationById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Location createLocation(Location location){
        return repository.save(location);
    }

    public Location updateLocation(Location newLocation, Long id) {
        return repository.findById(id)
                .map(location -> {
                    location.setName(newLocation.getName());
                    return repository.save(location);
                })
                .orElseGet(() -> {
                    newLocation.setId(id);
                    return repository.save(newLocation);
                });
    }

    public void deleteLocationById(Long id){
        repository.deleteById(id);
    }
}
