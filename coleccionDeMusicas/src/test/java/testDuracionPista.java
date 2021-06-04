import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class testDuracionPista {
    @Test
    public void probandoDuracion(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("mm:ss");
        LocalTime duracion = LocalTime.of(0,43,12);
        System.out.println("Duracion: " + dateFormat.format(duracion));
        String duracionEnString = dateFormat.format(duracion);
        System.out.println("En string: "+ duracionEnString);
        LocalTime sumoMinutos = duracion.plus(1, ChronoUnit.MINUTES);
        System.out.println("Minutos sumados: " + dateFormat.format(sumoMinutos));

        int tsegundos = 200;
        int horas = (tsegundos / 3600);
        int minutos = ((tsegundos-horas*3600)/60);
        int segundos = tsegundos-(horas*3600+minutos*60);
        System.out.println(horas+"h " + minutos + "m " + segundos + "s.");
    }
}
