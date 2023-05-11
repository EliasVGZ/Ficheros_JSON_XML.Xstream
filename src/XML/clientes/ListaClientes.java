package XML.clientes;

import java.util.ArrayList;

public class ListaClientes {


    static ArrayList<ClientSer> listadoClientes= new ArrayList<>();
    public ListaClientes(){
        super();
    }
    public void add (ClientSer clientes){
        listadoClientes.add(clientes);
    }
    public ArrayList<ClientSer> getListadoClientes (){
        return listadoClientes;
    }
}
