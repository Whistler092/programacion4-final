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
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import logica.Document;
import logica.DocumentDetail;
import logica.Items;
import logica.Products;

/**
 *
 * @author java-ws
 */
@Named(value = "controllerReports")
@SessionScoped
public class ControllerReports implements Serializable {

    List<Items> ListItems;
    List<Products> ListProducts;
    List<Products> ListMoreProducts;

    /**
     * Creates a new instance of ControllerReports
     */
    public ControllerReports() {
        ListProducts = new ArrayList<Products>();
        ListItems = new ArrayList<Items>();
        //loadAllProducts();
    }

    public void loadLess() {

    }

    public void loadMore() {
        List<DocumentDetail> ListDocumentDetail = new ArrayList<DocumentDetail>();

        Items it = new Items();
        EntityManager em = it.getEntityManager();
        TypedQuery<DocumentDetail> consultItems = em.createNamedQuery("DocumentDetail.findAll", DocumentDetail.class);
        ListDocumentDetail = consultItems.getResultList();

        ListProducts = new ArrayList<Products>();
        ListMoreProducts = new ArrayList<Products>();

        for (DocumentDetail selectedItem : ListDocumentDetail) {
            Products newProduct = new Products();

            newProduct.setArticulo(selectedItem.getItemId().getName());

            Products alreadyItem = findInListMoreProducts(newProduct.getArticulo());
            if (alreadyItem == null) {
                if (selectedItem.getDocumentId().getTypedocId().getCode().equals("1")) {
                    newProduct.setEntradas(selectedItem.getQuantity());
                } else {
                    newProduct.setSallidas(selectedItem.getQuantity());

                }
                ListMoreProducts.add(newProduct);
            } else {
                if (selectedItem.getDocumentId().getTypedocId().getCode().equals("1")) {
                    alreadyItem.setEntradas(alreadyItem.getEntradas() + selectedItem.getQuantity());
                } else {
                    alreadyItem.setSallidas(alreadyItem.getSallidas() + selectedItem.getQuantity());
                }
            }
        }
        SumMoreProducts();
    }

    public Products findInListMoreProducts(String articulo) {

        for (Products selectedItem : ListMoreProducts) {
            if (selectedItem.getArticulo().equals(articulo)) {
                return selectedItem;
            }
        }
        return null;
    }

    public void SumMoreProducts() {
        for (Products selectedItem : ListMoreProducts) {
            selectedItem.setTotal((selectedItem.getEntradas() != null ? selectedItem.getEntradas() : 0)- (selectedItem.getSallidas() != null ? selectedItem.getSallidas() : 0
        
    

    ));
        }
    }

    public void loadAll() {

        List<DocumentDetail> ListDocumentDetail = new ArrayList<DocumentDetail>();

        Items it = new Items();
        EntityManager em = it.getEntityManager();
        TypedQuery<DocumentDetail> consultItems = em.createNamedQuery("DocumentDetail.findAll", DocumentDetail.class);
        ListDocumentDetail = consultItems.getResultList();

        ListProducts = new ArrayList<Products>();

        for (DocumentDetail selectedItem : ListDocumentDetail) {
            Products newProduct = new Products();
            newProduct.setArticulo(selectedItem.getItemId().getName());
            newProduct.setBodega(selectedItem.getWarehousesId().getName());
            if (selectedItem.getDocumentId().getTypedocId().getCode().equals("1")) {
                newProduct.setEntradas(selectedItem.getQuantity());
            } else {
                newProduct.setSallidas(selectedItem.getQuantity());

            }
            newProduct.setFecha(selectedItem.getDocumentId().getDocumentDate().toString());
            newProduct.setConsecutivo(selectedItem.getDocumentId().getConsecutive() + "");
            ListProducts.add(newProduct);
        }
    }

    public List<Items> getListItems() {
        return ListItems;
    }

    public void setListItems(List<Items> ListItems) {
        this.ListItems = ListItems;
    }

    public List<Products> getListProducts() {
        return ListProducts;
    }

    public void setListProducts(List<Products> ListProducts) {
        this.ListProducts = ListProducts;
    }

    public List<Products> getListMoreProducts() {
        return ListMoreProducts;
    }

    public void setListMoreProducts(List<Products> ListMoreProducts) {
        this.ListMoreProducts = ListMoreProducts;
    }

}
