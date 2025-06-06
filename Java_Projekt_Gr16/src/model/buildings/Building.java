package model.buildings;

import model.resources.ResourceInventory;

// Interfejs reprezentujący budynek w grze
public interface Building {
    String getName(); // Zwraca nazwę budynku
    void performAction(ResourceInventory resourceInventory, double productionModifier); // Wykonuje akcję produkcyjną budynku, uwzględniając modyfikator
    BuildingCost getBuildingCost(); // Zwraca koszt budowy budynku
    int getWorkersRequired(); // Zwraca wymaganą liczbę pracowników do pełnej efektywności
    int getAssignedWorkers(); // Zwraca aktualnie przypisaną liczbę pracowników
    void setAssignedWorkers(int workers); // Ustawia liczbę przypisanych pracowników
}
