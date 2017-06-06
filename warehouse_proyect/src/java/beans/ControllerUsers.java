/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import logica.Users;

/**
 *
 * @author java-ws
 */
@Named(value = "controllerUsers")
@Dependent
public class ControllerUsers {

    boolean isLogIn;
    Users ulogin;

    /**
     * Creates a new instance of ControllerUsers
     */
    public ControllerUsers() {
        isLogIn = false;
        ulogin = new Users();
        
    }
    
    public String loguinUser(){
        setIsLogIn(true);
        return "views/users.xhtml";
    } 

    public boolean isIsLogIn() {
        return isLogIn;
    }

    public void setIsLogIn(boolean isLogIn) {
        this.isLogIn = isLogIn;
    }

    public Users getUlogin() {
        return ulogin;
    }

    public void setUlogin(Users ulogin) {
        this.ulogin = ulogin;
    }

    
}
