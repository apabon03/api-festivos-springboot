package apifestivos.apifestivos.core.entidades;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="festivo")
public class TablaFestivos {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;

    @Column(name = "dia", length = 200, nullable = false)
    private String dia;

    @Column(name = "mes", length = 200, nullable = false)
    private String mes;

    @Column(name = "diaspascua", length = 200, nullable = false)
    private String diasPascua;

    //asocia el objeto con un campo
    
    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id") 
    private TipoFestivo tipoFestivo;

    public TablaFestivos() {
    }
        
    public TablaFestivos(int id, String nombre, String dia, String mes, String diasPascua, TipoFestivo tipoFestivo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.tipoFestivo = tipoFestivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(String diasPascua) {
        this.diasPascua = diasPascua;
    }

    public TipoFestivo getTipoFestivo() {
        return tipoFestivo;
    }

    public void setTipoFestivo(TipoFestivo tipoFestivo) {
        this.tipoFestivo = tipoFestivo;
    }

}


