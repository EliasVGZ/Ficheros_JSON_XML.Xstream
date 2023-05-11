package XML.clientes;

import java.io.Serializable;

import static XML.clientes.ListaClientes.listadoClientes;

public class ClientSer {

    int Id;
    String Name;
    double Account;


    public ClientSer(int id, String name, double account) {
        Id = id;
        Name = name;
        Account = account;
    }

    public ClientSer() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getAccount() {
        return Account;
    }

    public void setAccount(double account) {
        Account = account;
    }

    public void show() {
        System.out.println(Id+" "+Name+" "+Account);
    }


    /*public void add(ClientSer cliente) {
        listadoClientes.add(cliente);
    }*/


    @Override
    public String toString() {
        return "ClientSer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Account=" + Account +
                '}';
    }
}
