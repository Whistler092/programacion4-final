/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author java-ws
 */
@Embeddable
public class DocumentDetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "document_datail_Id")
    private int documentdatailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_id")
    private int documentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "warehouses_Id")
    private int warehousesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemId")
    private int itemId;

    public DocumentDetailPK() {
    }

    public DocumentDetailPK(int documentdatailId, int documentId, int warehousesId, int itemId) {
        this.documentdatailId = documentdatailId;
        this.documentId = documentId;
        this.warehousesId = warehousesId;
        this.itemId = itemId;
    }

    public int getDocumentdatailId() {
        return documentdatailId;
    }

    public void setDocumentdatailId(int documentdatailId) {
        this.documentdatailId = documentdatailId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getWarehousesId() {
        return warehousesId;
    }

    public void setWarehousesId(int warehousesId) {
        this.warehousesId = warehousesId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentdatailId;
        hash += (int) documentId;
        hash += (int) warehousesId;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentDetailPK)) {
            return false;
        }
        DocumentDetailPK other = (DocumentDetailPK) object;
        if (this.documentdatailId != other.documentdatailId) {
            return false;
        }
        if (this.documentId != other.documentId) {
            return false;
        }
        if (this.warehousesId != other.warehousesId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.DocumentDetailPK[ documentdatailId=" + documentdatailId + ", documentId=" + documentId + ", warehousesId=" + warehousesId + ", itemId=" + itemId + " ]";
    }
    
}
