package XML.clientes;


import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeerFicherosXML_Clientes {

    public static void main(final String[] args) throws FileNotFoundException {
        //crear una instancia de la clase XStream
        XStream xstream = new XStream();

        //Para que no de Errores de acceso de Tipos
        xstream.allowTypes(new Class[] {ClientSer.class, ListaClientes.class});

        //cambiar de nombre a las etiquetas XML
        xstream.alias("ListadoClientes", ListaClientes.class);
        xstream.alias("Clientes", ClientSer.class);

        //quitar etiqueta lista (atributo de la clase ListaAlumnos
        //xstream.addImplicitCollection(ListaClientes.class, "lista");
        ListaClientes listadoTodas = (ListaClientes) xstream.fromXML(new FileInputStream("src/ficheros/clientes_XML.xml"));
        System.out.println("Número de clientes: "+listadoTodas.getListadoClientes().size());

        ArrayList<ClientSer> listaC = new ArrayList<>();
        listaC = listadoTodas.getListadoClientes();


        Iterator iterator = listaC.listIterator(); //recorrer los elementos
        while(iterator.hasNext()){
            ClientSer cli = (ClientSer) iterator.next();

            System.out.println(cli.toString());
        }// fin del while
        System.out.println("\n\nFin del listado... ");
    }// fin main






}
