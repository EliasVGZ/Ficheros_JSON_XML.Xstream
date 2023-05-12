package XML.clientes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;



@Getter
@Setter
public class ClientSer implements Serializable {

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

    public void show() {
        System.out.println(Id+" "+Name+" "+Account);
    }

    @Override
    public String toString() {
        return "ClientSer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Account=" + Account +
                '}';
    }

}
