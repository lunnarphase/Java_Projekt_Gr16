package model.events;

import service.GameService;

public class DignitaryVisitEvent implements Event {
    @Override
    public String getName() {
        return "Wizyta dostojnika";
    }

    @Override
    public String getDescription() {
        return "Do Twoich włości przybywa ważny gość. Jego wizyta podnosi prestiż osady, ale wiąże się z oczekiwaniem \"darowizny\".";
    }

    @Override
    public String getEffectDescription() {
        return "–20 złota, +2 punkty popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        gameService.changeGold(-20);
        gameService.changePopularity(2);
    }
}
