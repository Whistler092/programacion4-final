/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author David Zuluaga
 */
public class DocumentDetail2 {
    private int DocumentDetailId;
    private DocumentDetail dd;
    private int tempw,tempi;

    public DocumentDetail2() {
    }

    public DocumentDetail getDd() {
        return dd;
    }

    public void setDd(DocumentDetail dd) {
        this.dd = dd;
    }

    public int getTempw() {
        return tempw;
    }

    public void setTempw(int tempw) {
        this.tempw = tempw;
    }

    public int getTempi() {
        return tempi;
    }

    public void setTempi(int tempi) {
        this.tempi = tempi;
    }

    public int getDocumentDetailId() {
        return DocumentDetailId;
    }

    public void setDocumentDetailId(int DocumentDetailId) {
        this.DocumentDetailId = DocumentDetailId;
    }
    
}
