package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Document;
import logica.DocumentDetailPK;
import logica.Items;
import logica.Warehouses;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-06T14:15:42")
@StaticMetamodel(DocumentDetail.class)
public class DocumentDetail_ { 

    public static volatile SingularAttribute<DocumentDetail, Integer> quantity;
    public static volatile SingularAttribute<DocumentDetail, DocumentDetailPK> documentDetailPK;
    public static volatile SingularAttribute<DocumentDetail, Document> document;
    public static volatile SingularAttribute<DocumentDetail, Warehouses> warehouses;
    public static volatile SingularAttribute<DocumentDetail, Items> items;

}