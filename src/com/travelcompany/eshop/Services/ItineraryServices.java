package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Itinerary;

public interface ItineraryServices {
    void create (Itinerary itinerary);
    Itinerary get(Long id);
}
