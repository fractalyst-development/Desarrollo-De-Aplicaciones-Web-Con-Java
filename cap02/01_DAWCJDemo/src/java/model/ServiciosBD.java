package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.entity.Tabla;

public class ServiciosBD {

    private EntityManager em;

    public ServiciosBD() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("01_DAWCJDemoPU");
        em = factory.createEntityManager();
    }

    public java.util.List<Tabla> obtenTodosLosRegistros() {
        TypedQuery<Tabla> query = em.createNamedQuery("Tabla.findAll", Tabla.class);
        List<Tabla> datos = query.getResultList();
        System.out.println("datos: " + datos);
        return datos;
    }

}
