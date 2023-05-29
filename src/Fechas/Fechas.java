package Fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Fechas {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        LocalDate fecha2 = LocalDate.of(1985,8,14);
        System.out.println(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(fecha2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        long dias = ChronoUnit.MONTHS.between(fecha2, fecha);
        System.out.println(dias);
        System.out.println(formatearFecha(LocalDate.now()));
        System.out.println(formatearFechaHora(LocalDateTime.now()));

        LocalDateTime hora = LocalDateTime.of(2023,8,14,14,00,00);
        System.out.println(formatearFechaHora(hora));

        System.out.println(ChronoUnit.DAYS.between(LocalDateTime.now(),hora));
    }

    public static String formatearFechaHora(LocalDateTime fechaHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        return fechaHora.format(formatter);
    }
    public static String formatearFecha(LocalDate fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatter);
    }

    public static long calcularDiferenciaEnDias(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }
    public static long calcularDiferenciaEnMeses(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.MONTHS.between(fecha1, fecha2);
    }

    public static long calcularDiferenciaEnAnios(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.YEARS.between(fecha1, fecha2);
    }

}