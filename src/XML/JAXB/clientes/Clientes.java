package XML.JAXB.clientes;


import XML.clientes.ClientSer;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@Getter
@Setter
@XmlRootElement(name = "clientes")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = { "dni", "nombre", "edad" })
@XmlType(propOrder = { "id", "nombre", "cuenta" })
public class Clientes {

    private int id;
    private String  nombre;
    private double cuenta;

    public Clientes(int id, String nombre, double cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public Clientes() {

    }

    //ArrayList<Clientes> listaClientes= new ArrayList<>();





    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cuenta=" + cuenta +
                '}';
    }



}
