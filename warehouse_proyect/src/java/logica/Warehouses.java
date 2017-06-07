/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author java-ws
 */
@Entity
@Table(name = "warehouses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehouses.findAll", query = "SELECT w FROM Warehouses w")
    , @NamedQuery(name = "Warehouses.findByWarehousesId", query = "SELECT w FROM Warehouses w WHERE w.warehousesId = :warehousesId")
    , @NamedQuery(name = "Warehouses.findByCode", query = "SELECT w FROM Warehouses w WHERE w.code = :code")
    , @NamedQuery(name = "Warehouses.findByName", query = "SELECT w FROM Warehouses w WHERE w.name = :name")
    , @NamedQuery(name = "Warehouses.findByIsActived", query = "SELECT w FROM Warehouses w WHERE w.isActived = :isActived")})
public class Warehouses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "warehouses_Id")
    private Integer warehousesId;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "isActived")
    private Boolean isActived;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouses")
    private Collection<DocumentDetail> documentDetailCollection;

    public Warehouses() {
    }

    public Warehouses(Integer warehousesId) {
        this.warehousesId = warehousesId;
    }

    public Integer getWarehousesId() {
        return warehousesId;
    }

    public void setWarehousesId(Integer warehousesId) {
        this.warehousesId = warehousesId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActived() {
        return isActived;
    }

    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    @XmlTransient
    public Collection<DocumentDetail> getDocumentDetailCollection() {
        return documentDetailCollection;
    }

    public void setDocumentDetailCollection(Collection<DocumentDetail> documentDetailCollection) {
        this.documentDetailCollection = documentDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warehousesId != null ? warehousesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouses)) {
            return false;
        }
        Warehouses other = (Warehouses) object;
        if ((this.warehousesId == null && other.warehousesId != null) || (this.warehousesId != null && !this.warehousesId.equals(other.warehousesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Warehouses[ warehousesId=" + warehousesId + " ]";
    }
    
    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("warehouse_proyectPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
