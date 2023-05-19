package EjemploPilayCola;

import java.util.Stack;

public class Pila {

    public static void main(String[] args) {
        // Crear una instancia de la clase Stack
        Stack<String> stack = new Stack<>();

        // Agregar elementos a la pila
        stack.push("Elemento 1");
        stack.push("Elemento 2");
        stack.push("Elemento 3");

        // Obtener y eliminar el elemento en la parte superior de la pila
        String elemento = stack.pop();
        System.out.println("Elemento eliminado: " + elemento);

        // Obtener el elemento en la parte superior de la pila sin eliminarlo
        String elementoSuperior = stack.peek();
        System.out.println("Elemento en la parte superior: " + elementoSuperior);

        // Verificar si la pila está vacía
        boolean estaVacia = stack.isEmpty();
        System.out.println("La pila está vacía: " + estaVacia);

        // Obtener el tamaño de la pila
        int tamaño = stack.size();
        System.out.println("Tamaño de la pila: " + tamaño);
    }
}
