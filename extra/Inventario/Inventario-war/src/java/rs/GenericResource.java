/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.ServicioArticuloLocal;
import modelo.entidades.Articulo;

/**
 * REST Web Service
 *
 * @author cazucito
 */
@Path("articulos")
public class GenericResource {

    ServicioArticuloLocal servicioArticulo = lookupServicioArticuloLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rs.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Articulo> getArticulos() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return lookupServicioArticuloLocal().findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Articulo getArticulo(@PathParam("id") Integer id) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        List<Articulo> articulos = lookupServicioArticuloLocal().findAll();
        Optional<Articulo> optArticulo = articulos.stream().filter(a->a.getIdentificador()==id).findFirst();
        if(optArticulo.isPresent()) {
            return optArticulo.get();
        } else {
            return new Articulo(0, "NOMBRE");
        }
        
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    private ServicioArticuloLocal lookupServicioArticuloLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServicioArticuloLocal) c.lookup("java:global/Inventario/Inventario-ejb/ServicioArticulo!modelo.ServicioArticuloLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
