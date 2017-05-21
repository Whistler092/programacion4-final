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
 * @author David Zuluaga
 */
@Embeddable
public class UsersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users_id")
    private int usersId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusers_type")
    private int idusersType;

    public UsersPK() {
    }

    public UsersPK(int usersId, int idusersType) {
        this.usersId = usersId;
        this.idusersType = idusersType;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getIdusersType() {
        return idusersType;
    }

    public void setIdusersType(int idusersType) {
        this.idusersType = idusersType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usersId;
        hash += (int) idusersType;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPK)) {
            return false;
        }
        UsersPK other = (UsersPK) object;
        if (this.usersId != other.usersId) {
            return false;
        }
        if (this.idusersType != other.idusersType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.UsersPK[ usersId=" + usersId + ", idusersType=" + idusersType + " ]";
    }
    
}
