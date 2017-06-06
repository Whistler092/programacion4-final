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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author java-ws
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUsersId", query = "SELECT u FROM Users u WHERE u.usersId = :usersId")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
    , @NamedQuery(name = "Users.findByPasswordUser", query = "SELECT u FROM Users u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "Users.findByIsActived", query = "SELECT u FROM Users u WHERE u.isActived = :isActived")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "users_id")
    private Integer usersId;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "password_user")
    private String passwordUser;
    @Column(name = "isActived")
    private Boolean isActived;
    @JoinColumn(name = "idusers_type", referencedColumnName = "idusers_type")
    @ManyToOne(optional = false)
    private UsersType idusersType;

    public Users() {
    }

    public Users(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Boolean getIsActived() {
        return isActived;
    }

    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    public UsersType getIdusersType() {
        return idusersType;
    }

    public void setIdusersType(UsersType idusersType) {
        this.idusersType = idusersType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersId != null ? usersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usersId == null && other.usersId != null) || (this.usersId != null && !this.usersId.equals(other.usersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Users[ usersId=" + usersId + " ]";
    }
    
    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("warehouse_proyectPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
}
