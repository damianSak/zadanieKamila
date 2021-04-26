package service;

public class MenuList {
    public static void showMenu() {
        System.out.println();
        System.out.println("Spis funkcji:");
        System.out.println("0 - zakończ działanie programu.");
        System.out.println("1 - dodanie unikalnych utworów z innej listy do twojej.\n" +
                "    Głosy powtarzających się piosenek są sumowane.");
        System.out.println("2 - Wyświetl piosenki ze swojej listy.");
        System.out.println("3 - Dodaj własną piosenkę do listy.");
        System.out.println("4 - Oddaj głos na swoją piosenkę ze swojej listy.");
        System.out.println("5 - Usuń wszystkie głosy wybranej piosenki.");
        System.out.println("6 - Wyzeruj głosy wszystkich piosenek.");
        System.out.println("7 - Generuj raport z rankingu(top 10, top 3 i wszystkie.");
        System.out.println("8 - Generuj raport wg. kategorii.");
        System.out.println("Wybierz dowolną opcję.");
    }
}
