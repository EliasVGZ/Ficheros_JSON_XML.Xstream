package EXAMEN.usandoHashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapBiblioteca {

    public static void usandoHashmap(){

        Map<String, Integer> libros = new HashMap<>();

        // Agregar elementos al HashMap
        libros.put("Libro1", 123);
        libros.put("Libro2", 321);

        // Obtener el tamaño del HashMap
        System.out.println("Tamaño del HashMap: " + libros.size());

        // Verificar si el HashMap está vacío
        System.out.println("¿El HashMap está vacío? " + libros.isEmpty());

        // Obtener la refereca de una persona en particular
        String nombre = "Libro1";
        if (libros.containsKey(nombre)) {
            int referencia = libros.get(nombre);
            System.out.println(nombre + " y referencia->  " + referencia + " ");
        } else {
            System.out.println(nombre + " no está en el HashMap.");
        }

    }
}
