package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.exception.ItineraryAirportException;

import java.util.ArrayList;
import java.util.List;

public class ItineraryServiceImpl implements ItineraryService{
    List<Itinerary> itineraries = new ArrayList<>();

    @Override
    public void add(Itinerary itinerary) {
        if (itinerary.getDepartureCode() != AirportCode.ATH){
            throw new ItineraryAirportException("The Departure Airport is Wrong");
        }
        if (itinerary.getDestinationCode() == AirportCode.ATH){
            throw new ItineraryAirportException("The Destination Airport is Wrong");
        }
        this.itineraries.add(itinerary);
    }

    @Override
    public Itinerary getById(Long id){
        for (Itinerary itinerary : itineraries) {
            if(itinerary.getId().equals(id)){
                return itinerary;
            }

        }
        return null;
    }

    @Override
    public List<Itinerary> findAll() {
        return this.itineraries;
    }
}
