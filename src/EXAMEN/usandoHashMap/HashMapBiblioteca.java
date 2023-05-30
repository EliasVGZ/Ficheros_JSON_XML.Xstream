package EXAMEN.usandoHashMap;

import EXAMEN.examen.Biblioteca.POJOS.Biblioteca;
import EXAMEN.examen.Biblioteca.POJOS.LibrosOcio;
import EXAMEN.examen.Biblioteca.POJOS.LibrosTexto;

import java.util.HashMap;
import java.util.Map;


public class HashMapBiblioteca {

    public static void usandoHashmap(){

        Map<String, Biblioteca> bibliotecas = new HashMap<>();

        Biblioteca b1 = new Biblioteca("12345", "Biblioteca1", "986986986");
        b1.agregarLibro(new LibrosOcio("123", "Libro1", 10, true));
        b1.agregarLibro(new LibrosTexto("Matematicas", "132", "Mates", 15, true));


        Biblioteca b2 = new Biblioteca("11111", "Biblioteca2", "123123123");
        b2.agregarLibro(new LibrosOcio("321", "Libro2", 12, false));
        b2.agregarLibro(new LibrosTexto("Ciencias", "111", "Ciencia", 12, false));

        // Agregar elementos al HashMap
        bibliotecas.put("libro", b1);
        bibliotecas.put("Libro2", b2);

        // Obtener el tamaño del HashMap
        System.out.println("Tamaño del HashMap: " + bibliotecas.size());

        // Verificar si el HashMap está vacío
        System.out.println("¿El HashMap está vacío? " + bibliotecas.isEmpty());

        // Obtener la refereca de una persona en particular
        String nombre = "Libro1";
        /*if (bibliotecas.containsKey(nombre)) {
            Biblioteca referencia = bibliotecas.get(ref);
            System.out.println(nombre + " y referencia->  " + referencia + " ");
        } else {
            System.out.println(nombre + " no está en el HashMap.");
        }*/

    }
}
