package com.nology.travel.travelguidebackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TravelGuideRepository extends JpaRepository<TravelGuide, Long> {

    // READ
    List<TravelGuide> getDestinationsByLocation(String location);

    @Query(value="SELECT * FROM travel_guide ORDER BY RAND() LIMIT 1", nativeQuery = true)
    TravelGuide getRandomDestination();

    @Query(value="SELECT DISTINCT id FROM travel_guide", nativeQuery = true)
    List<Long> getDistinctIds();

    // DELETE
    void deleteDestinationById(long id);
}
