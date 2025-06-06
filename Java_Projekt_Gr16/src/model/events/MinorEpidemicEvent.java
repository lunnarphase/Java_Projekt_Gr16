package model.events;

import service.GameService;

public class MinorEpidemicEvent implements Event {
    @Override
    public String getName() {
        return "Drobna epidemia";
    }

    @Override
    public String getDescription() {
        return "W kilku chatkach ludzie łapią katar i gorączkę. Choroba nie jest groźna, ale budzi niepokój i osłabia siłę roboczą.";
    }

    @Override
    public String getEffectDescription() {
        return "–4 punkty popularności, produkcja zapasów w tej turze jest zmniejszona o 50%.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        gameService.changePopularity(-4);
        gameService.setProductionModifier(0.5); // Zakładamy, że GameService ma metodę do ustawiania tymczasowego modyfikatora produkcji
    }
}
