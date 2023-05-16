package JSON.clientes;


import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ObjetoAFicheros_Clientes {


    public static void main (String args []) throws IOException {
        Gson gson = new Gson();

        ListaClientes listadoClientes = new ListaClientes();

        ClientSer c1 = new ClientSer(1, "Pepe", 1000);
        ClientSer c2 = new ClientSer(2, "Maria", 2000);
        ClientSer c3 = new ClientSer(3, "Juan", 3000);
        ClientSer c4 = new ClientSer(4, "Jose", 4000);
        ClientSer c5 = new ClientSer(5, "Marta", 5000);


        listadoClientes.add(c1);
        listadoClientes.add(c2);
        listadoClientes.add(c3);
        listadoClientes.add(c4);
        listadoClientes.add(c5);


        // Java objects to File
        try (FileWriter writer = new FileWriter("src/ficheros/datos_clientes_JSON.json")) {
            gson.toJson(listadoClientes, writer);

            //Generación de la cadena con formato fichero .json
            String json = gson.toJson(listadoClientes);
            System.out.println(json);

            //Volcado de la cadena con formato .json en forma de Fich.Texto
            GuardarJSON(json);
        }
    }
    public static void GuardarJSON(String json){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/ficheros/datos_clientes.json"))) {
            bw.write(json);
            System.out.println("Fichero creado");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



}
