package model.events;

import service.GameService;

public class TreasuryProblemsEvent implements Event {
    @Override
    public String getName() {
        return "Problemy ze skarbcem";
    }

    @Override
    public String getDescription() {
        return "Twój skarbnik okazał się nieuczciwy. Bezpieczeństwo i stan skarbca zostały nadszarpnięte.";
    }

    @Override
    public String getEffectDescription() {
        return "–25 złota, –2 punkty popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        gameService.changeGold(-25);
        gameService.changePopularity(-2);
    }
}
