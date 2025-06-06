package service;

import model.events.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Klasy konkretnych zdarzeń zostaną dodane w pakiecie model.events
import model.events.GoodReputationEvent;
import model.events.BountifulHarvestEvent;
import model.events.UnexpectedFindEvent;
import model.events.ArtisanVisitEvent;
import model.events.HealerVisitEvent;
import model.events.CropFailureEvent;
import model.events.NaturalDisasterEvent;
import model.events.PestInfestationEvent;
import model.events.TreasuryProblemsEvent;
import model.events.MinorEpidemicEvent;
import model.events.LocalFestivalEvent;
import model.events.DignitaryVisitEvent;
import model.events.TravelingCircusEvent;
import model.events.NewsFromNeighborsEvent;
import model.events.AstronomicalEvent;
import model.events.ScientistArtistVisitEvent;
import model.events.OldRuinsDiscoveryEvent;


public class EventManager {
    private List<Event> allEvents;
    private Random random;

    public EventManager() {
        this.allEvents = new ArrayList<>();
        this.random = new Random();
        initializeEvents();
    }

    private void initializeEvents() {
        // Zdarzenia pozytywne
        allEvents.add(new GoodReputationEvent());
        allEvents.add(new BountifulHarvestEvent());
        allEvents.add(new UnexpectedFindEvent());
        allEvents.add(new ArtisanVisitEvent());
        allEvents.add(new HealerVisitEvent());

        // Zdarzenia negatywne
        allEvents.add(new CropFailureEvent());
        allEvents.add(new NaturalDisasterEvent());
        allEvents.add(new PestInfestationEvent());
        allEvents.add(new TreasuryProblemsEvent());
        allEvents.add(new MinorEpidemicEvent());

        // Zdarzenia mieszane i specjalne
        allEvents.add(new LocalFestivalEvent());
        allEvents.add(new DignitaryVisitEvent());
        allEvents.add(new TravelingCircusEvent());
        allEvents.add(new NewsFromNeighborsEvent());

        // Zdarzenia neutralne
        allEvents.add(new AstronomicalEvent());
        allEvents.add(new ScientistArtistVisitEvent());
        allEvents.add(new OldRuinsDiscoveryEvent());
    }

    public Event getRandomEvent() {
        if (random.nextDouble() < 0.20) { // Szansa na wystąpienie zdarzenia = 20%
            if (!allEvents.isEmpty()) {
                return allEvents.get(random.nextInt(allEvents.size()));
            }
        }
        return null; // Brak zdarzenia
    }
}
