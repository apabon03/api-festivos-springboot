package apifestivos.apifestivos.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class MetodosFechas {

    public static Date siguienteLunes(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        
        if (calendar.get(Calendar.DAY_OF_WEEK) > Calendar.MONDAY) {
            fecha = agregarDias(fecha, 9 - calendar.get(Calendar.DAY_OF_WEEK));
        } else {
            fecha = agregarDias(fecha, 1);
        }
        return fecha;
    }


    
    public static Date agregarDias(Date fecha, int dias) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            calendar.add(Calendar.DATE, dias);
            
            return calendar.getTime();
    }

    @SuppressWarnings("deprecation")
    public static Date getDomingoRamos(int anio) {

            int a = anio % 19;
            int b = anio % 4;
            int c = anio % 7;
            int d = (19 * a + 24) % 30;
            int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

            int dia = 15 + dias;
            int mes = 3;

            if (dia > 31) {
                dia = dia - 31;
                mes = 4;
            }
            return new Date(anio - 1900, mes - 1, dia);
    }

    public static Date domingoPascua(int anio){
        Date domingoRamos = MetodosFechas.getDomingoRamos(anio);
        Date domingoPascua = MetodosFechas.agregarDias(domingoRamos, 7);
        return domingoPascua;
    }

    public static int obtenerDiaFromDate(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int obtenerMesFromDate(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar van de 0 a

    }

    public static boolean esFechaValida(int anio, int mes, int dia) {
    if (mes < 1 || mes > 12) {
        return false;
    }

    if (dia < 1 || dia > Month.of(mes).length(Year.isLeap(anio))) {
        return false;
    }

    try {
        LocalDate.of(anio, mes, dia);
        return true;
    } catch (DateTimeException e) {
        return false;
    }
}

    public static Date crearFecha(int anio, int dia, int mes){
        LocalDate fechaLocal = LocalDate.of(anio, mes, dia); 
        Date fecha = Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return fecha;
    }
}