/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author java-ws
 */
@Entity
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findByDocumentId", query = "SELECT d FROM Document d WHERE d.documentId = :documentId")
    , @NamedQuery(name = "Document.findByConsecutive", query = "SELECT d FROM Document d WHERE d.consecutive = :consecutive")
    , @NamedQuery(name = "Document.findByDocumentDate", query = "SELECT d FROM Document d WHERE d.documentDate = :documentDate")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "document_id")
    private Integer documentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consecutive")
    private int consecutive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date documentDate;
    @JoinColumn(name = "type_doc_Id", referencedColumnName = "type_doc_Id")
    @ManyToOne(optional = false)
    private TypeDoc typedocId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Collection<DocumentDetail> documentDetailCollection;

    public Document() {
    }

    public Document(Integer documentId) {
        this.documentId = documentId;
    }

    public Document(Integer documentId, int consecutive, Date documentDate) {
        this.documentId = documentId;
        this.consecutive = consecutive;
        this.documentDate = documentDate;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public int getConsecutive() {
        return consecutive;
    }

    public void setConsecutive(int consecutive) {
        this.consecutive = consecutive;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public TypeDoc getTypedocId() {
        return typedocId;
    }

    public void setTypedocId(TypeDoc typedocId) {
        this.typedocId = typedocId;
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
        hash += (documentId != null ? documentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.documentId == null && other.documentId != null) || (this.documentId != null && !this.documentId.equals(other.documentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Document[ documentId=" + documentId + " ]";
    }
    
    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("warehouse_proyectPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
}
