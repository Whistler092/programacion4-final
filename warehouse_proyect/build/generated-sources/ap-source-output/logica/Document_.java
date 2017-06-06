package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.DocumentDetail;
import logica.TypeDoc;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T15:04:34")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, Date> documentDate;
    public static volatile SingularAttribute<Document, TypeDoc> typedocId;
    public static volatile CollectionAttribute<Document, DocumentDetail> documentDetailCollection;
    public static volatile SingularAttribute<Document, Integer> documentId;
    public static volatile SingularAttribute<Document, Integer> consecutive;

}