package EjemploVeterinarioPacientes;

import JSON.clientes.ClientSer;
import XML.clientes.ListaClientes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main_Vete {


    public static void main (String args []) throws IOException {

        Gson gson = new GsonBuilder()

                .setPrettyPrinting().create();


        Veterinario veterinario1 = new Veterinario("Dr. Juan Pérez", LocalDate.now().toString());
        veterinario1.agregarPaciente(new Paciente("Tom", "Gato"));
        veterinario1.agregarPaciente(new Paciente("Luna", "Perro"));
        veterinario1.agregarPaciente(new Paciente("Max", "Conejo"));
        veterinario1.actualizarCantidadPacientes();

        Veterinario veterinario2 = new Veterinario("Dr. María Gómez", LocalDate.now().toString());
        veterinario2.agregarPaciente(new Paciente("Bella", "Gato"));
        veterinario2.agregarPaciente(new Paciente("Rocky", "Perro"));
        veterinario2.agregarPaciente(new Paciente("Daisy", "Pájaro"));
        veterinario2.actualizarCantidadPacientes();

        Veterinario veterinario3 = new Veterinario("Dr. Carlos Ruiz", LocalDate.now().toString());
        veterinario3.agregarPaciente(new Paciente("Simba", "León"));
        veterinario3.agregarPaciente(new Paciente("Coco", "Loro"));
        veterinario3.agregarPaciente(new Paciente("Bolt", "Perro"));
        veterinario3.actualizarCantidadPacientes();

        //Crear una lista de veterinarios
        List<Veterinario> veterinarios = new ArrayList<>(); //CREO UNA LISTA DE VETERINARIOS
        veterinarios.add(veterinario1);
        veterinarios.add(veterinario2);
        veterinarios.add(veterinario3);

        String archivo1 = veterinario1.getNombre()+ " - "+LocalDate.now()+ ".xml";
        String archivo2 = veterinario2.getNombre()+ " - "+LocalDate.now()+ ".xml";
        String archivo3 = veterinario3.getNombre()+ " - "+LocalDate.now()+ ".xml";

        //generarArchivoXML(veterinario1, archivo1);
        //generarArchivoXML(veterinario2, archivo2);
        //generarArchivoXML(veterinario3, archivo3);
        //desdeXML(veterinarios);

        //escribirArchivoGson(veterinarios, "veterinarios.json");
        //leerArchivoGson(gson, "veterinarios.json");

        buscarPaciente(veterinarios);
    }
    private static void generarArchivoXML(Veterinario veterinario, String nombreArchivo) throws FileNotFoundException {

        // Crear el objeto XStream
        XStream xstream = new XStream();
        Veterinario vet = new Veterinario();

        // Alias para las clases
        xstream.alias("veterinario", Veterinario.class);
        xstream.alias("paciente", Paciente.class);
        //xstream.addImplicitCollection(ListaVeterinarios.class, "ListaVeterinarios");
        xstream.allowTypes(new Class[]{Veterinario.class, Paciente.class, ListaVeterinarios.class});



        // Convertir los veterinarios y sus pacientes a XML
        String xml = xstream.toXML(veterinario);
        System.out.println(xml);

        // Guardar el XML en un archivo
        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo)) {
            xstream.toXML(veterinario, fileOutputStream);
            System.out.println("Archivo XML generado correctamente: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo XML: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo XML: " + e.getMessage());
        }
    }



    private static void desdeXML(List<Veterinario> veterinarios) {
        if (veterinarios != null) {
            for (Veterinario veterinario : veterinarios) {
                System.out.println("Nombre del veterinario: " + veterinario.getNombre());
                System.out.println("Fecha de registro: " + veterinario.getFechaActual());
                System.out.println("Pacientes:");
                for (Paciente paciente : veterinario.getPacientes()) {
                    System.out.println(" - Nombre: " + paciente.getNombre() + ", Especie: " + paciente.getEspecie());
                }
                System.out.println();
            }
        }
    }

    private static void escribirArchivoGson(List<Veterinario> veterinarios, String nombreArchivo) {


        try (Writer writer = new FileWriter(nombreArchivo)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(veterinarios, writer);
            System.out.println("Archivo Gson generado correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al generar el archivo Gson: " + e.getMessage());
        }

    }

    private static void leerArchivoGson(Gson gson, String fichero) {

        fichero = "";

        try (BufferedReader br = new BufferedReader(new FileReader("veterinarios.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                fichero += linea;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Type listType = new TypeToken<ArrayList<Veterinario>>() {}.getType();
        ArrayList<Veterinario> listaV = gson.fromJson(fichero, listType);

        String json = gson.toJson(listaV);
        System.out.println(json);
    }

    //todo metodo para encontrar un paciente por su nombre

    private static void buscarPaciente(List<Veterinario> veterinarios) {
        boolean pacienteEncontrado = false;

        String nombrePaciente = "Tom";
        for (Veterinario veterinario : veterinarios) {
            for (Paciente paciente : veterinario.getPacientes()) {
                if (paciente.getNombre().equals(nombrePaciente)) {
                    System.out.println("El paciente: "+nombrePaciente+" es paciente de "+veterinario.getNombre());
                    pacienteEncontrado = true;

                }
            }
        }
        if(!pacienteEncontrado){
            System.out.println("Paciente no fue registrado");
        }
    }





}
