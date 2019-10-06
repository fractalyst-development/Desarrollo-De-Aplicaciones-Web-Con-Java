package c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import m.Empleado;
//import javax.faces.bean.SessionScoped;

/**
 *
 * @author cazucito
 */
@Named(value = "empleadoBean")
@SessionScoped
public class EmpleadoBean implements Serializable {

    private String nombre = "DEFAULT";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> obtenListado() {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("nombre1", 1));
        empleados.add(new Empleado("nombre2", 2));
        empleados.add(new Empleado("nombre3", 3));
        return empleados;
    }

    /**
     * Creates a new instance of EmpleadoBean
     */
    public EmpleadoBean() {
    }

    public void submit() {
        System.out.println("---" + nombre);

    }
}
