package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Document;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T15:07:19")
@StaticMetamodel(TypeDoc.class)
public class TypeDoc_ { 

    public static volatile SingularAttribute<TypeDoc, Integer> typedocId;
    public static volatile SingularAttribute<TypeDoc, String> code;
    public static volatile SingularAttribute<TypeDoc, String> name;
    public static volatile CollectionAttribute<TypeDoc, Document> documentCollection;

}