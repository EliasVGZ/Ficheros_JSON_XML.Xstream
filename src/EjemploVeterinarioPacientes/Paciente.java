package EjemploVeterinarioPacientes;

import java.util.List;

public class Paciente {
    private String nombre;
    private String especie;


    public Paciente(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    public Paciente() {

    }

    public String getNombre() {
        return nombre;
    }



    public String getEspecie() {
        return especie;
    }

}

