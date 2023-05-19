package EjemploVALIDAR;

import java.util.Scanner;

public class Ejemplo1DNI {

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el DNI a validar: ");
            String dni = scanner.nextLine();

            if (validaDNI_Exp(dni)) {
                System.out.println("El DNI es válido.");
            } else {
                System.out.println("El DNI no es válido.");
            }
        }
       /* Persona persona1 = new Persona("12345678Z");
        if (persona1.isDniValido()) {
            System.out.println("El DNI de la persona 1 es válido.");
        } else {
            System.out.println("El DNI de la persona 1 no es válido.");
        }

        Persona persona2 = new Persona("98765432X");
        if (persona2.isDniValido()) {
            System.out.println("El DNI de la persona 2 es válido.");
        } else {
            System.out.println("El DNI de la persona 2 no es válido.");

//TODO
            public class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}



        public static void main(String[] args) {
        try {
            verificarEdad(15);
        } catch (MiExcepcion e) {
            System.out.println("Se produjo una excepción: " + e.getMessage());
        }
    }

    public static void verificarEdad(int edad) throws MiExcepcion {
        if (edad < 18) {
            throw new MiExcepcion("La edad mínima requerida es 18 años.");
        } else {
            System.out.println("Puede ingresar.");
        }
    }

        }*/

        public static boolean validaDNI_Exp(String DNI) {
            boolean respuesta = false;
            if (DNI.matches("^[1-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]{1}$")) {
                respuesta = true;
            }
            return respuesta;
        }
    }





}
