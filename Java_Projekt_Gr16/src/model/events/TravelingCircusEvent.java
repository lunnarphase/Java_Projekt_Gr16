package model.events;

import service.GameService;

public class TravelingCircusEvent implements Event {
    @Override
    public String getName() {
        return "Przejazd wędrownego cyrku";
    }

    @Override
    public String getDescription() {
        return "Przez Twoje ziemie przejeżdża trupa wędrownych artystów. Ich występy poprawiają nastroje mieszkańców.";
    }

    @Override
    public String getEffectDescription() {
        return "+3 punkty popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        gameService.changePopularity(3);
    }
}
