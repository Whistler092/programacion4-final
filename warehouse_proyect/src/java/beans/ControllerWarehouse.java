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
import logica.Warehouses;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerWarehouse")
@SessionScoped
public class ControllerWarehouse implements Serializable {

    Warehouses w = new Warehouses();
    List<Warehouses> listwarehouse;
    String name = "Warehouse";
    String title = "Crear Bodega";
    boolean disabled;
    String visibilityCreate = "inline",visibilityEdit = "none",visibilityUpdate = "none";
    
    /**
     * Creates a new instance of controllerWarehouse
     */
    public ControllerWarehouse() {
    }

    public Warehouses getW() {
        return w;
    }

    public void setW(Warehouses w) {
        this.w = w;
    }

    public List<Warehouses> getListwarehouse() {
        return listwarehouse;
    }

    public void setListwarehouse(List<Warehouses> listwarehouse) {
        this.listwarehouse = listwarehouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getVisibilityCreate() {
        return visibilityCreate;
    }

    public void setVisibilityCreate(String visibilityCreate) {
        this.visibilityCreate = visibilityCreate;
    }

    public String getVisibilityEdit() {
        return visibilityEdit;
    }

    public void setVisibilityEdit(String visibilityEdit) {
        this.visibilityEdit = visibilityEdit;
    }

    public String getVisibilityUpdate() {
        return visibilityUpdate;
    }

    public void setVisibilityUpdate(String visibilityUpdate) {
        this.visibilityUpdate = visibilityUpdate;
    }
    
    public void createW(){
        title = "Crear Usuario";
        disabled = false;
        visibilityEdit = "none";
        visibilityUpdate = "none";
        visibilityCreate = "inline";
        w = new Warehouses();
    }
    
    public void searchW(){
            title = "Buscar Usuario";
            disabled = true;
            visibilityEdit = "inline";
            visibilityCreate = "none";
            visibilityUpdate = "none";
    }
    
    public void editW(){
        disabled = false;
        visibilityUpdate = "inline";
        visibilityCreate = "none";
        visibilityEdit = "none";
    }
        
    public void additem()
    {
        EntityManager em = w.getEntityManager();
        em.getTransaction().begin();
        em.persist(w);
        em.getTransaction().commit();
        w = new Warehouses();
    }
    public void searchWarehouse(){
        EntityManager em = w.getEntityManager();
        TypedQuery<Warehouses> consultwarehouse = em.createNamedQuery("Warehouses.findByCode",Warehouses.class);
        consultwarehouse.setParameter("code",w.getCode());
        List<Warehouses> warehouse = consultwarehouse.getResultList();
        if(warehouse.size()>0){
            w = warehouse.get(0);
        }else{
            w = new Warehouses();
        }
    }
    public void updateWarehouse(){
        try {
            //obtener el entitymanager
            EntityManager em = w.getEntityManager();
            //captura la transaccion realizada y la inicio
            em.getTransaction().begin();
            //guarda en la base de datos la entidad
            em.merge(w);
            //termina la transcaccion
            em.getTransaction().commit();
            //i = new Items();
            //searchW();
        } catch (Exception e) {
            
        }
        searchW();
    }
    
    public void canceledit(){
        searchWarehouse();
        searchW();
    }
}
