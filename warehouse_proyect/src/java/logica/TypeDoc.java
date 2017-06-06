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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "type_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeDoc.findAll", query = "SELECT t FROM TypeDoc t")
    , @NamedQuery(name = "TypeDoc.findByTypedocId", query = "SELECT t FROM TypeDoc t WHERE t.typedocId = :typedocId")
    , @NamedQuery(name = "TypeDoc.findByCode", query = "SELECT t FROM TypeDoc t WHERE t.code = :code")
    , @NamedQuery(name = "TypeDoc.findByName", query = "SELECT t FROM TypeDoc t WHERE t.name = :name")})
public class TypeDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_doc_Id")
    private Integer typedocId;
    @Size(max = 4)
    @Column(name = "code")
    private String code;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typedocId")
    private Collection<Document> documentCollection;

    public TypeDoc() {
    }

    public TypeDoc(Integer typedocId) {
        this.typedocId = typedocId;
    }

    public Integer getTypedocId() {
        return typedocId;
    }

    public void setTypedocId(Integer typedocId) {
        this.typedocId = typedocId;
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

    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typedocId != null ? typedocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeDoc)) {
            return false;
        }
        TypeDoc other = (TypeDoc) object;
        if ((this.typedocId == null && other.typedocId != null) || (this.typedocId != null && !this.typedocId.equals(other.typedocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.TypeDoc[ typedocId=" + typedocId + " ]";
    }
    
}
