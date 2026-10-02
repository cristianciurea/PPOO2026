package ro.ase.course2.javadoc;

/**
 * Exemplu clasa in Java
 * Clasa exemplifica modul in care pot fi scrise comentarii pe baza
 * carora sa se genereze documentatie de tip JavaDoc
 *
 * @author cristi
 * @version 2.00, 10 October 2017
 */
public class MyClass {
    /**
     *
     * Exemplu metoda simpla.
     *
     * Metoda afiseaza la consola un mesaj primit ca parametru.
     *
     * @param message variabila de tip String ce va fi afisata
     * @see MyClass
     * @deprecated
     * @since version 1.00
     */
    public void MyMethod(String message)
    {
        System.out.println(message);
    }

    /**
     *
     * Exemplu metoda simpla.
     * Metoda afiseaza la consola un mesaj primit ca parametru
     *
     * @param message variabila de tip String ce va fi afisata
     * @since version 1.00
     */
    public void printMessage(String message)
    {
        System.out.println(message);
    }
    /**
     *
     * Exemplu metoda simpla.
     * &lt;br&gt;
     * Metoda aduna 2 numere si returneaza valoarea lor.
     *
     * @param val1 primul numar
     * @param val2 al doilea numar
     * @return suma dintre val1 si val2
     * @since version 2.00
     */
    public int add(int val1, int val2)
    {
        return val1+val2;
    }
}
