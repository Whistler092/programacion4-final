/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.SelectItem;
import logica.Users;
import logica.UsersType;

/**
 *
 * @author java-ws
 */
@Named(value = "controllerUsers")
@Dependent
public class ControllerUsers {

    boolean isLogIn;
    Users ulogin;
    Users u;

    UsersType ut = new UsersType();
    int temput;
    List<UsersType> allut;
    List<Users> allu;

    SelectItem[] selectTypeUser;

    /**
     * Creates a new instance of ControllerUsers
     */
    public ControllerUsers() {
        isLogIn = false;
        ulogin = new Users();

    }

    public String loguinUser() {
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

    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }

    public UsersType getUt() {
        return ut;
    }

    public void setUt(UsersType ut) {
        this.ut = ut;
    }

    public int getTemput() {
        return temput;
    }

    public void setTemput(int temput) {
        this.temput = temput;
    }

    public List<UsersType> getAllut() {
        return allut;
    }

    public void setAllut(List<UsersType> allut) {
        this.allut = allut;
    }

    public List<Users> getAllu() {
        return allu;
    }

    public void setAllu(List<Users> allu) {
        this.allu = allu;
    }

    public SelectItem[] getSelectTypeUser() {
        return selectTypeUser;
    }

    public void setSelectTypeUser(SelectItem[] selectTypeUser) {
        this.selectTypeUser = selectTypeUser;
    }

}
