package service;

import model.buildings.*;
import model.people.Population;
import model.resources.ResourceInventory;
import utils.InputUtils;

import java.util.List;
import java.util.Map;

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

    private RankingManager rankingManager = new RankingManager();
    private long totalSellValue = 0; // sumuj w sellResource()

    private double scoreMultiplier = 1.0;

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
                        assignWorkers();
                        break;
                    case 9:
                        turnEnded = true;
                        System.out.println("\n===========================================================================");
                        System.out.println("                                Tura zakończona");
                        System.out.println("---------------------------------------------------------------------------");
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
        System.out.println("\nWybierz poziom trudności:");
        System.out.println("1. Łatwy - wynik x1");
        System.out.println("2. Średni - wynik x1.5");
        System.out.println("3. Trudny - wynik x2");

        int choice = InputUtils.getIntInput("\nWybierz opcję:");
        switch (choice) {
            case 1:
                maxTurns = 24;
                goldTarget = 2000;
                scoreMultiplier = 1.0;
                System.out.println("\n=================================================================");
                System.out.println("Wybrano poziom łatwy: Musisz zebrać " + goldTarget +
                        " złota w " + maxTurns + " tur.");
                System.out.println("=================================================================");
                break;
            case 2:
                maxTurns = 18;
                goldTarget = 3000;
                scoreMultiplier = 1.5;
                System.out.println("\n=================================================================");
                System.out.println("\nWybrano poziom średni: Musisz zebrać " + goldTarget +
                        " złota w " + maxTurns + " tur.");
                System.out.println("=================================================================");
                break;
            case 3:
                maxTurns = 12;
                goldTarget = 4000;
                scoreMultiplier = 2.0;
                System.out.println("\n=================================================================");
                System.out.println("\nWybrano poziom trudny: Musisz zebrać " + goldTarget +
                        " złota w " + maxTurns + " tur.");
                System.out.println("=================================================================");
                break;
            default:
                System.out.println("\nNieprawidłowy wybór. Ustawiono poziom średni.");
                maxTurns = 18;
                goldTarget = 3000;
                scoreMultiplier = 1.5;
                System.out.println("\n=================================================================");
                System.out.println("Musisz zebrać " + goldTarget + " złota w " + maxTurns + " tur.");
                System.out.println("=================================================================");
        }
    }


    private void initializeGame() {

    }

    private void displayTurnMenu() {
        System.out.println("\nTura " + currentTurn + "/" + maxTurns);
        System.out.println("Złoto: " + gold + "/" + goldTarget + " | Popularność: " + popularity + " | Populacja: " + population.getPeasants());
        System.out.println("1. Ustal poziom podatków");
        System.out.println("2. Ustal spożycie piwa");
        System.out.println("3. Ustal spożycie jedzenia");
        System.out.println("4. Zbuduj budynek");
        System.out.println("5. Sprawdź liczbę budynków");
        System.out.println("6. Sprawdź ilość zapasów");
        System.out.println("7. Handluj");
        System.out.println("8. Przydziel pracowników do budynków");
        System.out.println("9. Zakończ turę");
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
        boolean hasBeer = false;

        if (beerConsumption > 0) {
            hasBeer = resourceInventory.consumeResource("Piwo", beerNeeded);
        }

        if (!hasFood) {
            popularity -= 8;
            System.out.println("Brak wystarczającej ilości jedzenia! Popularność spadła o 8 punktów.");
        } else {
            System.out.println("Kmiecie są nakarmieni.");
            popularity += foodConsumption; // Przykład: +1 lub +2 w zależności od spożycia
        }

        if (beerConsumption > 0) {
            if (hasBeer) {
                popularity += 4;
                System.out.println("Kmiecie otrzymali piwo. Popularność wzrosła o 4 punkty.");
            } else {
                System.out.println("Brak wystarczającej ilości piwa. Popularność nie wzrasta.");
            }
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
        if (popularity > 50 && population.getPeasants() < population.getMaxPopulation()) {
            population.changePopulation(1);
            System.out.println("Do miasta przybył nowy kmieć.");
        } else if (popularity < 50 && population.getPeasants() > 2) {
            population.changePopulation(-1);
            System.out.println("Kmieć opuścił miasto.");

            // Zmniejsz liczbę pracowników w budynkach, jeśli jest ich więcej niż aktualna populacja
            int totalAssigned = 0;
            List<Building> buildings = buildingManager.getBuildings();
            for (Building b : buildings) {
                totalAssigned += b.getAssignedWorkers();
            }
            int peasants = population.getPeasants();
            int toRemove = totalAssigned - peasants;
            if (toRemove > 0) {
                // Usuwaj pracowników od końca listy budynków
                for (int i = buildings.size() - 1; i >= 0 && toRemove > 0; i--) {
                    Building b = buildings.get(i);
                    int assigned = b.getAssignedWorkers();
                    if (assigned > 0) {
                        int remove = Math.min(assigned, toRemove);
                        b.setAssignedWorkers(assigned - remove);
                        toRemove -= remove;
                        System.out.println("Z budynku " + b.getName() + " odszedł pracownik.");
                    }
                }
            }
        }
    }

    private void checkGameOutcome() {
        System.out.print("Podaj swój nick lordzie: ");
        String nickname = utils.InputUtils.getStringInput("");
        if (nickname.length() > 20) nickname = nickname.substring(0, 20);

        int turnsLeft = maxTurns - (currentTurn - 1);
        int buildingsCount = buildingManager.getBuildingsCount();
        long baseScore = totalSellValue + gold + (long)turnsLeft * 5000 + buildingsCount * 1000;
        long score = Math.round(baseScore * scoreMultiplier);

        rankingManager.addScore(new service.ScoreEntry(nickname, score));
        rankingManager.displayRanking();

        if (gold >= goldTarget) {
            System.out.println("\n\n!!!  Gratulacje! Osiągnąłeś wymagane złoto i wygrałeś grę !!!");
        } else {
            System.out.println("\n\n!!! Niestety, nie udało się osiągnąć celu na czas !!!");
        }
    }

    private void setTaxLevel() {
        System.out.println("Ustal poziom podatków (-8, -6, -4, -2, 0, 2, 4, 6, 8):");
        int level = InputUtils.getIntInput("Podaj wartość:");
        if (level == -8 || level == -6 || level == -4 || level == -2 || level == 0 || level == 2 || level == 4 || level == 6 || level == 8) {
            taxLevel = level;
            System.out.println("\nUstawiono poziom podatków na: " + taxLevel);
        } else {
            System.out.println("\nNieprawidłowy poziom podatków.");
        }
    }

    private void setBeerConsumption() {
        System.out.println("\nUstal spożycie piwa na mieszkańca (0 lub 1):");
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
            System.out.println("\nUstawiono spożycie jedzenia na: " + foodConsumption);
        } else {
            System.out.println("Nieprawidłowa wartość.");
        }
    }

    private void buildBuilding() {
        System.out.println("\nDostępne budynki do zbudowania:");
        System.out.println("1. Chatka Drwala - " + new WoodcutterHut().getBuildingCost().getCostResources());
        System.out.println("2. Kamieniołom - " + new Quarry().getBuildingCost().getCostResources());
        System.out.println("3. Kopalnia Żelaza - " + new IronMine().getBuildingCost().getCostResources());
        System.out.println("4. Dom" + " - " + new SimpleHouse().getBuildingCost().getCostResources());
        System.out.println("5. Farma - " + new Farm().getBuildingCost().getCostResources());
        System.out.println("6. Browar - " + new Brewery().getBuildingCost().getCostResources());
        System.out.println("7. Anuluj budowę");

        int choice = InputUtils.getIntInput("\nWybierz budynek do zbudowania:");
        Building building = null;

        switch (choice) {
            case 1:
                building = new WoodcutterHut();
                break;
            case 2:
                building = new Quarry();
                break;
            case 3:
                building = new IronMine();
                break;
            case 4:
                building = new SimpleHouse();
                break;
            case 5:
                building = new Farm();
                break;
            case 6:
                building = new Brewery();
                break;
            case 7:
                return;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        // Sprawdź dostępność surowców
        BuildingCost cost = building.getBuildingCost();
        Map<String, Integer> costResources = cost.getCostResources();

        boolean canBuild = true;
        for (Map.Entry<String, Integer> entry : costResources.entrySet()) {
            String resourceName = entry.getKey();
            int requiredAmount = entry.getValue();
            int availableAmount = resourceInventory.getResourceQuantity(resourceName);
            if (availableAmount < requiredAmount) {
                System.out.println("Brak wystarczającej ilości " + resourceName + ". Potrzebne: " +
                        requiredAmount + ", dostępne: " + availableAmount);
                canBuild = false;
            }
        }

        if (canBuild) {
            // Odejmij surowce
            for (Map.Entry<String, Integer> entry : costResources.entrySet()) {
                String resourceName = entry.getKey();
                int requiredAmount = entry.getValue();
                resourceInventory.consumeResource(resourceName, requiredAmount);
            }

            buildingManager.addBuilding(building);
            if (building instanceof House) {
                population.increaseMaxPopulation(5);
                System.out.println("Zbudowano dom. Maksymalna populacja zwiększona o 5.");
            } else {
                System.out.println("Zbudowano " + building.getName() + ".");
            }
        } else {
            System.out.println("Nie możesz zbudować " + building.getName() + ".");
        }
    }

    private void displayPopularityAndBuildings() {
        System.out.println("Liczba budynków: " + buildingManager.getBuildingsCount());
        System.out.println("\nLista budynków:");
        List<Building> buildings = buildingManager.getBuildings();
        if (buildings.isEmpty()) {
            System.out.println("* Brak budynków *");
        } else {
            int index = 1;
            for (Building building : buildings) {
                System.out.println(index + ". " + building.getName());
                index++;
            }
        }
    }

    private void displayResources() {
        resourceInventory.displayResources();
    }

    private void trade() {
        System.out.println("Handel:");
        System.out.println("1. Kup surowiec");
        System.out.println("2. Sprzedaj surowiec");
        System.out.println("9. Anuluj handel");

        int choice = InputUtils.getIntInput("Wybierz opcję:");
        switch (choice) {
            case 1:
                buyResource();
                break;
            case 2:
                sellResource();
                break;
            case 9:
                return;
            default:
                System.out.println("Nieprawidłowy wybór.");
        }
    }

    private void buyResource() {
        System.out.println("Dostępne surowce do kupienia:");
        System.out.println("1. Drewno - 100 złota za jednostkę");
        System.out.println("2. Kamień - 100 złota za jednostkę");
        System.out.println("3. Żelazo - 100 złota za jednostkę");
        System.out.println("4. Jedzenie - 80 złota za jednostkę");
        System.out.println("5. Piwo - 120 złota za jednostkę");
        System.out.println("9. Anuluj zakup");

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
            case 4:
                resourceName = "Jedzenie";
                break;
            case 5:
                resourceName = "Piwo";
                break;
            case 9:
                return;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        int quantity = InputUtils.getIntInput("Podaj ilość do kupienia:");
        int cost;
        switch (resourceName) {
            case "Drewno":
            case "Kamień":
            case "Żelazo":
                cost = quantity * 100;
                break;
            case "Jedzenie":
                cost = quantity * 80;
                break;
            case "Piwo":
                cost = quantity * 120;
                break;
            default:
                System.out.println("Nieprawidłowy surowiec.");
                return;
        }

        System.out.println("Koszt zakupu " + quantity + " jednostek " + resourceName + ": " + cost + " złota.");
        int paymentChoice = InputUtils.getIntInput("Wybierz opcję (1 - zapłać, 9 - anuluj):");

        if (paymentChoice == 9) {
            System.out.println("Zakup anulowany.");
            return;
        } else if (paymentChoice != 1) {
            System.out.println("Nieprawidłowy wybór.");
            return;
        }

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
        String[] resourceNames = {"Drewno", "Kamień", "Żelazo", "Jedzenie", "Piwo"};
        int[] sellPrices = {20, 20, 30, 20, 30}; // Przykładowe ceny sprzedaży jednostkowej
        for (int i = 0; i < resourceNames.length; i++) {
            System.out.println((i + 1) + ". " + resourceNames[i] + " - " +
                    resourceInventory.getResourceQuantity(resourceNames[i]) + " szt. | " +
                    sellPrices[i] + " złota za jednostkę");
        }
        System.out.println((resourceNames.length + 1) + ". Anuluj sprzedaż");

        int choice = InputUtils.getIntInput("Wybierz surowiec do sprzedaży:");
        if (choice == resourceNames.length + 1) {
            System.out.println("Sprzedaż anulowana.");
            return;
        }
        if (choice < 1 || choice > resourceNames.length) {
            System.out.println("Nieprawidłowy wybór.");
            return;
        }
        String resourceName = resourceNames[choice - 1];
        int unitPrice = sellPrices[choice - 1];

        int quantity = InputUtils.getIntInput("Podaj ilość do sprzedaży:");
        int totalRevenue = quantity * unitPrice;
        System.out.println("Sprzedaż " + quantity + " jednostek " + resourceName + " za " + totalRevenue + " złota.");
        int confirm = InputUtils.getIntInput("Potwierdź sprzedaż (1 - tak, 9 - anuluj):");
        if (confirm == 9) {
            System.out.println("Sprzedaż anulowana.");
            return;
        } else if (confirm != 1) {
            System.out.println("Nieprawidłowy wybór.");
            return;
        }

        boolean success = resourceInventory.consumeResource(resourceName, quantity);
        if (success) {
            gold += totalRevenue;
            System.out.println("Sprzedano " + quantity + " jednostek " + resourceName + " za " + totalRevenue + " złota.");
        } else {
            System.out.println("Nie masz wystarczającej ilości surowca.");
        }
    }

    private void assignWorkers() {
        System.out.println("Przydziel pracowników do budynków:");

        List<Building> buildings = buildingManager.getBuildings();
        if (buildings.isEmpty()) {
            System.out.println("Nie masz żadnych budynków.");
            return;
        }

        int totalPeasants = population.getPeasants();
        int totalAssignedWorkers = 0;
        for (Building building : buildings) {
            totalAssignedWorkers += building.getAssignedWorkers();
        }
        int freeWorkers = totalPeasants - totalAssignedWorkers;

        System.out.println("Masz " + freeWorkers + " wolnych pracowników.");

        int index = 1;
        for (Building building : buildings) {
            System.out.println(index + ". " + building.getName() + " - Pracownicy: " +
                    building.getAssignedWorkers() + "/" + building.getWorkersRequired());
            index++;
        }

        int buildingChoice = InputUtils.getIntInput("Wybierz budynek do zarządzania pracownikami (0, aby anulować):");
        if (buildingChoice == 0) {
            return;
        }
        if (buildingChoice < 1 || buildingChoice > buildings.size()) {
            System.out.println("Nieprawidłowy wybór.");
            return;
        }
        Building selectedBuilding = buildings.get(buildingChoice - 1);

        int maxAssignableWorkers = selectedBuilding.getWorkersRequired();
        int currentAssignedWorkers = selectedBuilding.getAssignedWorkers();

        System.out.println("\nBudynek " + selectedBuilding.getName() + " ma " +
                currentAssignedWorkers + "/" + maxAssignableWorkers + " pracowników.");

        int newAssignedWorkers = InputUtils.getIntInput("Podaj nową liczbę pracowników (0 - " + maxAssignableWorkers + "):");
        if (newAssignedWorkers < 0 || newAssignedWorkers > maxAssignableWorkers) {
            System.out.println("Nieprawidłowa liczba pracowników.");
            return;
        }

        int workersDifference = newAssignedWorkers - currentAssignedWorkers;

        if (workersDifference > freeWorkers) {
            System.out.println("Nie masz wystarczająco wolnych pracowników.");
            return;
        }

        // Aktualizacja liczby przydzielonych pracowników
        selectedBuilding.setAssignedWorkers(newAssignedWorkers);
        System.out.println("\nUstawiono " + newAssignedWorkers + " pracowników w budynku " + selectedBuilding.getName() + ".");
    }

}