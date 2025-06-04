package service;

import model.buildings.*;
import model.people.Population;
import model.resources.ResourceInventory;
import utils.InputUtils;

public class GameService {
    private Population population;
    private ResourceInventory resourceInventory;
    private BuildingManager buildingManager;
    private int popularity;
    private int gold;
    private int currentTurn;
    private int maxTurns;
    private int goldTarget;
    private int taxLevel;
    private int beerConsumption;
    private int foodConsumption;

    public GameService() {
        this.population = new Population();
        this.resourceInventory = new ResourceInventory();
        this.buildingManager = new BuildingManager();
        this.popularity = 100;
        this.gold = 500; // Początkowa ilość złota
        this.currentTurn = 1;
        this.taxLevel = 0;
        this.beerConsumption = 0;
        this.foodConsumption = 1; // Domyślna wartość
    }

    public void startGame() {
        selectDifficulty();
        initializeGame();

        while (currentTurn <= maxTurns && gold < goldTarget) {
            boolean turnEnded = false;
            while (!turnEnded) {
                displayTurnMenu();
                int choice = InputUtils.getIntInput("Wybierz opcję:");
                switch (choice) {
                    case 1:
                        setTaxLevel();
                        break;
                    case 2:
                        setBeerConsumption();
                        break;
                    case 3:
                        setFoodConsumption();
                        break;
                    case 4:
                        buildBuilding();
                        break;
                    case 5:
                        displayPopularityAndBuildings();
                        break;
                    case 6:
                        displayResources();
                        break;
                    case 7:
                        trade();
                        break;
                    case 8:
                        turnEnded = true;
                        System.out.println("Tura zakończona.");
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór.");
                }
            }
            processTurn();
            currentTurn++;
        }

        checkGameOutcome();
    }


    private void selectDifficulty() {
        System.out.println("Wybierz poziom trudności:");
        System.out.println("1. Łatwy");
        System.out.println("2. Średni");
        System.out.println("3. Trudny");

        int choice = InputUtils.getIntInput("Wybierz opcję:");
        switch (choice) {
            case 1:
                maxTurns = 24; // 2 lata
                goldTarget = 2000;
                break;
            case 2:
                maxTurns = 18; // 1.5 roku
                goldTarget = 3000;
                break;
            case 3:
                maxTurns = 12; // 1 rok
                goldTarget = 4000;
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Ustawiono poziom średni.");
                maxTurns = 18;
                goldTarget = 3000;
        }
    }

    private void initializeGame() {

    }

    private void displayTurnMenu() {
        System.out.println("\nTura " + currentTurn + "/" + maxTurns);
        System.out.println("Złoto: " + gold + " | Popularność: " + popularity + " | Populacja: " + population.getPeasants());
        System.out.println("1. Ustal poziom podatków");
        System.out.println("2. Ustal spożycie piwa");
        System.out.println("3. Ustal spożycie jedzenia");
        System.out.println("4. Zbuduj budynek");
        System.out.println("5. Sprawdź popularność i liczbę budynków");
        System.out.println("6. Sprawdź ilość zapasów");
        System.out.println("7. Handluj");
        System.out.println("8. Zakończ turę");
    }


    private void processTurn() {
        collectTaxes();
        consumeResources();
        produceResources();
        updatePopularity();
        updatePopulation();
    }

    private void collectTaxes() {
        int taxIncome = population.getPeasants() * taxLevel;
        gold += taxIncome;
        System.out.println("Zebrano podatki: " + taxIncome + " złota.");
    }

    private void consumeResources() {
        int foodNeeded = population.getPeasants() * foodConsumption;
        int beerNeeded = population.getPeasants() * beerConsumption;

        boolean hasFood = resourceInventory.consumeResource("Jedzenie", foodNeeded);
        boolean hasBeer = resourceInventory.consumeResource("Piwo", beerNeeded);

        if (!hasFood) {
            popularity -= 8;
            System.out.println("Brak wystarczającej ilości jedzenia! Popularność spadła o 8 punktów.");
        } else {
            System.out.println("Kmiecie są nakarmieni.");
            popularity += foodConsumption; // Przykład: +1 lub +2 w zależności od spożycia
        }

        if (hasBeer) {
            popularity += 4;
            System.out.println("Kmiecie otrzymali piwo. Popularność wzrosła o 4 punkty.");
        } else if (beerConsumption > 0) {
            System.out.println("Brak wystarczającej ilości piwa.");
        }
    }

    private void produceResources() {
        buildingManager.performBuildingsActions(resourceInventory);
    }

    private void updatePopularity() {
        // Aktualizacja popularności na podstawie podatków
        if (taxLevel < 0) {
            popularity += Math.abs(taxLevel) / 2;
        } else if (taxLevel > 0) {
            popularity -= taxLevel / 2;
        } else {
            popularity += 1;
        }

        // Upewnij się, że popularność jest w zakresie 0-100
        if (popularity > 100) popularity = 100;
        if (popularity < 0) popularity = 0;
    }

    private void updatePopulation() {
        if (popularity > 50) {
            population.changePopulation(1);
            System.out.println("Do miasta przybył nowy kmieć.");
        } else if (popularity < 50 && population.getPeasants() > 0) {
            population.changePopulation(-1);
            System.out.println("Kmieć opuścił miasto.");
        }
    }

    private void checkGameOutcome() {
        if (gold >= goldTarget) {
            System.out.println("Gratulacje! Osiągnąłeś wymagane złoto i wygrałeś grę!");
        } else {
            System.out.println("Niestety, nie udało się osiągnąć celu na czas.");
        }
    }




    private void setTaxLevel() {
        System.out.println("Ustal poziom podatków (-8, -6, -4, -2, 0, 2, 4, 6, 8):");
        int level = InputUtils.getIntInput("Podaj wartość:");
        if (level == -8 || level == -6 || level == -4 || level == -2 || level == 0 || level == 2 || level == 4 || level == 6 || level == 8) {
            taxLevel = level;
            System.out.println("Ustawiono poziom podatków na: " + taxLevel);
        } else {
            System.out.println("Nieprawidłowy poziom podatków.");
        }
    }

    private void setBeerConsumption() {
        System.out.println("Ustal spożycie piwa na mieszkańca (0 lub 1):");
        int consumption = InputUtils.getIntInput("Podaj wartość:");
        if (consumption == 0 || consumption == 1) {
            beerConsumption = consumption;
            System.out.println("Ustawiono spożycie piwa na: " + beerConsumption);
        } else {
            System.out.println("Nieprawidłowa wartość.");
        }
    }

    private void setFoodConsumption() {
        System.out.println("Ustal spożycie jedzenia na mieszkańca (1 lub 2):");
        int consumption = InputUtils.getIntInput("Podaj wartość:");
        if (consumption == 1 || consumption == 2) {
            foodConsumption = consumption;
            System.out.println("Ustawiono spożycie jedzenia na: " + foodConsumption);
        } else {
            System.out.println("Nieprawidłowa wartość.");
        }
    }

    private void buildBuilding() {
        System.out.println("Dostępne budynki do zbudowania:");
        System.out.println("1. Chatka Drwala (100 złota)");
        System.out.println("2. Kamieniołom (150 złota)");
        System.out.println("3. Kopalnia Żelaza (200 złota)");
        System.out.println("4. Dom (50 złota)");

        int choice = InputUtils.getIntInput("Wybierz budynek do zbudowania:");
        Building building = null;
        int cost = 0;

        switch (choice) {
            case 1:
                building = new WoodcutterHut();
                cost = 100;
                break;
            case 2:
                building = new Quarry();
                cost = 150;
                break;
            case 3:
                building = new IronMine();
                cost = 200;
                break;
            case 4:
                building = new House();
                cost = 50;
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        if (gold >= cost) {
            gold -= cost;
            buildingManager.addBuilding(building);
            if (building instanceof House) {
                population.increaseMaxPopulation(5);
                System.out.println("Zbudowano dom. Maksymalna populacja zwiększona o 5.");
            } else {
                System.out.println("Zbudowano " + building.getName() + ".");
            }
        } else {
            System.out.println("Nie masz wystarczająco złota.");
        }
    }

    private void displayPopularityAndBuildings() {
        System.out.println("Popularność: " + popularity);
        System.out.println("Liczba budynków: " + buildingManager.getBuildingsCount());
    }

    private void displayResources() {
        resourceInventory.displayResources();
    }

    private void trade() {
        System.out.println("Handel:");
        System.out.println("1. Kup surowiec");
        System.out.println("2. Sprzedaj surowiec");

        int choice = InputUtils.getIntInput("Wybierz opcję:");
        switch (choice) {
            case 1:
                buyResource();
                break;
            case 2:
                sellResource();
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
        }
    }

    private void buyResource() {
        System.out.println("Dostępne surowce do kupienia:");
        System.out.println("1. Drewno");
        System.out.println("2. Kamień");
        System.out.println("3. Żelazo");

        int choice = InputUtils.getIntInput("Wybierz surowiec:");
        String resourceName = null;

        switch (choice) {
            case 1:
                resourceName = "Drewno";
                break;
            case 2:
                resourceName = "Kamień";
                break;
            case 3:
                resourceName = "Żelazo";
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        int quantity = InputUtils.getIntInput("Podaj ilość do kupienia:");
        int cost = quantity * 100;

        if (gold >= cost) {
            gold -= cost;
            resourceInventory.addResource(resourceName, quantity);
            System.out.println("Zakupiono " + quantity + " jednostek " + resourceName + ".");
        } else {
            System.out.println("Nie masz wystarczająco złota.");
        }
    }

    private void sellResource() {
        System.out.println("Surowce dostępne do sprzedaży:");
        resourceInventory.displayResources();

        String resourceName = InputUtils.getStringInput("Podaj nazwę surowca do sprzedaży:");
        int quantity = InputUtils.getIntInput("Podaj ilość do sprzedaży:");

        boolean success = resourceInventory.consumeResource(resourceName, quantity);
        if (success) {
            int revenue = quantity * 50;
            gold += revenue;
            System.out.println("Sprzedano " + quantity + " jednostek " + resourceName + " za " + revenue + " złota.");
        } else {
            System.out.println("Nie masz wystarczającej ilości surowca.");
        }
    }
}