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
public class controllerUsers implements Serializable {
    Users u = new Users();
    UsersType ut = new UsersType();
    List<UsersType> allut;
    List<Users> allu;
    boolean isLogIn;
    options o = new options();
    /**
     * Creates a new instance of controllerUsers
     */
    public controllerUsers() {
        this.listUserType();
        this.listUsers();
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
    public int searchUsers(){
        int i = 1;
        if(u.getName() != null && u.getPasswordUser() != null){
            for (Users user : allu) {
                if(user.getName().trim().equals(u.getName().trim()) && user.getPasswordUser().equals(u.getPasswordUser())){
                    u = user;
                    i = 3;
                }
            }
        }
        return i;
    }
}
