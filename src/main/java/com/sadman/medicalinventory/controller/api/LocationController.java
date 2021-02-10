package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Location;
import com.sadman.medicalinventory.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {
    @Autowired
    private LocationService service;

    @GetMapping("/locations")
    public List<Location> getAllLocations(Model model) {
        return service.getAllLocations();
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable(value = "id") Long locationId)
            throws RecordNotFoundException {
        Location location = service.getLocationById(locationId);
        return ResponseEntity.ok().body(location);
    }

    @PostMapping("/locations")
    public Location createLocation(@Valid @RequestBody Location location) {
        return service.createLocation(location);
    }

    @PutMapping("/locations/edit/{id}")
    public Location editLocationById(@RequestBody Location newLocation, @PathVariable(value = "id") Long locationId) {
        return service.updateLocation(newLocation, locationId);
    }

    @DeleteMapping("/locations/delete/{id}")
    public void deleteLocationById(@PathVariable(value = "id") Long locationId){
        service.deleteLocationById(locationId);
    }
}
