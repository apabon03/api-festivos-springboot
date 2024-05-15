package apifestivos.apifestivos.core.interfaces.servicios;



import java.util.List;

import apifestivos.apifestivos.utils.FechaFestivo;



public interface ITablaFestivosServicio {

    public List<FechaFestivo> listar(int anio);

    public String verificarFestivo(int anio, int dia, int mes);

    
}
