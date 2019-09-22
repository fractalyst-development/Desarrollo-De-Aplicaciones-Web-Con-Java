package model.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Tabla;

@Stateless
public class FachadaSB implements FachadaSBLocal {

    @PersistenceContext(unitName = "01_HolaMundoEE-ejbPU")
    private EntityManager em;

    @Override
    public java.util.List<Tabla> obtenTodosLosRegistros() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Tabla.class));
        return em.createQuery(cq).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist(Object object) {
        em.persist(object);
    }

}
