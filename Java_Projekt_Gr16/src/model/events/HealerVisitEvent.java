package model.events;

import service.GameService;

public class HealerVisitEvent implements Event {
    @Override
    public String getName() {
        return "Wizyta wędrownego uzdrowiciela";
    }

    @Override
    public String getDescription() {
        return "Do osady przybył znachor, który za darmo leczy drobne dolegliwości mieszkańców. Ich ogólne samopoczucie lekko się poprawia.";
    }

    @Override
    public String getEffectDescription() {
        return "+2 punkty popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        gameService.changePopularity(2);
    }
}
