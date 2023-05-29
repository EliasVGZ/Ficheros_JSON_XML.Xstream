/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXAMEN.examen.Biblioteca.POJOS;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
/**
 *
 * @author mrnov
 */

@Getter
@Setter
public class Prestamos{
//    private Date fechaPrestamo;
//    private Date fechaDevolucion;
    
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Usuarios lector;


    public Prestamos() {
    }

    public Prestamos(String fechaPrestamo, String fechaDevolucion, String dniLector) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.lector= new Usuarios();
        this.lector.setDniLector(dniLector);
    }


    ArrayList<LibrosOcio> listadoLibros = new ArrayList<>();


    public Prestamos(LocalDate fechaPrestamo, LocalDate fechaDevolucion, String dniLector) {
    }


}
