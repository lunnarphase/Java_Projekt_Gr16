# Gra Strategiczna - Zarządzanie Osadą 2025 🏰🌾

## Opis Gry

Witaj w świecie, gdzie Twoje umiejętności zarządzania i strategicznego myślenia zostaną poddane próbie! W tej grze wcielasz się w rolę lorda, którego zadaniem jest rozwijanie swojej osady, dbanie o dobrobyt mieszkańców i gromadzenie bogactwa. 

<br>

## 1. Zasady Rozgrywki 🎲

### 🎯 Cel Gry
Głównym celem gry jest zgromadzenie określonej ilości **złota** w wyznaczonej liczbie **tur**. Ilość złota i liczba tur zależą od wybranego poziomu trudności.

### Poziomy Trudności 📊
Gra oferuje trzy poziomy trudności:
*   **Łatwy:** Mniejsza wymagana ilość złota. Mnożnik punktów x1.
*   **Średni:** Zbalansowana liczba tur i cel złota. Mnożnik punktów x1.5.
*   **Trudny:** Większa wymagana ilość złota. Mnożnik punktów x2.

### Tury ⏳
Rozgrywka podzielona jest na tury. W każdej turze gracz podejmuje decyzje i wykonuje akcje. Po zakończeniu tury przez gracza, następuje faza przetwarzania, która obejmuje:
*   Zbieranie podatków.
*   Konsumpcję jedzenia i piwa przez mieszkańców.
*   Produkcję surowców przez budynki.
*   Aktualizację poziomu popularności.
*   Aktualizację liczby ludności (migracje).

### Zakończenie Gry 🏁
Gra kończy się na dwa sposoby:
*   **Wygrana:** Gracz osiągnął wymagany cel złota przed upływem limitu tur.
*   **Przegrana:** Gracz nie zdołał osiągnąć celu złota w wyznaczonej liczbie tur.

### Punktacja i Ranking 📜
Po zakończeniu gry (niezależnie od wyniku), obliczany jest wynik gracza. Na wynik wpływają:
*   Ilość posiadanego złota.
*   Liczba pozostałych tur (premia za szybkie ukończenie).
*   Liczba posiadanych budynków.
*   Mnożnik wynikający z poziomu trudności.

Gracz podaje swój nick, a wynik zapisywany jest w lokalnym rankingu (`ranking.txt`), który wyświetla 10 najlepszych wyników. <br>

<br>

## 🕹️ 2. Mechaniki Gry - Opis opcji z menu gracza

W każdej turze gracz ma dostęp do następujących opcji:

### 1. Ustal poziom podatków 💰
*   **Opis:** Pozwala ustawić poziom opodatkowania mieszkańców.
*   **Zakres:** Od -8 (dopłaty dla mieszkańców) do +8 (wysokie podatki). Podatki są pobierane od każdego kmiecia.
*   **Wpływ na złoto:** Dodatnie podatki zwiększają dochód w złocie, ujemne go zmniejszają.
*   **Wpływ na popularność:** Wysokie podatki obniżają popularność, niskie lub ujemne ją podnoszą.

### 2. Ustal spożycie piwa 🍺
*   **Opis:** Decyduje, czy mieszkańcy będą spożywać piwo.
*   **Opcje:** 0 (brak spożycia) lub 1 (jedna jednostka piwa na mieszkańca na turę).
*   **Wpływ na popularność:** Jeśli mieszkańcy spożywają piwo (i jest ono dostępne w magazynach), popularność wzrasta.
*   **Wymagania:** Wymaga posiadania surowca "Piwo".

### 3. Ustal spożycie jedzenia 🍞
*   **Opis:** Określa ilość jedzenia konsumowanego przez każdego mieszkańca.
*   **Opcje:** 1 lub 2 jednostki jedzenia na mieszkańca na turę.
*   **Wpływ na popularność:** Zaspokojenie głodu jest kluczowe. Wyższe racje (jeśli dostępne) mogą bardziej zwiększyć popularność. Brak jedzenia drastycznie obniża popularność.
*   **Wymagania:** Wymaga posiadania surowca "Jedzenie".

### 4. Zbuduj budynek 🏗️
*   **Opis:** Pozwala na wznoszenie nowych budynków w osadzie.
*   **Dostępne budynki:**
    *   **Chatka Drwala:** Produkuje Drewno.
    *   **Kamieniołom:** Produkuje Kamień.
    *   **Kopalnia Żelaza:** Produkuje Żelazo.
    *   **Dom:** Zwiększa maksymalną liczbę mieszkańców o 5. Nie wymaga pracowników i nie produkuje surowców.
    *   **Farma:** Produkuje Jedzenie.
    *   **Browar:** Produkuje Piwo.
*   **Koszt budowy:** Każdy budynek wymaga określonej ilości surowców (głównie Drewna i Kamienia) do budowy.
*   **Pracownicy:** Budynki produkcyjne wymagają przydzielenia pracowników do generowania surowców.

### 5. Sprawdź liczbę budynków 🏘️
*   **Opis:** Wyświetla listę wszystkich posiadanych budynków oraz ich łączną liczbę.

### 6. Sprawdź ilość zapasów 📦
*   **Opis:** Pokazuje aktualny stan wszystkich posiadanych surowców (Drewno, Kamień, Żelazo, Jedzenie, Piwo) oraz ilość złota.

### 7. Handluj 🤝
*   **Opis:** Umożliwia kupno lub sprzedaż surowców.
    *   **Kup surowiec:** Gracz może kupić Drewno, Kamień, Żelazo, Jedzenie, Piwo za złoto. Ceny są stałe, z wyjątkiem ceny jedzenia, która może być modyfikowana przez wydarzenia losowe.
    *   **Sprzedaj surowiec:** Gracz może sprzedać posiadane surowce za złoto po ustalonych cenach.

### 8. Przydziel pracowników do budynków 👷‍♂️👷‍♂️
*   **Opis:** Pozwala zarządzać siłą roboczą w osadzie.
*   **Mechanika:** Gracz może przydzielać wolnych kmieci do pracy w budynkach produkcyjnych. Każdy budynek ma określony limit pracowników, których może przyjąć. Im więcej pracowników w budynku (do jego limitu), tym więcej surowców produkuje.

### 9. Zakończ turę ⏭️
*   **Opis:** Kończy aktualną turę gracza i inicjuje fazę przetwarzania końca tury.

<br>

## 3. Kluczowe Systemy Gry ⚙️

### Popularność 📊
*   **Zakres:** Wartość od 0 😠 do 100 😍.
*   **Wpływ:** Bezpośrednio wpływa na migrację ludności.
    *   Popularność > 50: Populacja wzrasta o 1 kmiecia na turę (jeśli są wolne miejsca w domach).
    *   Popularność < 50: Kmiecie odchodzą z osady, co zmniejsza liczbę mieszkańców.
*   **Czynniki modyfikujące:**
    *   Poziom podatków. 💰
    *   Dostępność i racje jedzenia. 🍞
    *   Dostępność i spożycie piwa. 🍺
    *   Wydarzenia losowe. 🎲

### Żywność i Piwo 🍞🍺
*   Kmiecie konsumują jedzenie co turę. Brak jedzenia prowadzi do głodu i znacznego spadku popularności.
*   Jeśli ustawiono spożycie piwa, kmiecie będą je konsumować, co pozytywnie wpływa na popularność (o ile piwo jest dostępne).
*   Produkcja: Jedzenie pochodzi z Farm, Piwo z Browarów. Można je również kupić.

### Wydarzenia Losowe 🎲
*   **Aktywacja:** Mogą zacząć pojawiać się od 3. tury.
*   **Szansa:** 20% na wystąpienie wydarzenia na początku każdej tury (po 2. turze).
*   **Rodzaje:**
    *   **Pozytywne:** Np. "Dobra sława" (+złoto, +popularność), "Obfite zbiory" (+jedzenie).
    *   **Negatywne:** Np. "Klęska nieurodzaju" (-jedzenie, -popularność), "Problemy ze skarbcem" (-złoto, -popularność).
    *   **Mieszane/Specjalne:** Np. "Lokalny festyn" (-piwo, -jedzenie, +popularność).
    *   **Neutralne:** Np. "Wydarzenie astronomiczne" (brak efektu).
*   **Efekty:** Wpływają na stan złota, surowców, popularności, a także mogą wprowadzać tymczasowe modyfikatory (np. zmiana ceny zakupu jedzenia, modyfikator produkcji).

<br>

## 4. Zagadnienia Techniczne Projektu

Projekt został zrealizowany w języku Java, wykorzystując różne koncepcje programowania obiektowego i standardowe biblioteki Javy.

<br>

### Struktura Projektu
Kod zorganizowany jest w następujące główne pakiety:
*   `main`: Zawiera główną klasę uruchomieniową `Game.java`.
*   `model`: Definiuje struktury danych gry:
    *   `buildings`: Klasy związane z budynkami (interfejs `Building`, konkretne budynki, `BuildingCost`, `BuildingManager`).
    *   `events`: Interfejs `Event` oraz klasy dla poszczególnych wydarzeń losowych.
    *   `people`: Klasa `Population` zarządzająca mieszkańcami.
    *   `resources`: Interfejs `Resource`, implementacje (np. `Wood`) oraz `ResourceInventory` do zarządzania zasobami.
*   `service`: Zawiera logikę biznesową gry:
    *   `GameService`: Główny silnik gry, zarządzający turami, stanem gry i interakcjami.
    *   `EventManager`: Odpowiada za losowanie i zarządzanie wydarzeniami.
    *   `RankingManager`: Obsługuje wczytywanie i zapisywanie rankingu do pliku.
    *   `ScoreEntry`: Reprezentuje pojedynczy wpis w rankingu.
*   `utils`: Klasy pomocnicze, np. `InputUtils` do obsługi wejścia od użytkownika.

<br>

### Wykorzystane Koncepcje i Technologie
*   **Programowanie Obiektowe (OOP):**
    *   **Polimorfizm:**
        *   Interfejs `Building` jest implementowany przez różne klasy budynków (`WoodcutterHut`, `Farm`, `Quarry`, `IronMine`, `Brewery`, `SimpleHouse` dziedziczący po `House`). Każda klasa dostarcza własną implementację metod `performAction()` (produkcja surowców z uwzględnieniem modyfikatora) i `getBuildingCost()`.
        *   Interfejs `Event` jest implementowany przez klasy reprezentujące różne wydarzenia. Każde wydarzenie ma własną metodę `applyEffect(GameService gameService)`, która w unikalny sposób modyfikuje stan gry.
    *   **Hermetyzacja:** Wiele klas (np. `ResourceInventory`, `Population`, `GameService`, poszczególne budynki) ukrywa swoje wewnętrzne pola (stan), udostępniając publiczne metody (interfejs) do interakcji z obiektem.
    *   **Dziedziczenie:** Klasa `SimpleHouse` dziedziczy po abstrakcyjnej klasie `House`, współdzieląc pewne cechy, jednocześnie implementując specyficzne dla siebie (lub pozostawiając abstrakcyjne).
*   **Kolekcje Javy (Java Collections Framework):**
    *   `List` (głównie `ArrayList`): Używane do przechowywania listy budynków (`BuildingManager`), listy wszystkich możliwych wydarzeń (`EventManager`), listy wpisów w rankingu (`RankingManager`).
    *   `Map` (głównie `HashMap`): Używane do przechowywania zasobów gracza (`ResourceInventory`, gdzie kluczem jest nazwa surowca, a wartością jego ilość), kosztów budowy budynków (`BuildingCost`).
*   **Losowość (`java.util.Random`):**
    *   Wykorzystywana w `EventManager` do decydowania, czy wydarzenie ma miejsce w danej turze oraz do wyboru konkretnego wydarzenia z puli.
    *   Niektóre wydarzenia (np. `UnexpectedFindEvent`, `ArtisanVisitEvent`) używają `Random` do określenia losowego surowca lub ilości jako części swojego efektu.
*   **Obsługa Wejścia/Wyjścia (File I/O):**
    *   Klasa `RankingManager` odpowiada za trwałe przechowywanie rankingu. Używa `FileReader`, `BufferedReader` do odczytu danych z pliku `ranking.txt` oraz `FileWriter`, `PrintWriter` do zapisu rankingu. Błędy I/O są częściowo obsługiwane (choć w przykładach często przez `IOException ignored`).
*   **Instrukcje Sterujące Przepływem:**
    *   `switch/case`: Szeroko stosowane w `GameService` do obsługi wyborów gracza w menu głównym, menu handlu, przy wyborze poziomu trudności itp.
    *   Pętle (`while`, `for`): Niezbędne do głównej pętli gry (trwającej określoną liczbę tur), iteracji po kolekcjach (np. przetwarzanie wszystkich budynków, wyświetlanie zasobów).
    *   Instrukcje warunkowe (`if-else`): Używane powszechnie do implementacji logiki gry, np. sprawdzania warunków budowy, dostępności surowców, efektów popularności.
*   **Klasy Narzędziowe:**
    *   `utils.InputUtils`: Klasa pomocnicza upraszczająca pobieranie danych wejściowych (liczby całkowite, ciągi znaków) od użytkownika poprzez konsolę, w tym podstawową walidację typu danych.
*   **Struktury Danych:**
    *   Oprócz wbudowanych kolekcji, projekt definiuje własne proste struktury danych, takie jak `BuildingCost` (reprezentująca koszt budowy) czy `ScoreEntry` (reprezentująca wpis w rankingu).
*   **Modularność:**
    *   Kod jest podzielony na logiczne moduły (klasy i pakiety), co ułatwia zrozumienie, zarządzanie i potencjalną rozbudowę projektu. Każda klasa ma jasno zdefiniowaną odpowiedzialność.

<br>

---
Życzymy udanej rozgrywki i strategicznych sukcesów! 🏆🌟

