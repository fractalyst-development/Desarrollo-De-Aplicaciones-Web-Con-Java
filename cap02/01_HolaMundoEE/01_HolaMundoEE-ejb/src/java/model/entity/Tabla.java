package model.entity;

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

@Entity
@Table(name = "TABLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabla.findAll", query = "SELECT t FROM Tabla t")
    , @NamedQuery(name = "Tabla.findById", query = "SELECT t FROM Tabla t WHERE t.id = :id")
    , @NamedQuery(name = "Tabla.findByCampo1", query = "SELECT t FROM Tabla t WHERE t.campo1 = :campo1")})
public class Tabla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "CAMPO1")
    private String campo1;

    public Tabla() {
    }

    public Tabla(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabla)) {
            return false;
        }
        Tabla other = (Tabla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Tabla[ id=" + id + " ]";
    }

}
