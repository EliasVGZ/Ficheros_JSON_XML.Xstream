package JSON.clientes;

import JSON.ejemplos.Persona;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicherosAObjetos_Clientes {

    public static void main (String args []){
        //Una vez lo tengamos importada librería GSON en proyecto
        //lo primero que haremos es crear una instancia de Gson:
        Gson gson = new Gson();

        //Ahora tenemos que leer ese fichero, os dejo como leerlo linea a linea:
        String fichero = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/ficheros/datos_clientes.json"))) {
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
        ClientSer listadoClientes = gson.fromJson(fichero, ClientSer.class);

        System.out.println(listadoClientes.toString());
    }


}
