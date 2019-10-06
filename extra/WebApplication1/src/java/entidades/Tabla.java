/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cazucito
 */
@Entity
@Table(name = "TABLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabla.findAll", query = "SELECT t FROM Tabla t")
    , @NamedQuery(name = "Tabla.findBySku", query = "SELECT t FROM Tabla t WHERE t.sku = :sku")
    , @NamedQuery(name = "Tabla.findByNombre", query = "SELECT t FROM Tabla t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tabla.findByPrecio", query = "SELECT t FROM Tabla t WHERE t.precio = :precio")})
public class Tabla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKU")
    private Integer sku;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;

    public Tabla() {
    }

    public Tabla(Integer sku) {
        this.sku = sku;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sku != null ? sku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabla)) {
            return false;
        }
        Tabla other = (Tabla) object;
        if ((this.sku == null && other.sku != null) || (this.sku != null && !this.sku.equals(other.sku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tabla[ sku=" + sku + " ]";
    }
    
}
