/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import logica.Items;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "controlProduct")
@Dependent
public class controlProduct {

    Items i = new Items();
    List<Items> listitems;
    /**
     * Creates a new instance of controlProduct
     */
    public controlProduct() {
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
    
}
