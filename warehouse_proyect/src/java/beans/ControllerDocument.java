/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import logica.Document;
import logica.DocumentDetail;
import logica.Items;
import logica.TypeDoc;
import logica.Warehouses;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerDocument")
@SessionScoped
public class ControllerDocument implements Serializable {

    SelectItem[] selectTypeDoc,selectTypeWarehouse,selectTypeItems;
    
    TypeDoc td =new TypeDoc();
    Warehouses w = new Warehouses();
    Items i = new Items();
    Document d = new Document();
    DocumentDetail dd = new DocumentDetail();
    
    List<TypeDoc> alltd;
    List<Warehouses> allw;
    List<Items> alli;
    List<Document> alld;
    List<DocumentDetail> alldd;
    
    int temptd,tempw;
    boolean disabled,concecutive = true;
    String visibilityCreate = "inline",visibilityEdit = "none",visibilityUpdate = "none";
    String title = "Crear Documento";
    
    /**
     * Creates a new instance of ControllerDocument
     */
    public ControllerDocument() {
        listTypeDoc();
        listWarehouse();
        listItems();
        selectTypeDoc();
        selectWarehouse();
        selectItems();
        ConsecutiveDocument();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public SelectItem[] getSelectTypeItems() {
        return selectTypeItems;
    }

    public void setSelectTypeItems(SelectItem[] selectTypeItems) {
        this.selectTypeItems = selectTypeItems;
    }
    
    public TypeDoc getTd() {
        return td;
    }

    public void setTd(TypeDoc td) {
        this.td = td;
    }

    public Warehouses getW() {
        return w;
    }

    public void setW(Warehouses w) {
        this.w = w;
    }

    public Items getI() {
        return i;
    }

    public void setI(Items i) {
        this.i = i;
    }

    public List<TypeDoc> getAlltd() {
        return alltd;
    }

    public void setAlltd(List<TypeDoc> alltd) {
        this.alltd = alltd;
    }

    public List<Warehouses> getAllw() {
        return allw;
    }

    public void setAllw(List<Warehouses> allw) {
        this.allw = allw;
    }

    public int getTemptd() {
        return temptd;
    }

    public void setTemptd(int temptd) {
        this.temptd = temptd;
    }

    public int getTempw() {
        return tempw;
    }

    public void setTempw(int tempw) {
        this.tempw = tempw;
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

    public Document getD() {
        return d;
    }

    public void setD(Document d) {
        this.d = d;
    }

    public DocumentDetail getDd() {
        return dd;
    }

    public void setDd(DocumentDetail dd) {
        this.dd = dd;
    }

    public List<Document> getAlld() {
        return alld;
    }

    public void setAlld(List<Document> alld) {
        this.alld = alld;
    }

    public List<DocumentDetail> getAlldd() {
        return alldd;
    }

    public void setAlldd(List<DocumentDetail> alldd) {
        this.alldd = alldd;
    }

    public boolean isConcecutive() {
        return concecutive;
    }

    public void setConcecutive(boolean concecutive) {
        this.concecutive = concecutive;
    }

    public List<Items> getAlli() {
        return alli;
    }

    public void setAlli(List<Items> alli) {
        this.alli = alli;
    }
    
    public void createD(){
        title = "Crear Usuario";
        disabled = false;
        visibilityEdit = "none";
        visibilityUpdate = "none";
        visibilityCreate = "inline";
        concecutive = true;
        d = new Document();
        
        ConsecutiveDocument();
    }
    
    public void searchD(){
        title = "Buscar Usuario";
        disabled = true;
        concecutive = false;
        visibilityCreate = "none";
        visibilityUpdate = "none";
        visibilityEdit = "inline";
    }
    
    public void editD(){
        disabled = false;
        concecutive = true;
        visibilityUpdate = "inline";
        visibilityCreate = "none";
        visibilityEdit = "none";
    }
    
    public void searchDocument(){
        EntityManager em = d.getEntityManager();
        TypedQuery<Document> consultDocument = em.createNamedQuery("Document.findByConsecutive",Document.class);
        consultDocument.setParameter("consecutive",d.getConsecutive());
        List<Document> document = consultDocument.getResultList();
        if(document.size()>0){
            d = document.get(0);
        }else{
            d = new Document();
        }
    }  
    public void ConsecutiveDocument(){
        EntityManager em = d.getEntityManager();
        TypedQuery<Document> consultDocument = em.createNamedQuery("Document.findAll",Document.class);
        alld = consultDocument.getResultList();
        d.setConsecutive(alld.size()+1);
    }
    
    public void listTypeDoc(){
         EntityManager em = td.getEntityManager();
        //Query tipado con el tipo de objeto a extraer
        TypedQuery<TypeDoc> consulusert = em.createNamedQuery("TypeDoc.findAll",TypeDoc.class);
         //captura de listado de la consulta
        alltd = consulusert.getResultList();
    }
    
    public void selectTypeDoc(){
        selectTypeDoc = new SelectItem[alltd.size()];
        
        for(int i = 0; i < alltd.size();i++){
            TypeDoc td1 = alltd.get(i);
            selectTypeDoc[i] = new SelectItem(td1.getTypedocId(),td1.getName());
        }
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
    
    public void listItems(){
         EntityManager em = i.getEntityManager();
        //Query tipado con el tipo de objeto a extraer
        TypedQuery<Items> consuli= em.createNamedQuery("Items.findAll",Items.class);
         //captura de listado de la consulta
        alli = consuli.getResultList();
    }
    
    public void selectWarehouse(){
        selectTypeWarehouse = new SelectItem[allw.size()];
        for(int i = 0; i < allw.size();i++){
            Warehouses w1 = allw.get(i);
            selectTypeWarehouse[i] = new SelectItem(w1.getWarehousesId(),w1.getName());
        }
    }
    public void selectItems(){
        selectTypeItems = new SelectItem[alli.size()];
        for(int i = 0; i < alli.size();i++){
            Items i1 = alli.get(i);
            selectTypeItems[i] = new SelectItem(i1.getItemId(),i1.getName());
        }
    }
    
    public void addDetails(){
        if(alldd == null)
            alldd = new ArrayList<DocumentDetail>();
        
        alldd.add(new DocumentDetail());
    }
    public void searchDetails(){
        EntityManager em = d.getEntityManager();
        TypedQuery<Document> consultDocument = em.createNamedQuery("Document.findByConsecutive",Document.class);
        consultDocument.setParameter("consecutive",d.getConsecutive());
        List<Document> document = consultDocument.getResultList();
    }
    public void deleteItem(){
        
    }
}
