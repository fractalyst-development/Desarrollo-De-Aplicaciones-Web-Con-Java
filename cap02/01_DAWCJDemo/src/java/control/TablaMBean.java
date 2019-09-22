package control;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.ServiciosBD;
import model.entity.Tabla;

@Named(value = "tablaMBean")
@RequestScoped
public class TablaMBean {
    private List<Tabla> datos;

    @PostConstruct
    private void init() {
        ServiciosBD servicios = new ServiciosBD();
        datos = servicios.obtenTodosLosRegistros();
        System.out.println("TablaMBean: " + datos);
    }

    /**
     * @return the datos
     */
    public List<Tabla> getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(List<Tabla> datos) {
        this.datos = datos;
    }
}
