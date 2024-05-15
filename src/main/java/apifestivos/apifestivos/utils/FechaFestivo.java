package apifestivos.apifestivos.utils;

import java.util.Date;

public class FechaFestivo{
    private Date Fecha;
    private String Nombre;

    public FechaFestivo() {
    }

    public FechaFestivo(Date Fecha, String Nombre){
        this.Fecha = Fecha;
        this.Nombre = Nombre;
    }

   

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
