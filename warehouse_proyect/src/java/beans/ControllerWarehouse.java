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
import logica.Items;
import logica.Warehouses;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerWarehouse")
@SessionScoped
public class ControllerWarehouse implements Serializable {

    ControllerProperties cp = new ControllerProperties();
    Warehouses w = new Warehouses();
    List<Warehouses> listwarehouse;
    String name = "Warehouse";
    String titulo = "Crear Bodega";
    
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean newW(){
        w = new Warehouses();
        return true;
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
    public boolean updateWarehouse(){
        boolean terminate = false;
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
            terminate = true;
        } catch (Exception e) {
            
        }
        return terminate;
    }
    
    public boolean canceledit(){
        searchWarehouse();
        return true;
    }
}
