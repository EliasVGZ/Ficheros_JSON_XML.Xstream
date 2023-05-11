package JSON.clientes;

import JSON.clientes.ClientSer;

import java.util.ArrayList;

public class ListaClientes {


    public static ArrayList<JSON.clientes.ClientSer> listadoClientes= new ArrayList<JSON.clientes.ClientSer>();
    public ListaClientes (){
        super();
    }
    public void add (JSON.clientes.ClientSer clientes){
        listadoClientes.add(clientes);
    }
    public ArrayList<ClientSer> getListadoClientes (){
        return listadoClientes;
    }
}
