package XML.clientes;

import XML.Xstream.ejemplos.Person;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static XML.clientes.ListaClientes.listadoClientes;

public class ClientSER_Main {


    public static void main (String args []) throws IOException {

        File fXML_clientes = new File("src/ficheros/XML.clientes.xml");
        XStream xstream = new XStream();

        //Para que no de Errores de acceso de Tipos
        //xstream.allowTypes(new Class[] {Person.class});
        xstream.allowTypes(new Class[] {ClientSer.class, ListaClientes.class});

        //Alias opcionales
        xstream.alias("Clientes", ListaClientes.class);
        xstream.alias("Personas", ClientSer.class);
        //ATRIBUTOS
        //xstream.aliasAttribute(ClientSer.class, "id", "ID");

        //quitar etiqueta lista (atributo de la clase PeopleList)
        //xstream.addImplicitCollection(ListaClientes.class, "lista");

        ClientSer c1 = new ClientSer(1, "Pepe", 1000);
        ClientSer c2 = new ClientSer(2, "Maria", 2000);
        ClientSer c3 = new ClientSer(3, "Juan", 3000);
        ClientSer c4 = new ClientSer(4, "Jose", 4000);
        ClientSer c5 = new ClientSer(5, "Marta", 5000);

        ListaClientes lclientes = new ListaClientes();

        lclientes.add(c1);
        lclientes.add(c2);
        lclientes.add(c3);
        lclientes.add(c4);
        lclientes.add(c5);

        //Insertar los objetos en el XML
        //xstream.toXML(c1, new FileOutputStream("src/ficheros/XML.clientes.xml")); //TODO NO FUNCIONA

        ObjAXML(xstream, lclientes, fXML_clientes ); //TODO OBJETO A XML, NO FUNCIONA
        //XMLAObj(xstream, fXML_clientes); //TODO XML A OBJETO, FUNCIONA



    }

    public static void ObjAXML(XStream xstream, ListaClientes lc, File fXML_clientes) throws FileNotFoundException {
        String xml = xstream.toXML(lc);
        System.out.println(xml);

        //Insertar los objetos en el XML
        xstream.toXML(lc, new FileOutputStream(fXML_clientes));

        System.out.println("Creado el fichero xml");
    }

    public static void XMLAObj(XStream xstream,File fXML_clientes) throws FileNotFoundException{
        //usamos la variable xml del ejemplo 2
        //Person newJoe = (Person)xstream.fromXML(new FileInputStream("PersonaPerson.xml"));
//        Person newJoe = (Person)xstream.fromXML(fXML);
//
//        //Visualización del objeto Joe
//        System.out.println(newJoe.toString());

        //Leer toda la colección

        ListaClientes listadoTodas = (ListaClientes) xstream.fromXML(fXML_clientes);
        System.out.println("Número de alumnos: "+listadoTodas.getListadoClientes().size());

        ArrayList<ClientSer> listaC = new ArrayList<>();
        listaC = listadoTodas.getListadoClientes();


        Iterator iterator = listaC.listIterator(); //recorrer los elementos
        while(iterator.hasNext()){
            ClientSer c = (ClientSer) iterator.next(); //Obtenemos el elemento
            System.out.println("Nombre: "+ c.getName() + "\tID: "+c.getId() + "\t Cuenta: "+c.getAccount());

        }// fin del while
        System.out.println("\n\nFin del listado... ");
    }



}
