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
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import logica.TypeDoc;
import logica.Warehouses;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerDocument")
@SessionScoped
public class ControllerDocument implements Serializable {

    SelectItem[] selectTypeDoc,selectTypeWarehouse;
    TypeDoc td =new TypeDoc();
    Warehouses w = new Warehouses();
    List<TypeDoc> alltd;
    List<Warehouses> allw;
    int temptd,tempw;
    /**
     * Creates a new instance of ControllerDocument
     */
    public ControllerDocument() {
        listTypeDoc();
        listWarehouse();
    }

    public SelectItem[] getSelectTypeDoc() {
        return selectTypeDoc;
    }

    public void setSelectTypeDoc(SelectItem[] selectTypeDoc) {
        this.selectTypeDoc = selectTypeDoc;
    }

    public SelectItem[] getSelectTypeWarehouse() {
        return selectTypeWarehouse;
    }

    public void setSelectTypeWarehouse(SelectItem[] selectTypeWarehouse) {
        this.selectTypeWarehouse = selectTypeWarehouse;
    }
    
    public void listTypeDoc(){
         EntityManager em = td.getEntityManager();
        //Query tipado con el tipo de objeto a extraer
        TypedQuery<TypeDoc> consulusert = em.createNamedQuery("UsersType.findAll",TypeDoc.class);
         //captura de listado de la consulta
        alltd = consulusert.getResultList();
    }
    
    public void selectTypeUser(){
        selectTypeDoc = new SelectItem[alltd.size()];
        
        for(int i = 0; i < alltd.size();i++){
            TypeDoc td1 = alltd.get(i);
            selectTypeDoc[i] = new SelectItem(td1.getTypedocId(),td1.getName());
        }
    }
    
    public void listWarehouse(){
         EntityManager em = w.getEntityManager();
        //Query tipado con el tipo de objeto a extraer
        TypedQuery<Warehouses> consulusert = em.createNamedQuery("Warehouses.findAll",Warehouses.class);
         //captura de listado de la consulta
        allw = consulusert.getResultList();
    }
    
    public void selectWarehouse(){
        selectTypeWarehouse = new SelectItem[allw.size()];
        
        for(int i = 0; i < allw.size();i++){
            Warehouses w1 = allw.get(i);
            selectTypeWarehouse[i] = new SelectItem(w1.getWarehousesId(),w1.getName());
        }
    }
}
