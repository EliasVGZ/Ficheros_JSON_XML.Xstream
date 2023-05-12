package XML.JAXB.clientes;

import XML.JAXB.ejemplos.Libro;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Leer_Clientes {

    public static void main(String[] args) {

        try {
            JAXBContext context = JAXBContext.newInstance( Clientes.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Clientes cliente = (Clientes) unmarshaller.unmarshal(
                    //new File("src/Libro.xml") );
                    new File("src/ficheros/clientes_jaxb.xml") );

            System.out.println(cliente.getId());
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getCuenta());


        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




}
