package apifestivos.apifestivos.aplicacion;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import org.springframework.stereotype.Service;
import apifestivos.apifestivos.core.entidades.TablaFestivos;
import apifestivos.apifestivos.core.interfaces.repositorios.ITablaFestivosRepositorio;
import apifestivos.apifestivos.core.interfaces.servicios.ITablaFestivosServicio;
import apifestivos.apifestivos.utils.FechaFestivo;
import apifestivos.apifestivos.utils.MetodosFechas;

@Service
public class VerificarFestivoServicio implements ITablaFestivosServicio{

    private ITablaFestivosRepositorio repositorio;

    public VerificarFestivoServicio(ITablaFestivosRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public List<FechaFestivo> listar(int anio) {
        
        List<TablaFestivos> festivos = repositorio.findAll();

        ArrayList<TablaFestivos> arrayFestivos = new ArrayList<>();
        arrayFestivos.addAll(festivos);

        ArrayList<Date> fechas = new ArrayList<>();

        for(int i = 0; i < arrayFestivos.size(); i++){

            int mes = Integer.valueOf(arrayFestivos.get(i).getMes());
            int dia = Integer.valueOf(arrayFestivos.get(i).getDia());
            
            switch (arrayFestivos.get(i).getTipoFestivo().getId()) {
                case 1:

                    LocalDate localDate1 = LocalDate.of(anio, mes, dia);
                    Date festivo1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    fechas.add(festivo1);

                    break;

                case 2:
                    LocalDate localDate2 = LocalDate.of(anio, mes, dia);
                    Date festivo2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    int diaSemana = MetodosFechas.obtenerDiaFromDate(festivo2);
                    if (diaSemana == 2) {
                        fechas.add(festivo2);
                        
                    }else{
                        Date nuevoFestivo = MetodosFechas.siguienteLunes(festivo2);
                        fechas.add(nuevoFestivo);
                    }
                    break;
                   
                case 3:
                    int diasPascua = Integer.valueOf(arrayFestivos.get(i).getDiasPascua());

                    switch (diasPascua) {
                        case -2:
                            Date domingoPascuaV = MetodosFechas.domingoPascua(anio);
                            Date viernesSanto = MetodosFechas.agregarDias(domingoPascuaV, diasPascua);
                            fechas.add(viernesSanto);
                            
                            break;
                        case -3:
                            Date domingoPascuaJ = MetodosFechas.domingoPascua(anio);
                            Date juevesSanto = MetodosFechas.agregarDias(domingoPascuaJ, diasPascua);
                            fechas.add(juevesSanto);
                           
                            break;
                        case 0:
                            
                            Date domingoPascuaF = MetodosFechas.domingoPascua(anio);
                            fechas.add(domingoPascuaF);
                            
                            break;
                    
                        default:
                            break;
                    }
                     
                    break;
                case 4:
                int diasPascuaPuente = Integer.valueOf(arrayFestivos.get(i).getDiasPascua());

                switch (diasPascuaPuente) {
                    case 40:
                        Date domingoPascuaV = MetodosFechas.domingoPascua(anio);
                        Date ascension = MetodosFechas.agregarDias(domingoPascuaV, diasPascuaPuente);
                        
                        int diaSemanaA = MetodosFechas.obtenerDiaFromDate(ascension);
                        if (diaSemanaA == 2) {
                            fechas.add(ascension);
                            
                        }else{
                            Date nuevoFestivo = MetodosFechas.siguienteLunes(ascension);
                            fechas.add(nuevoFestivo);
                        }
                        
                        break;
                    case 61:

                        Date domingoPascuaJ = MetodosFechas.domingoPascua(anio);
                        Date corpus = MetodosFechas.agregarDias(domingoPascuaJ, diasPascuaPuente);
                        int diaSemanaB = MetodosFechas.obtenerDiaFromDate(corpus);
                        if (diaSemanaB == 2) {
                            fechas.add(corpus);
                            
                        }else{
                            Date nuevoFestivo = MetodosFechas.siguienteLunes(corpus);
                            fechas.add(nuevoFestivo);
                        }
                        break;
                    case 68:
                        
                        Date domingoPascuaF = MetodosFechas.domingoPascua(anio);
                        Date corazon = MetodosFechas.agregarDias(domingoPascuaF, diasPascuaPuente);
                        int diaSemanaC = MetodosFechas.obtenerDiaFromDate(corazon);
                        if (diaSemanaC == 2) {
                            fechas.add(corazon);
                            
                        }else{
                            Date nuevoFestivo = MetodosFechas.siguienteLunes(corazon);
                            fechas.add(nuevoFestivo);
                        }
                        break;    
                }
                    break;         
            }
        }

        List<FechaFestivo> fechas2 = new ArrayList<>() {
            
        };

        for (int j = 0; j < fechas.size(); j++) {
            
            FechaFestivo fechaFestivo = new FechaFestivo(fechas.get(j), arrayFestivos.get(j).getNombre());

            fechas2.add(fechaFestivo);


        }

        return fechas2;
    }

    @Override
    public String verificarFestivo(int anio, int dia, int mes) {  
        if(MetodosFechas.esFechaValida(anio, mes, dia)){
            ArrayList<FechaFestivo> lista = new ArrayList<FechaFestivo>(listar(anio));

            Date fecha = MetodosFechas.crearFecha(anio, dia, mes);
            for (int k = 0; k < lista.size(); k++){
                if(lista.get(k).getFecha().equals(fecha)){
                    return "la fecha es festivo.\nY corresponde a "+ lista.get(k).getNombre();
                }
            }

            return "No es festivo";
        }else{
            return "No es fecha válida";
        }

    }




    
    
}
