package EjemploVeterinarioPacientes;

import java.util.List;

public class Paciente {
    private String nombre;
    private String especie;

    private int cantidadPacientes =0;

    public Paciente(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    public Paciente() {

    }

    public String getNombre() {
        return nombre;
    }

    private static int getCantidadPacientes(){
        return getCantidadPacientes();
    }

    public String getEspecie() {
        return especie;
    }

}

