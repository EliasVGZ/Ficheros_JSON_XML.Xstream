package EjemploPilayCola;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {

    public static void main(String[] args) {
        // Crear una instancia de la clase Queue utilizando LinkedList
        Queue<String> queue = new LinkedList<>();

        // Agregar elementos a la cola
        queue.add("Elemento 1");
        queue.add("Elemento 2");
        queue.add("Elemento 3");

        // Obtener y eliminar el elemento al frente de la cola
        String elemento = queue.poll();
        System.out.println("Elemento eliminado: " + elemento);

        // Obtener el elemento al frente de la cola sin eliminarlo
        String elementoFrente = queue.peek();
        System.out.println("Elemento al frente de la cola: " + elementoFrente);

        // Verificar si la cola está vacía
        boolean estaVacia = queue.isEmpty();
        System.out.println("La cola está vacía: " + estaVacia);

        // Obtener el tamaño de la cola
        int tamaño = queue.size();
        System.out.println("Tamaño de la cola: " + tamaño);
    }
}
