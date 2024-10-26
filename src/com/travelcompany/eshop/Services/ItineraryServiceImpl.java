package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Itinerary;

import java.util.ArrayList;
import java.util.List;

public class ItineraryServiceImpl implements ItineraryService{
    List<Itinerary> itineraries = new ArrayList<>();

    @Override
    public void add(Itinerary itinerary) {
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
