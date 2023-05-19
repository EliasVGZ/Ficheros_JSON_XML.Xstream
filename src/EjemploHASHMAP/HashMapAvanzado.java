package EjemploHASHMAP;

import java.util.HashMap;
import java.util.Map;

public class HashMapAvanzado {

    public static void main(String[] args) {
        // Crear un HashMap para almacenar nombres y edades
        Map<String, Integer> personas = new HashMap<>();

        // Agregar elementos al HashMap
        personas.put("Juan", 25);
        personas.put("María", 30);
        personas.put("Pedro", 35);
        personas.put("Ana", 28);

        // Obtener el tamaño del HashMap
        System.out.println("Tamaño del HashMap: " + personas.size());

        // Verificar si el HashMap está vacío
        System.out.println("¿El HashMap está vacío? " + personas.isEmpty());

        // Obtener la edad de una persona en particular
        String nombre = "Juan";
        if (personas.containsKey(nombre)) {
            int edad = personas.get(nombre);
            System.out.println(nombre + " tiene " + edad + " años.");
        } else {
            System.out.println(nombre + " no está en el HashMap.");
        }

        // Iterar sobre las claves y valores del HashMap
        System.out.println("Personas en el HashMap:");
        for (Map.Entry<String, Integer> entry : personas.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " - " + value + " años");
        }

        // Eliminar una persona del HashMap
        String personaAEliminar = "María";
        personas.remove(personaAEliminar);
        System.out.println("Se eliminó a " + personaAEliminar + " del HashMap.");

        // Verificar si una persona sigue en el HashMap
        System.out.println("¿María está en el HashMap? " + personas.containsKey("María"));

        // Limpiar el HashMap
        personas.clear();
        System.out.println("Se limpió el HashMap. Tamaño actual: " + personas.size());
    }
}
