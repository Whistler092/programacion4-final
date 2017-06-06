package logica;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.DocumentDetail;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-05T23:11:03")
@StaticMetamodel(Items.class)
public class Items_ { 

    public static volatile SingularAttribute<Items, Integer> lot;
    public static volatile SingularAttribute<Items, Integer> itemId;
    public static volatile SingularAttribute<Items, String> code;
    public static volatile CollectionAttribute<Items, DocumentDetail> documentDetailCollection;
    public static volatile SingularAttribute<Items, Integer> color;
    public static volatile SingularAttribute<Items, Integer> size;
    public static volatile SingularAttribute<Items, Boolean> isActived;
    public static volatile SingularAttribute<Items, BigDecimal> price;
    public static volatile SingularAttribute<Items, String> name;

}