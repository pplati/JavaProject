package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Itinerary;

import java.util.List;

public interface ItineraryService {
    void add (Itinerary itinerary);
    Itinerary getById(Long id);
    List<Itinerary> findAll();
}
