package XML.JAXB.clientes;

import XML.JAXB.empresa.Empleado;
import XML.clientes.ClientSer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "clientes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lista_Clientes {



    @XmlElement(name = "cliente")

    private ArrayList<Clientes> listaClientes= null;
    public Lista_Clientes(){
        super();
    }
    public void add (Clientes clientes){
        listaClientes.add(clientes);
    }
    public ArrayList<Clientes> getListadoClientes (){
        return listaClientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.listaClientes = listaClientes;
    }
}
