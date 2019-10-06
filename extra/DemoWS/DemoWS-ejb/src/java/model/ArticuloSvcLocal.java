/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Local;
import model.entities.Articulo;

/**
 *
 * @author cazucito
 */
@Local
public interface ArticuloSvcLocal {
    public void persist(Articulo a);
    public List<Articulo> findAll();
    
}
