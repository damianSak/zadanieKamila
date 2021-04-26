BootCampCore
Aplikacja umożliwia wczytywanie listy piosenek z plików o rozszerzeniu .csv oraz .xml. Prawidłowy format piosenki wygląda następująco:
tytuł, autor, album, categoria (z listy kategorii: alternative, metal, rock, pop, rnb) oraz liczby głosów. W przypadku gdy piosenka nie
spełnia kryteriów jest odrzucana. Do listy piosenek można dodać utwory z innego pliku. Można dodać własną piosenkę spełniającą kryteria.
Można modyfikować liczbę głosów piosenek znajdujących się na liście. Wczytaną listę można posortować według liczby głosów oraz kategorii.
Posortowane listy można wyswietlić i/lub zapisać do pliku .csv lub .xml.

Compilacja i uruchomienie projektu:
W celu prawidłowego uruchomienia aplikacji wymagane jest java w wersjii 11 oraz Apache Maven 3.6.3.

Dla Windows:
Aby uruchomić aplikację w wierszu poleceń znajdując się w folderze projektu (BootCampCore) należy wywołać komendę:
compile.bat && run.bat 
Dla Linux:
W przypadku środowiska Linux w folderze projektu należy użyć komendy:
./compile.sh && ./run.sh