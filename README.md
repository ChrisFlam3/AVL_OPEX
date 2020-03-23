# Opis struktury
Zaimplementowana struktura to zmodyfikowane drzewo AVL w kierunku drzewa statystyk pozycyjnych, forma zaprezentowana przez T.Cormena.
Operacje wstawiania/usuwania/wyszukiwania mają czas O(logn).
Wszystkie statystyki mają czas stały O(1).
Zdecydowałem się na drzewo AVL, a nie czerwono-czarne ponieważ z treści zadania odniosłem wrażenie, że operacje statystyk pozycyjnych będą
wykonywane znacznie częściej niż operacje wstawiania/usuwania. Pod tym względem drzewo AVL, z racji na poziom zbalansowania, jest lepszym wyborem.

# Dlaczego zdecydowałem się podzielić metody na dwie klasy?
Zdecydowałem się wydzielić wszystkie funkcje składowe niezwiązane ściśle ze strukturą drzewa AVL do osobnej klasy. 
Te metody mogą być używane w przypadku innych drzew, dlatego nie chciałem ograniczać ich użycia do samej klasy drzewa AVL.

# Dlaczego zdecydowałem się na użycie funkcji osłonowych?
Ze względu na czytelność i łatwość użytkowania, jeżeli ktoś wywołuje metodę wstawiania na obiekcie drzewa oczywistym jest, że wstawia owy element do tego właśnie drzewa.
Funkcje osłonowe pozwolą więc uniknąć nieinstynktownych odwołań typu tree.insert(5,tree.getRoot()), zastępując je prostszymi: tree.insert(5).

# Jaki mechanizm testów przyjąłem?
Postanowiłem wykorzystać testy jednostkowe i integracyjne narastające. Funkcjonalności są testowane grupami od podstawowych do najbardziej złożonych.
