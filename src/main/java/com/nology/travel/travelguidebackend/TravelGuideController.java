package com.nology.travel.travelguidebackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TravelGuideController {

    @Autowired
    TravelGuideService destinationService;

    @ExceptionHandler
    public ResponseEntity<String> handleException(TravelGuideNoFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    // CREATE
    @PostMapping("/destination")
    public ResponseEntity createDestination(@RequestBody TravelGuide destination) {
        destinationService.addDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(destination);
    }

    // READ

    @GetMapping("/destinations")
    public ResponseEntity getDestinations(@RequestParam(required = false) String location, @RequestParam(defaultValue = "10") int limit) {
        if (location != null) {
            return ResponseEntity.status(HttpStatus.OK).body(destinationService.getDestinationsByLocation(location));
        }
        return ResponseEntity.status(HttpStatus.OK).body(destinationService.getAllDestinations());
    }

    @GetMapping("/destination/random")
    public ResponseEntity getRandomDestination() {
        return ResponseEntity.status(HttpStatus.OK).body(destinationService.getRandomDestinations());
    }

    @GetMapping("/destinations/ids")
    public ResponseEntity getDestinationsIds() {
        return ResponseEntity.status(HttpStatus.OK).body(destinationService.getDistinctIds());
    }

    @GetMapping("/destination/{id}")
    public ResponseEntity getDestinationById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(destinationService.getDestinationById(id));
    }

    // UPDATE
    @PutMapping("destination/{id}")
    public ResponseEntity updateDestination(@RequestBody TravelGuide newDestination, @PathVariable long id) {
        newDestination.setId(id);
        destinationService.updateDestination(newDestination, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newDestination);
    }

    // DELETE
    @DeleteMapping("/destination/{id}")
    public ResponseEntity<String> deleteGreetingById(@PathVariable long id) {
        destinationService.deleteDestinationById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Destination has been deleted");
    }

}
