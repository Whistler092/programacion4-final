package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.DocumentDetail;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T15:07:19")
@StaticMetamodel(Warehouses.class)
public class Warehouses_ { 

    public static volatile SingularAttribute<Warehouses, Integer> warehousesId;
    public static volatile SingularAttribute<Warehouses, String> code;
    public static volatile CollectionAttribute<Warehouses, DocumentDetail> documentDetailCollection;
    public static volatile SingularAttribute<Warehouses, Boolean> isActived;
    public static volatile SingularAttribute<Warehouses, String> name;

}