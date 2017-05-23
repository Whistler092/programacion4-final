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
import logica.Items;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerProduct")
@SessionScoped
public class controllerProduct implements Serializable {
Items i = new Items();
    List<Items> listitems;
    boolean disabled;
    String visibilityCreate = "inline",visibilityEdit = "none",visibilityUpdate = "none";
    String titulo = "Crear Producto";
    /**
     * Creates a new instance of controllerProduct
     */
    public controllerProduct() {
    }

    public Items getI() {
        return i;
    }

    public void setI(Items i) {
        this.i = i;
    }

    public List<Items> getListitems() {
        return listitems;
    }

    public void setListitems(List<Items> listitems) {
        this.listitems = listitems;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void crearP(){
        titulo = "Crear Producto";
        disabled = false;
        visibilityEdit = "none";
        visibilityUpdate = "none";
        visibilityCreate = "inline";
        i = new Items();
    }
    public void buscarP(){
        titulo = "Buscar Producto";
        disabled = true;
        visibilityEdit = "inline";
        visibilityCreate = "none";
        visibilityUpdate = "none";
    }
    
   
    public void additem(){
        i.setColor(0);
        i.setLot(0);
        i.setSize(0);
        EntityManager em = i.getEntityManager();
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        i = new Items();
    }
}
