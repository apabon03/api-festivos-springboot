package apifestivos.apifestivos.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apifestivos.apifestivos.core.interfaces.servicios.ITablaFestivosServicio;
import apifestivos.apifestivos.utils.FechaFestivo;


@RestController
@RequestMapping("/api/festivos")
public class VerificarFestivoControlador {
    
    private ITablaFestivosServicio servicio;

    public VerificarFestivoControlador(ITablaFestivosServicio servicio){
        this.servicio = servicio;
    }

    @RequestMapping(value = "/verificar/{anio}/{dia}/{mes}", method = RequestMethod.GET)
    public String verificarFestivo(@PathVariable int anio, @PathVariable int dia, @PathVariable int mes){
        return servicio.verificarFestivo(anio, dia, mes);
    }

    @RequestMapping(value = "/listar/{anio}", method = RequestMethod.GET)
    public List<FechaFestivo> listar(@PathVariable int anio){
        return servicio.listar(anio);
    }

}