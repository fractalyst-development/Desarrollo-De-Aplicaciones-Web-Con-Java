/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;
import model.entities.Articulo;
import wsc.ArticuloService;

/**
 *
 * @author cazucito
 */

@Stateless
public class ArticuloSvc implements ArticuloSvcLocal {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/ArticuloService/ArticuloWS.wsdl")
    private ArticuloService service;

    @PersistenceContext(unitName = "DemoWS-ejbPU")
    private EntityManager em;

    public void persist(Articulo a) {
        String dato = hello("QWERTY");
        em.persist(a);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Articulo> findAll() {
        
        return em.createNamedQuery("Articulo.findAll").getResultList();
    }

    private String hello(java.lang.String name) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        wsc.ArticuloWS port = service.getArticuloWSPort();
        return port.hello(name);
    }
    
    
}
