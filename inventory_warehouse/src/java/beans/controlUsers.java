/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import logica.Users;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controlUsers")
@SessionScoped
public class controlUsers implements Serializable {

    Users u = new Users();
    List<Users> listUsers;
    /**
     * Creates a new instance of controlUsers
     */
    public controlUsers() {
    }

    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }

    public List<Users> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Users> listUsers) {
        this.listUsers = listUsers;
    }
    
    
    
}
