
# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([BR2](#br2))([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))([UC2](#uc2))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.([UC3](#uc3))([BR3](#br3))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

3.B Czas aukcji upłynął i brak ofert kupna
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC3](#uc3): Rozliczenie wygranej licytacji
* [UC4](#uc4): Przekazanie produktu

[Kupujący](#ac2)
* [UC5](#uc5): Przeglądanie aukcji
* [UC2](#uc2): Złożenie oferty
* [UC3](#uc3): Rozliczenie wygranej licytacji

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: .Złożenie oferty

**Aktorzy:**  [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć zakupu danego produktu.
2. System prosi o podanie oferowanej kwoty za produkt.
3. System weryfikuje podaną kwotę.
4. System prosi o podanie danych Kupującego.
5. [Kupujący](#ac2) podaje swoje dane.
6. System weryfikuje poprawność danych.
7. System informuje o poprawnym złożeniu oferty za produkt.

**Scenariusze alternatywne:** 

3.A. Oferowana kwota jest niższa od aktualnej lub różni się od niej o mniej niż 1.00 zł
* 3.A.1. System informuje o błędnie podanej kwocie.
* 3.A.2. Przejdź do kroku 2.

6.A. Podano niepoprawne lub niekompletne dane.
* 3.A.1. System informuje o błędnie podanych danych.
* 3.A.2. Przejdź do kroku 4.


<a id="uc3"></a>
### UC3: Rozliczenie wygranej licytacji

**Aktorzy:**  [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**
1. System informuje [Kupującego](#ac2) o wygranej licytacji
2. System prosi [Kupującego](#ac2) o dokonanie płatności ([BR3](#br3)) za produkt.
3. [Kupujący](#ac2) dokonuje płatności ([BR3](#br3)) za produkt.
5. System przetwarza płatność ([BR3](#br3)).
6. System informuje [Kupującego](#ac2) o poprawnie przetworzonej płatności.([BR3](#br3))
7. System weryfikuje wpłaconą kwotę.([BR3](#br3)).
8. System informuje [Sprzedającego](#ac1) o wpłynięciu płatności za produkt.([BR3](#br3)).

**Scenariusze alternatywne:** 
5.A. Kupujący nie dokonuje płatności w ustalonym czasie.
  5.A.1. System anuluje transakcję i informuje o tym Sprzedającego oraz Kupującego. (BR3)
  5.A.2. Koniec przypadku użycia. 

5.A. Błąd przetwarzania płatności
* 5.A.1. System informuje o błędzie.
* 5.A.2. Przejdź do kroku 2.

7.A. Wpłacono wyższą kwotę niż wymagana.
* 7.A.1. System informuje o wpłaceniu wyższej kwoty niż wymagana.
* 7.A.2. System zleca zwrot nadwyżki.
* 7.A.3. Przejdź do kroku 8.

7.B. Wpłacono niższą kwotę niż wymagana.
* 7.B.1. System informuje o wpłaceniu zbyt niskiej kwoty niż wymagana.
* 7.B.2. System prosi [Kupującego](#ac2) o dopłatę brakującej kwoty.
* 7.B.3. Przejdź do kroku 3.

---
<a id="uc4"></a>
### UC4: Przekazanie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

---
<a id="uc5"></a>
### UC5: Przeglądanie aukcji

**Aktorzy:** [Kupujący](#ac2)




## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO2: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO3: Płatność

Reprezentuje przekazanie środków przez Zwycięzcę aukcji Sprzedającemu za wygrany produkt oraz ewentualne operacje powiązane (autoryzacja, księgowanie, zwrot nadpłaty). Płatność inicjuje Kupujący, który wygrał aukcję. System rejestruje próbę płatności, przetwarza ją przez dostawcę płatności, zmienia status po rezultacie, a w przypadku nadpłaty uruchamia mechanizm zwrotu. Po skutecznym zaksięgowaniu płatności Sprzedający jest informowany i może przekazać produkt.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

<a id="br2"></a>
### BR2: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.

<a id="br3"></a>
### BR3: Przekazanie należności

Płatność może być utworzona wyłącznie dla aukcji w statusie zakończona z wyłonionym zwycięzcą.
Jeśli kwota zapłacona jest większa od kwoty do zapłaty nadwyżka jest zwracana.
Jeśli kwota zapłacona jest niższa od kwoty do zapłaty system prosi o dopłatę brakującej części.



## Macierz CRUDL

Przypadek użycia	                      Aukcja	Produkt	  Oferta	Płatność
UC1: Wystawienie produktu na aukcję   |	  C    |	  C	  |   –   |   	–   
UC2: Złożenie oferty	                |   R	   |    R	  |   C	  |     –
UC3: Rozliczenie wygranej licytacji	  |   RU	 |    R	  |   R	  |    CRU
UC4: Przekazanie produktu	            |   RU   |	  RU  |	  R	  |     R
UC5: Przeglądanie aukcji              |   L    |	  L   |	  -	  |     -
