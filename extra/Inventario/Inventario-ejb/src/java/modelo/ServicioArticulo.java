package modelo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import modelo.entidades.Articulo;

/**
 *
 * @author cazucito
 */
@Stateless
public class ServicioArticulo implements ServicioArticuloLocal {

    @PersistenceContext(unitName = "Inventario-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Articulo> findAll() {
//        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(Articulo.class));
//        return em.createQuery(cq).getResultList();
        System.out.println("NamedQuery");
        return em.createNamedQuery("Articulo.findAll").getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void altaArticuloSP(Integer id, String nombre) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("ALTA_ARTICULO");
// set parameters
        storedProcedure.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        storedProcedure.setParameter("id", id);
        storedProcedure.setParameter("nombre", nombre);
// execute SP
        storedProcedure.execute();

    }

}
