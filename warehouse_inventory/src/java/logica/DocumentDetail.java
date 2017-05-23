/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    , @NamedQuery(name = "DocumentDetail.findByDocumentdatailId", query = "SELECT d FROM DocumentDetail d WHERE d.documentDetailPK.documentdatailId = :documentdatailId")
    , @NamedQuery(name = "DocumentDetail.findByDocumentId", query = "SELECT d FROM DocumentDetail d WHERE d.documentDetailPK.documentId = :documentId")
    , @NamedQuery(name = "DocumentDetail.findByQuantity", query = "SELECT d FROM DocumentDetail d WHERE d.quantity = :quantity")
    , @NamedQuery(name = "DocumentDetail.findByWarehousesId", query = "SELECT d FROM DocumentDetail d WHERE d.documentDetailPK.warehousesId = :warehousesId")
    , @NamedQuery(name = "DocumentDetail.findByItemId", query = "SELECT d FROM DocumentDetail d WHERE d.documentDetailPK.itemId = :itemId")})
public class DocumentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentDetailPK documentDetailPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "document_id", referencedColumnName = "document_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document;
    @JoinColumn(name = "itemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Items items;
    @JoinColumn(name = "warehouses_Id", referencedColumnName = "warehouses_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Warehouses warehouses;

    public DocumentDetail() {
    }

    public DocumentDetail(DocumentDetailPK documentDetailPK) {
        this.documentDetailPK = documentDetailPK;
    }

    public DocumentDetail(DocumentDetailPK documentDetailPK, int quantity) {
        this.documentDetailPK = documentDetailPK;
        this.quantity = quantity;
    }

    public DocumentDetail(int documentdatailId, int documentId, int warehousesId, int itemId) {
        this.documentDetailPK = new DocumentDetailPK(documentdatailId, documentId, warehousesId, itemId);
    }

    public DocumentDetailPK getDocumentDetailPK() {
        return documentDetailPK;
    }

    public void setDocumentDetailPK(DocumentDetailPK documentDetailPK) {
        this.documentDetailPK = documentDetailPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Warehouses getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Warehouses warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentDetailPK != null ? documentDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentDetail)) {
            return false;
        }
        DocumentDetail other = (DocumentDetail) object;
        if ((this.documentDetailPK == null && other.documentDetailPK != null) || (this.documentDetailPK != null && !this.documentDetailPK.equals(other.documentDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.DocumentDetail[ documentDetailPK=" + documentDetailPK + " ]";
    }
    
}
