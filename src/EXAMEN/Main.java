package EXAMEN;

import EXAMEN.examen.Biblioteca.POJOS.*;


import com.thoughtworks.xstream.XStream;

import java.io.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static EjemploVALIDAR.Ejemplo1DNI.Main.validaDNI_Exp;

import static tercerTrimestre.Validaciones.validaciones.validaNumeroFecha_Exp;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {



        Biblioteca b1 = new Biblioteca("12345", "Biblioteca1", "986986986");
        LibrosOcio lo1 = new LibrosOcio("123", "Libro1", 10, true);
        b1.agregarLibro(lo1);

        b1.agregarLibro(new LibrosTexto("Matematicas", "132", "Mates", 15, true));


        Biblioteca b2 = new Biblioteca("11111", "Biblioteca2", "123123123");
        b2.agregarLibro(new LibrosOcio("321", "Libro2", 12, false));
        b2.agregarLibro(new LibrosTexto("Ciencias", "111", "Ciencia", 12, false));


        List<Biblioteca> biblioteca = new ArrayList<>();

        biblioteca.add(b1);
        biblioteca.add(b2);
        //lo1.altaPrestamo();


        int opcion;
        do {
            System.out.println("Menu de opciones: ");
            System.out.println("1. Añadir Libro.");
            System.out.println("2. generarXML");
            System.out.println("3. Fichero TXT explicativo");
            opcion = Integer.parseInt(br.readLine());
            switch (opcion) {

                //RELLENAR ESTE SWITCH CON TIEMPO
                case 1 ->
                        altaPrestamosLibro();

                case 2 ->

                        generarArchivoXML((ArrayList<Biblioteca>) biblioteca, "biblioteca.xml");


                case 3 ->
                        generarFicheroTextoExplicando();

                case 4 -> System.out.println("Saliendo del pro");


                default -> System.out.println("Opcion no valida, intenta de nuevo.");
            }
        } while (opcion != 3);

        //METODO PAR DAR ALTA LOS LIBROS
        //altaPrestamosLibro();

        //METODO PARA ESCRIB ARCHIVO GSON
        //escribirArchivoGson(biblioteca, "biblioteca.json");

        //todo me genera un error java no es capaz de compilar localdate lo cambié a String pero luego
        //cambié de opinion y usé XML


    }

/*
    public static void altaPrestamo() throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Obtener la fecha del préstamo
        System.out.print("Fecha del préstamo (dd/mm/yyyy): ");
        String fechaPrestamoStr = br.readLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaPrestamo = LocalDate.parse(fechaPrestamoStr, formatter);

        // Obtener el DNI del lector
        System.out.print("DNI del lector: ");
        String dniLector = br.readLine();

        // Obtener el título del libro
        System.out.print("Título del libro: ");
        String tituloLibro = br.readLine();

        // Buscar el libro en la biblioteca
        Libros libroPrestamo = null;
        for (Libros libro : L) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                libroPrestamo = libro;
                break;
            }
        }

        // Verificar si el libro existe y está disponible
        if (libroPrestamo instanceof LibrosOcio) {
            LocalDate fechaDevolucion = fechaPrestamo.plusDays(15);

            // Registrar el préstamo
            Prestamos prestamo = new Prestamos(fechaPrestamo, fechaDevolucion, dniLector);
            ((LibrosOcio) libroPrestamo).agregarPrestamo(prestamo);

            System.out.println("Préstamo registrado:");
            System.out.println("Fecha de préstamo: " + fechaPrestamo);
            System.out.println("Fecha de devolución: " + fechaDevolucion);
            System.out.println("DNI del lector: " + dniLector);
            System.out.println("Título del libro: " + tituloLibro);

            // Cambiar el estado del libro a no disponible
            libroPrestamo.setEstado(false);

        } else {
            System.out.println("El libro no existe o no está disponible en la biblioteca.");
        }
    }*/
    public static void altaPrestamosLibro() throws Exception {

        LibrosOcio lo = new LibrosOcio();

        System.out.println("Fecha prestamo (dia/mes/año): ");
        String fechaprestamo = br.readLine();
        if(!validaNumeroFecha_Exp(fechaprestamo)){
            throw new Exception("Fecha invalida");
        }

        System.out.println("DNI LECTOR: ");
        String dni = br.readLine();
        if (!validaDNI_Exp(dni)) {
            throw new Exception("dni NO VALIDO");
        }
        System.out.println("Titulo Libro: ");
        String tituloLibro = br.readLine();

        Prestamos p = new Prestamos(fechaprestamo, dni, tituloLibro);
        lo.agregarPrestamo(p);

        System.out.println("Libro agregado a la biblioteca");
    }


    private static void generarArchivoXML(ArrayList<Biblioteca> biblioteca, String nombreArchivo) throws FileNotFoundException {

        // Crear el objeto XStream
        XStream xstream = new XStream();


        // Alias para las clases
        xstream.alias("Biblioteca", Biblioteca.class);
        xstream.alias("LibrosOcio", LibrosOcio.class);
        xstream.alias("LibrosTexto", LibrosTexto.class);
        xstream.alias("ListaBiblioteca", ListaBibliotecas.class);

        xstream.allowTypes(new Class[]{Biblioteca.class, LibrosOcio.class, LibrosTexto.class, ListaBibliotecas.class});

        String xml = xstream.toXML(biblioteca);
        System.out.println(xml);

        // Guardar el XML en un archivo
        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo)) {
            xstream.toXML(biblioteca, fileOutputStream);
            System.out.println("Archivo XML generado correctamente: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo XML: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo XML: " + e.getMessage());
        }
    }


    public static void generarFicheroTextoExplicando(){

        try
        {

            BufferedWriter ficheroSalida = new BufferedWriter(
                    new FileWriter(new File("E:\\CD\\Ficheros_XML_JSON\\src\\EXAMEN\\Fbibliotecas\\ficheroExplicacion2.txt")));

            ficheroSalida.write("Mysql lo conecté con una hipotetica clase Biblioteca");
            ficheroSalida.newLine();
            ficheroSalida.write("Elegí las pilas porque creo que el ultimo en llegar está arriba y es el primero en salir. ");
            ficheroSalida.newLine();
            ficheroSalida.write("El hashmap  lo usé para buscar un libro con su referencia");
            ficheroSalida.newLine();
            ficheroSalida.write("El metodo generar XML funciona correctamente, pero no pude quitar \n" +
                    "la letra L que sería de listabiblioteca");
            ficheroSalida.newLine();
            ficheroSalida.write("Los archivos se generan pero no supe meterlos en la carpeta que corresponde");

            ficheroSalida.close();
        }
        catch (IOException errorDeFichero)
        {
            System.out.println(
                    "Ha habido problemas: " +
                            errorDeFichero.getMessage() );

        }
        if (! (new File("ficheroExplicacion.txt")).exists() )
        {
            System.out.println("No he encontrado fichero.txt");
            return;
        }

        System.out.println("Leyendo fichero de texto...");

        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
                    new FileReader(new File("E:\\CD\\Ficheros_XML_JSON\\src\\EXAMEN\\Fbibliotecas\\ficheroExplicacion2.txt")));

            String linea=null;
            while ((linea=ficheroEntrada.readLine()) != null) {
                System.out.println(linea);
            }

            ficheroEntrada.close();
        }
        catch (IOException errorDeFichero)
        {
            System.out.println(
                    "Ha habido problemas: " +
                            errorDeFichero.getMessage() );
        }
    }


    //si hubiera que guardar el listado de los prestamos de un librocio
    //manteniendo el orden de serializacion del prestamo (esta en lo mas alto el mas reciente)
    //LA ESTRUCTURA ELEGIDA SERÍA LAS PILAS ya que si estará en lo mas alto será también el primero en salir
    //como si fuera una pila de platos

    public static void usandounaPila(){
        // Crear una instancia de la clase Stack
        Stack<String> stack = new Stack<>();

        // Agregar elementos a la pila
        stack.push("Libro1");
        stack.push("Libro2");


        // Obtener y eliminar el elemento en la parte superior de la pila
        String elemento = stack.pop();
        System.out.println("Libro eliminado: " + elemento);

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