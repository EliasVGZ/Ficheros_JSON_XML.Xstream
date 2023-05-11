package XML.clientes;



import com.thoughtworks.xstream.XStream;


import java.io.*;
import java.util.ArrayList;

public class CrearFicheroXMLconObjetos_Clientes {

    public static void main(final String[] args) throws IOException, ClassNotFoundException {

        File fichero = new File("src/ficheros/clientes_XML.dat");

        FileInputStream lectura = new FileInputStream(fichero);

        ObjectInputStream datos = new ObjectInputStream(lectura);
        System.out.println("Proceso de creacion del fichero XML...");

        //Creo un objeto lista de Clientes

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


        try{
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListadoClientes", ListaClientes.class);
            xstream.alias("DatosCliente", ClientSer.class);
            //quitar etiqueta lista (atributo de la clase ListaAlumno
            //xstream.addImplicitCollection(ListaClientes.class, "lista");

            //Insertar los objetos en el XML
            xstream.toXML(lclientes, new FileOutputStream("src/ficheros/clientes_XML.xml"));
            System.out.println("Creado el fichero xml");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
