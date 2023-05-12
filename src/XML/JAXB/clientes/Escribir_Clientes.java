package XML.JAXB.clientes;

import XML.JAXB.ejemplos.Libro;
import XML.clientes.ClientSer;
import XML.clientes.ListaClientes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;

public class Escribir_Clientes {

    public static void main(String[] args) {

        try {

            Clientes c1 = new Clientes(1, "Pepe", 1000);
            Clientes c2 = new Clientes(2, "Maria", 2000);
            Clientes c3 = new Clientes(3, "Juan", 3000);
            Clientes c4 = new Clientes(4, "Jose", 4000);
            Clientes c5 = new Clientes(5, "Marta", 5000);



            // Creamos el contexto indicando la clase raíz
            JAXBContext contexto = JAXBContext.newInstance(c1.getClass());

            //Creamos el Marshaller, convierte el java bean en una cadena XML
            Marshaller marshaller = contexto.createMarshaller();

            //Formateamos el xml para que quede bien
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Lo visualizamos con system out
            marshaller.marshal(c1, System.out);

            // Escribimos en el archivo
            marshaller.marshal(c1, new File("src/ficheros/clientes_jaxb.xml"));

        } catch (PropertyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
