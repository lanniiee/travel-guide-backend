package com.nology.travel.travelguidebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TravelGuideService {

    @Autowired
    TravelGuideRepository destinationRepository;

    // CREATE
    public void addDestination(TravelGuide destination) {
        destinationRepository.save(destination);
    }

    // READ
    public List<TravelGuide> getDestinationsByLocation(String location) {
        List<TravelGuide> destinations = destinationRepository.getDestinationsByLocation(location);
        return destinations;
    }


    public TravelGuide getRandomDestinations() {
        return destinationRepository.getRandomDestination();
    }

    public List<Long> getDistinctIds() {
        return destinationRepository.getDistinctIds();
    }

    public List<TravelGuide> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public TravelGuide getDestinationById(long id) {
        Optional<TravelGuide> destination = destinationRepository.findById(id);

        if (destination.isEmpty()) {
            throw new TravelGuideNoFoundException();
        }
        return destination.get();
    }

    // UPDATE
    public void updateDestination(TravelGuide newDestination, long id) {
        if (!destinationRepository.existsById(id)) {
            throw new TravelGuideNoFoundException();
        }
        newDestination.setId(id);
        destinationRepository.save(newDestination);
    }

    // DELETE
    @Transactional
    public void deleteDestinationById(long id) {
        if (!destinationRepository.existsById(id)) {
            throw new TravelGuideNoFoundException();
        }
        destinationRepository.deleteDestinationById(id);
    }
}
