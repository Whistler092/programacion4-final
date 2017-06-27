/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David Zuluaga
 */
@Entity
@Table(name = "document_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentDetail.findAll", query = "SELECT d FROM DocumentDetail d")
    , @NamedQuery(name = "DocumentDetail.findByDocument", query = "SELECT d FROM DocumentDetail d WHERE d.documentId = :documentId")
    , @NamedQuery(name = "DocumentDetail.findByDocumentdatailId", query = "SELECT d FROM DocumentDetail d WHERE d.documentdatailId = :documentdatailId")
    , @NamedQuery(name = "DocumentDetail.findByQuantity", query = "SELECT d FROM DocumentDetail d WHERE d.quantity = :quantity")
    , @NamedQuery(name = "DocumentDetail.findByPrice", query = "SELECT d FROM DocumentDetail d WHERE d.price = :price")})
public class DocumentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "document_datail_Id")
    private Integer documentdatailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @JoinColumn(name = "document_id", referencedColumnName = "document_id")
    @ManyToOne(optional = false)
    private Document documentId;
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    @ManyToOne(optional = false)
    private Items itemId;
    @JoinColumn(name = "warehouses_Id", referencedColumnName = "warehouses_Id")
    @ManyToOne(optional = false)
    private Warehouses warehousesId;
    public DocumentDetail() {
    }

    public DocumentDetail(Integer documentdatailId) {
        this.documentdatailId = documentdatailId;
    }

    public DocumentDetail(Integer documentdatailId, int quantity, float price) {
        this.documentdatailId = documentdatailId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getDocumentdatailId() {
        return documentdatailId;
    }

    public void setDocumentdatailId(Integer documentdatailId) {
        this.documentdatailId = documentdatailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Document getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Document documentId) {
        this.documentId = documentId;
    }

    public Items getItemId() {
        return itemId;
    }

    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }

    public Warehouses getWarehousesId() {
        return warehousesId;
    }

    public void setWarehousesId(Warehouses warehousesId) {
        this.warehousesId = warehousesId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentdatailId != null ? documentdatailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentDetail)) {
            return false;
        }
        DocumentDetail other = (DocumentDetail) object;
        if ((this.documentdatailId == null && other.documentdatailId != null) || (this.documentdatailId != null && !this.documentdatailId.equals(other.documentdatailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.DocumentDetail[ documentdatailId=" + documentdatailId + " ]";
    }
    
    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("warehouse_proyectPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
