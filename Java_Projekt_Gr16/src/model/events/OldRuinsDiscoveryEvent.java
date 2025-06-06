package model.events;

import service.GameService;

public class OldRuinsDiscoveryEvent implements Event {
    @Override
    public String getName() {
        return "Odkrycie Starych Ruin";
    }

    @Override
    public String getDescription() {
        return "Drwale podczas pracy natrafili na pozostałości starych, zarośniętych ruin. Nie przedstawiają one żadnej wartości, ale pobudzają wyobraźnię poszukiwaczy przygód.";
    }

    @Override
    public String getEffectDescription() {
        return "Brak.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        // Brak efektu dla tego wydarzenia
    }
}
