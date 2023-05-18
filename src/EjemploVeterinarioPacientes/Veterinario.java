package EjemploVeterinarioPacientes;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Veterinario {
    private String nombre;
    private LocalDate fechaActual;


    private List<Paciente> pacientes = new ArrayList<>();
    public Veterinario(String nombre, LocalDate fechaActual) {
        this.nombre = nombre;
        this.fechaActual = fechaActual;
    }

    public Veterinario() {

    }
    public List<Paciente> getPacientes() {
        return pacientes;
    }


    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}
