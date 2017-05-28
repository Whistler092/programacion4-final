/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import logica.Users;
import logica.UsersType;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerUsers")
@SessionScoped
public class ControllerUsers implements Serializable {
    Users u = new Users();
    Users ulogin = new Users();
    UsersType ut = new UsersType();
    UsersType temput = new UsersType();
    List<UsersType> allut;
    List<Users> allu;
    boolean isLogIn;
    SelectItem[] selectTypeUser;
    String name = "Users";
    /**
     * Creates a new instance of controllerUsers
     */
    public ControllerUsers() {
        this.listUserType();
        this.listUsers();
        this.selectTypeUser();
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

    public boolean isIsLogIn() {
        return isLogIn;
    }

    public void setIsLogIn(boolean isLogIn) {
        this.isLogIn = isLogIn;
    }

    public SelectItem[] getSelectTypeUser() {
        return selectTypeUser;
    }

    public void setSelectTypeUser(SelectItem[] selectTypeUser) {
        this.selectTypeUser = selectTypeUser;
    }

    public UsersType getTemput() {
        return temput;
    }

    public void setTemput(UsersType temput) {
        this.temput = temput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getUlogin() {
        return ulogin;
    }

    public void setUlogin(Users ulogin) {
        this.ulogin = ulogin;
    }
    
    
    
    public void selectTypeUser(){
        selectTypeUser = new SelectItem[allut.size()];
        
        for(int i = 0; i < allut.size();i++){
            UsersType utype = allut.get(i);
            selectTypeUser[i] = new SelectItem(utype.getCodeType(), utype.getNameType());
        }
    }
    
    public void listUserType(){
         EntityManager em = ut.getEntityManager();
        //Query tipado con el tipo de objeto a extraer
        TypedQuery<UsersType> consulusert = em.createNamedQuery("UsersType.findAll",UsersType.class);
         //captura de listado de la consulta
        allut = consulusert.getResultList();
    }
    public void listUsers(){
         EntityManager em = u.getEntityManager();
        //Query tipado con el tipo de objeto a extraer
        TypedQuery<Users> consuluser = em.createNamedQuery("Users.findAll",Users.class);
         //captura de listado de la consulta
        allu = consuluser.getResultList();
    }
    public String searchUsers(){
        String loginusers = "";
        int i = 1;
        if(u.getName() != null && u.getPasswordUser() != null){
            for (Users user : allu) {
                if(user.getName().trim().equals(u.getName().trim()) && user.getPasswordUser().equals(u.getPasswordUser())){
                    if(isLogIn){
                        u = user;
                        loginusers = "Users";
                    }
                    else{
                        ulogin = user;
                        isLogIn = true;
                        i = 3;
                        loginusers = "Login";
                        u = new Users();
                    }
                }
            }
        }
        return loginusers;
    }
}
