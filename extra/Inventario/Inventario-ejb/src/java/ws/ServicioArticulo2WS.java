/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.ServicioArticuloLocal;
import modelo.entidades.Articulo;

/**
 *
 * @author cazucito
 */
@WebService(serviceName = "ServicioArticulo2WS")
@Stateless()
public class ServicioArticulo2WS {

    @EJB
    private ServicioArticuloLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "persist")
    @Oneway
    public void persist(@WebParam(name = "object") Object object) {
        ejbRef.persist(object);
    }

    @WebMethod(operationName = "findAll")
    public List<Articulo> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "altaArticuloSP")
    @Oneway
    public void altaArticuloSP(@WebParam(name = "id") Integer id, @WebParam(name = "nombre") String nombre) {
        ejbRef.altaArticuloSP(id, nombre);
    }
    
}
