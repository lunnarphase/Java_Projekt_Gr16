package model.events;

import service.GameService;

public class GoodReputationEvent implements Event {
    @Override
    public String getName() {
        return "Dobra sława";
    }

    @Override
    public String getDescription() {
        return "Dobra sława o Twoich włościach dotarła do bogatego szlachcica, który postanowił Cię odwiedzić. Będąc pod wrażeniem, zostawia w skarbcu podarunek.";
    }

    @Override
    public String getEffectDescription() {
        return "+30 złota, +2 punkty popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        gameService.changeGold(30);
        gameService.changePopularity(2);
    }
}
