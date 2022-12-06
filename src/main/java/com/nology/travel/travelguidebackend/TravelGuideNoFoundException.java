package com.nology.travel.travelguidebackend;

public class TravelGuideNoFoundException extends RuntimeException {

    public TravelGuideNoFoundException() {
        super("Destination cannot be found");
    }
}
