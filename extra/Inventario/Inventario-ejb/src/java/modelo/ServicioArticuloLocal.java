package modelo;

import java.util.List;
import javax.ejb.Local;
import modelo.entidades.Articulo;

/**
 *
 * @author cazucito
 */
@Local
public interface ServicioArticuloLocal {

    public void persist(Object object);

    public List<Articulo> findAll();

    void altaArticuloSP(Integer id, String nombre);
}
