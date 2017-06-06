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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author java-ws
 */
@Entity
@Table(name = "users_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersType.findAll", query = "SELECT u FROM UsersType u")
    , @NamedQuery(name = "UsersType.findByIdusersType", query = "SELECT u FROM UsersType u WHERE u.idusersType = :idusersType")
    , @NamedQuery(name = "UsersType.findByNameType", query = "SELECT u FROM UsersType u WHERE u.nameType = :nameType")
    , @NamedQuery(name = "UsersType.findByCodeType", query = "SELECT u FROM UsersType u WHERE u.codeType = :codeType")})
public class UsersType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusers_type")
    private Integer idusersType;
    @Size(max = 45)
    @Column(name = "name_type")
    private String nameType;
    @Size(max = 2)
    @Column(name = "code_type")
    private String codeType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusersType")
    private Collection<Users> usersCollection;

    public UsersType() {
    }

    public UsersType(Integer idusersType) {
        this.idusersType = idusersType;
    }

    public Integer getIdusersType() {
        return idusersType;
    }

    public void setIdusersType(Integer idusersType) {
        this.idusersType = idusersType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusersType != null ? idusersType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersType)) {
            return false;
        }
        UsersType other = (UsersType) object;
        if ((this.idusersType == null && other.idusersType != null) || (this.idusersType != null && !this.idusersType.equals(other.idusersType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.UsersType[ idusersType=" + idusersType + " ]";
    }
    
}
