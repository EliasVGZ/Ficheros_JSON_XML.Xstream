package JSON.clientes;

import JSON.clientes.ClientSer;

import java.util.ArrayList;

public class ListaClientes {


    public static ArrayList<ClientSer> listadoClientes= new ArrayList<ClientSer>();
    public ListaClientes (){
        super();
    }
    public void add (ClientSer clientes){
        listadoClientes.add(clientes);
    }
    public ArrayList<ClientSer> getListadoClientes (){
        return listadoClientes;
    }
}
