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
 * @author David Zuluaga
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i")
    , @NamedQuery(name = "Items.findByItemId", query = "SELECT i FROM Items i WHERE i.itemId = :itemId")
    , @NamedQuery(name = "Items.findByCode", query = "SELECT i FROM Items i WHERE i.code = :code")
    , @NamedQuery(name = "Items.findByName", query = "SELECT i FROM Items i WHERE i.name = :name")
    , @NamedQuery(name = "Items.findByLot", query = "SELECT i FROM Items i WHERE i.lot = :lot")
    , @NamedQuery(name = "Items.findByColor", query = "SELECT i FROM Items i WHERE i.color = :color")
    , @NamedQuery(name = "Items.findBySize", query = "SELECT i FROM Items i WHERE i.size = :size")
    , @NamedQuery(name = "Items.findByPrice", query = "SELECT i FROM Items i WHERE i.price = :price")
    , @NamedQuery(name = "Items.findByIsActived", query = "SELECT i FROM Items i WHERE i.isActived = :isActived")})
public class Items implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<DocumentDetail> documentDetailCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemId")
    private Integer itemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "lot")
    private Integer lot;
    @Column(name = "color")
    private Integer color;
    @Column(name = "size")
    private Integer size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Column(name = "isActived")
    private Boolean isActived;

    public Items() {
    }

    public Items(Integer itemId) {
        this.itemId = itemId;
    }

    public Items(Integer itemId, String code, String name, float price) {
        this.itemId = itemId;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Boolean getIsActived() {
        return isActived;
    }

    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Items[ itemId=" + itemId + " ]";
    }
    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("warehouse_proyectPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    @XmlTransient
    public Collection<DocumentDetail> getDocumentDetailCollection() {
        return documentDetailCollection;
    }

    public void setDocumentDetailCollection(Collection<DocumentDetail> documentDetailCollection) {
        this.documentDetailCollection = documentDetailCollection;
    }
}
