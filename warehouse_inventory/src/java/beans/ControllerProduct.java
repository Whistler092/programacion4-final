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

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerProduct")
@SessionScoped
public class ControllerProduct implements Serializable {
    Items i = new Items();
    List<Items> listitems;
    boolean disabled;
    String visibilityCreate = "inline",visibilityEdit = "none",visibilityUpdate = "none";
    String titulo = "Crear Producto";
    /**
     * Creates a new instance of controllerProduct
     */
    public ControllerProduct() {
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
    public void searchP(){
        titulo = "Buscar Producto";
        disabled = true;
        visibilityEdit = "inline";
        visibilityCreate = "none";
        visibilityUpdate = "none";
    }
    
    public void editproduct(){
        disabled = false;
        visibilityUpdate = "inline";
        visibilityCreate = "none";
        visibilityEdit = "none";
    }
    
    public void canceledit(){
        searchProduct();
        searchP();
    }
    
    public void additem()
    {
        i.setColor(0);
        i.setLot(0);
        i.setSize(0);
        EntityManager em = i.getEntityManager();
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        i = new Items();
    }
    public void searchProduct(){
        EntityManager em = i.getEntityManager();
        TypedQuery<Items> consultarProducto = em.createNamedQuery("Items.findByCode",Items.class);
        consultarProducto.setParameter("code",i.getCode());
        List<Items> productos = consultarProducto.getResultList();
        if(productos.size()>0){
            i = productos.get(0);
        }else{
            i = new Items();
        }
    }
    public void updateproduct(){
        //obtener el entitymanager
        EntityManager em = i.getEntityManager();
        //captura la transaccion realizada y la inicio
        em.getTransaction().begin();
        //guarda en la base de datos la entidad
        em.merge(i);
        //termina la transcaccion
        em.getTransaction().commit();
        //i = new Items();
        searchP();
    }
}
