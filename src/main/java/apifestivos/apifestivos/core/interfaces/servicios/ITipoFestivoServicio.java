package apifestivos.apifestivos.core.interfaces.servicios;

import apifestivos.apifestivos.core.entidades.TipoFestivo;

public interface ITipoFestivoServicio {

    public TipoFestivo esDiaFestivo(String fecha);
}