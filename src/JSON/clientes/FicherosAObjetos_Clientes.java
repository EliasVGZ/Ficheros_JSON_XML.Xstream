package JSON.clientes;

import JSON.ejemplos.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class FicherosAObjetos_Clientes {

    public static void main (String args []){
        //Una vez lo tengamos importada librería GSON en proyecto
        //lo primero que haremos es crear una instancia de Gson:
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        //Ahora tenemos que leer ese fichero, os dejo como leerlo linea a linea:
        String fichero = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/ficheros/datos_clientes_JSON.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                fichero += linea;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Lectura - Fichero Texto");
        System.out.println(fichero);

        System.out.println("Lectura - Serialización con GSON");
        LeerPersona(gson,fichero);
    }

    public static void LeerPersona(Gson gson, String fichero){

        Type listType = new TypeToken<ArrayList<ClientSer>>() {}.getType();
        ArrayList<ClientSer> listadoClientes = gson.fromJson(fichero, listType);
        String json = gson.toJson(listadoClientes);
        System.out.println(json);

         //TODO POR QUE NO ME LO LEE ASI?*/
/*
        ListaClientes lc = gson.fromJson(fichero, ListaClientes.class);

        //ClientSer lc = gson.fromJson(fichero, ListaClientes.class);

        for (ClientSer inf : lc.getListadoClientes()) {
            System.out.println(inf);
        }*/

    }


}
