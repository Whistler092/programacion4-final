/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David Zuluaga
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUsersId", query = "SELECT u FROM Users u WHERE u.usersPK.usersId = :usersId")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
    , @NamedQuery(name = "Users.findByPasswordUser", query = "SELECT u FROM Users u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "Users.findByIdusersType", query = "SELECT u FROM Users u WHERE u.usersPK.idusersType = :idusersType")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersPK usersPK;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "password_user")
    private String passwordUser;
    @JoinColumn(name = "idusers_type", referencedColumnName = "idusers_type", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UsersType usersType;

    public Users() {
    }

    public Users(UsersPK usersPK) {
        this.usersPK = usersPK;
    }

    public Users(int usersId, int idusersType) {
        this.usersPK = new UsersPK(usersId, idusersType);
    }

    public UsersPK getUsersPK() {
        return usersPK;
    }

    public void setUsersPK(UsersPK usersPK) {
        this.usersPK = usersPK;
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

    public UsersType getUsersType() {
        return usersType;
    }

    public void setUsersType(UsersType usersType) {
        this.usersType = usersType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersPK != null ? usersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usersPK == null && other.usersPK != null) || (this.usersPK != null && !this.usersPK.equals(other.usersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Users[ usersPK=" + usersPK + " ]";
    }
    
}
