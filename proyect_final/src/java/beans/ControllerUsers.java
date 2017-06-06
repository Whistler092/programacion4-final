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
    int temput;
    List<UsersType> allut;
    List<Users> allu;
    
    SelectItem[] selectTypeUser;
    boolean isLogIn;
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

    public int getTemput() {
        return temput;
    }

    public void setTemput(int temput) {
        this.temput = temput;
    }
    
    
    
    public void selectTypeUser(){
        selectTypeUser = new SelectItem[allut.size()];
        
        for(int i = 0; i < allut.size();i++){
            UsersType utype = allut.get(i);
            selectTypeUser[i] = new SelectItem(utype.getIdusersType(), utype.getNameType());
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
        listUsers();
        String loginusers = "";
        if(u.getName() != null){
            for (Users user : allu) {
                if(isLogIn && u.getName() != null && u.getName().toString().equals(user.getName().toString())){
                    //u = user;
                    u.setIsActived(user.getIsActived());
                    u.setPasswordUser(user.getPasswordUser());
                    u.setIdusersType(user.getIdusersType());
                    temput = u.getIdusersType().getIdusersType();
                    loginusers = "views/users/users.xhtml";
                }
                else if(user.getName().trim().equals(u.getName().trim()) && u.getPasswordUser() != null && user.getPasswordUser().equals(u.getPasswordUser())){
                    ulogin = user;
                    isLogIn = true;
                    loginusers = "Login";
                    u = new Users();
                    break;
                }
            }
        }
        return loginusers;
    }
    
    public boolean newU(){
        u = new Users();
        return true;
    }
    
    public void addUsers()
    {
        for(int i = 0; i < allut.size(); i++){
            if(allut.get(i).getIdusersType() == temput){
                u.setIdusersType(allut.get(i));
            }
        }
        EntityManager em = u.getEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        u = new Users();
        listUsers();
    }
    /*public void searchUsers(){
        EntityManager em = u.getEntityManager();
        TypedQuery<Users> consultwarehouse = em.createNamedQuery("Warehouses.findByCode",Users.class);
        consultwarehouse.setParameter("code",u.getName());
        List<Users> user = consultwarehouse.getResultList();
        if(user.size()>0){
            u = user.get(0);
        }else{
            u = new Users();
        }
    }*/
    public boolean updateUsers(){
        boolean terminate = false;
        
        if("".equals(u.getPasswordUser())){
            for (Users user : allu) {
                if(isLogIn && u.getName()!= null && u.getName().toString().equals(user.getName().toString())){
                    u.setPasswordUser(user.getPasswordUser());
                    u.setUsersId(user.getUsersId());
                }
            }
        }
        
        for(int i = 0; i < allut.size(); i++){
            if(allut.get(i).getIdusersType() == temput){
                u.setIdusersType(allut.get(i));
            }
        }
        try {
            //obtener el entitymanager
            EntityManager em = u.getEntityManager();
            //captura la transaccion realizada y la inicio
            em.getTransaction().begin();
            //guarda en la base de datos la entidad
            em.merge(u);
            //termina la transcaccion
            em.getTransaction().commit();
            //i = new Items();
            //searchW();
            terminate = true;
        } catch (Exception e) {
            
        }
        listUsers();
        return terminate;
    }
    
    public boolean canceledit(){
        searchUsers();
        return true;
    }
}
