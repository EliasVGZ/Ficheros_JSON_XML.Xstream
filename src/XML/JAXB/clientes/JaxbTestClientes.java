package XML.JAXB.clientes;

import XML.JAXB.empresa.Empresa;
import XML.clientes.ClientSer;
import XML.clientes.ListaClientes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class JaxbTestClientes {

    private final static String XML_CLIENTES = "src/ficheros/info-clientes-jaxb.xml";


    public static void main(String[] args) throws JAXBException, IOException {

        ArrayList<Clientes> listaClientes= new ArrayList<>();


        //Primero rellenamos los objetos Java y generamos un XML

        Clientes c1 = new Clientes(1, "Pepe", 1000);
        Clientes c2 = new Clientes(2, "Maria", 2000);
        Clientes c3 = new Clientes(3, "Juan", 3000);
        Clientes c4 = new Clientes(4, "Jose", 4000);
        Clientes c5 = new Clientes(5, "Marta", 5000);

        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        listaClientes.add(c4);
        listaClientes.add(c5);

        Lista_Clientes lc = new Lista_Clientes();
        lc.setClientes(listaClientes);

        // Creamos el contexto e instanciamos el marshaller

        JAXBContext context = JAXBContext.newInstance(Clientes.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(listaClientes, new File("src/ficheros/info-clientes-jaxb.xml"));


        leerXML(context);

    }

    public static void leerXML(JAXBContext context) throws FileNotFoundException, JAXBException{
        // Ahora leemos el XML e instanciamos las clases Java
        System.out.println("Salida desde el fichero XML: ");
        Unmarshaller um = context.createUnmarshaller();
        Lista_Clientes info = (Lista_Clientes) um.unmarshal(new FileReader(XML_CLIENTES));

        for (int i = 0; i <info.getListadoClientes().toArray().length; i++) {
            System.out.println("Clientes " + (i + 1) + ": "
                    +info.getListadoClientes().get(i).getId()+ "con Nombre: "
                    +info.getListadoClientes().get(i).getNombre()+ " y cuenta "
                    +info.getListadoClientes().get(i).getCuenta());


        }

    }

}
