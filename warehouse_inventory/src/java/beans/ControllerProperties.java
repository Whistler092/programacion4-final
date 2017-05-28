/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controllerProperties")
@SessionScoped
public class ControllerProperties implements Serializable {

    int option;
    String name,move;
    String create,search,title,phcode,phname,phprice;
    boolean disabled;
    String visibilityCreate = "inline",visibilityEdit = "none",visibilityUpdate = "none";
    /**
     * Creates a new instance of ControllerProperties
     */
    public ControllerProperties() {
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhcode() {
        return phcode;
    }

    public void setPhcode(String phcode) {
        this.phcode = phcode;
    }

    public String getPhname() {
        return phname;
    }

    public void setPhname(String phname) {
        this.phname = phname;
    }

    public String getPhprice() {
        return phprice;
    }

    public void setPhprice(String phprice) {
        this.phprice = phprice;
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
    
    
    
    public int moveProperties(String move){
        int opt = 0;
        switch (move){
            case "Login":
                moveP("Usuario");
                opt = 5;
                break;
            case "Product":
                moveP("Producto");
                opt = 3;
                break;
            case "Warehouse":
                moveP("Bodega");
                opt = 4;
                break;
            case "Users":
                moveP("Usuario");
                opt = 5;
                break;
            default :
                break;
        }
        return opt;
    }
    
    private void moveP(String move){
        name = move;
        create = "Crear "+move;
        search = "Buscar "+move;
        title = create;
        phcode = "Digitar codigo de "+move;
        phname = "Digitar nombre de "+move;
        phprice = "Digitar Precio de "+move;
    }
    
     
    public void createM(boolean terminate){
        if(terminate){
            title = create;
            disabled = false;
            visibilityEdit = "none";
            visibilityUpdate = "none";
            visibilityCreate = "inline";
        }
    }
    
    public void searchM(boolean terminate){
        if(terminate){
            title = search;
            disabled = true;
            visibilityEdit = "inline";
            visibilityCreate = "none";
            visibilityUpdate = "none";
        }
    }
    
    public void editM(){
        disabled = false;
        visibilityUpdate = "inline";
        visibilityCreate = "none";
        visibilityEdit = "none";
    }
}
