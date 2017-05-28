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
@Named(value = "options")
@SessionScoped
public class Options implements Serializable {
    private int option;
    //Variables Url una para saber en que pantalla esta y la otra es para las Opciones de algun Menu
    private String url,urloption;
    /**
     * Creates a new instance of options
     */
    public Options() {
        this.setUrlOption(1);
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrloption() {
        return urloption;
    }

    public void setUrloption(String urloption) {
        this.urloption = urloption;
    }
    
    public void setUrlOption(int option){
        
        switch (option){
            case 1 :
                url = "view/session/session.xhtml";
                break;
            case 3 :
                url = "view/product/addProduct.xhtml";
                break;
            case 4 :
                url = "view/warehouse/addWarehouse.xhtml";
                break;
            case 5 :
                url = "view/users/users.xhtml";
                break;
            case 6 :
                url = "view/listusers.xhtml";
                break;
            
            default :
                url = "view/main.xhtml";
                break;
        }
    } 
}
