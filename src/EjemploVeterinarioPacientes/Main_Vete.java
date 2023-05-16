package EjemploVeterinarioPacientes;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main_Vete {


    public static void main (String args []) throws FileNotFoundException {

        XStream xstream = new XStream();
        Veterinario vete = new Veterinario();

        xstream.alias("veterinario", Veterinario.class);
        xstream.alias("paciente", Paciente.class);



        //TODO ASI SE GENERA CADA XML CON SU VETERINARIO

        File file_xml = new File(String.valueOf(new File(vete.getNombre() + LocalDate.now() + ".xml")));
        try (FileWriter writer = new FileWriter(file_xml)) {
            writer.write(String.valueOf(file_xml));
        } catch (IOException e) {
            e.printStackTrace();
        }




        Veterinario veterinario1 = new Veterinario("Dr. Juan Pérez", LocalDate.now());
        veterinario1.agregarPaciente(new Paciente("Tom", "Gato"));
        veterinario1.agregarPaciente(new Paciente("Luna", "Perro"));
        veterinario1.agregarPaciente(new Paciente("Max", "Conejo"));

        Veterinario veterinario2 = new Veterinario("Dr. María Gómez", LocalDate.now());
        veterinario2.agregarPaciente(new Paciente("Bella", "Gato"));
        veterinario2.agregarPaciente(new Paciente("Rocky", "Perro"));
        veterinario2.agregarPaciente(new Paciente("Daisy", "Pájaro"));

        Veterinario veterinario3 = new Veterinario("Dr. Carlos Ruiz", LocalDate.now());
        veterinario3.agregarPaciente(new Paciente("Simba", "León"));
        veterinario3.agregarPaciente(new Paciente("Coco", "Loro"));
        veterinario3.agregarPaciente(new Paciente("Bolt", "Perro"));





        generarArchivoXML(xstream, veterinario1, file_xml);
        generarArchivoXML(xstream, veterinario2, file_xml);
        generarArchivoXML(xstream, veterinario3, file_xml);
        desdeXML(xstream, file_xml);


    }


    private static void generarArchivoXML(XStream xstream, Veterinario veterinario, File file_xml) throws FileNotFoundException {

        xstream.toXML(veterinario, new FileOutputStream(file_xml));
        String xml = xstream.toXML(veterinario);

        System.out.println(xml);

    }


    private static void desdeXML(XStream xstream,File file_xml){


        ListaVeterinarios a = (ListaVeterinarios) xstream.fromXML(file_xml);

        System.out.println("Numero de veterinarios: "+a.getListadoVeterinarios().size());
        //System.out.println("Numero de pacientes "+);

        ArrayList<Veterinario> listaV;
        listaV = a.getListadoVeterinarios();

        Iterator<Veterinario> iterator = listaV.iterator();
        while (iterator.hasNext()) {
            Veterinario v = iterator.next();
            System.out.println("Nombre del veterinario: " + v.getNombre());
            List<Paciente> pacientes = v.getPacientes();
            for (Paciente p : pacientes) {
                System.out.println("Nombre del paciente: " + p.getNombre() + ", Especie: " + p.getEspecie());
            }
        }

    }


}
