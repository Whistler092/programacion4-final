package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Users;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-06T14:15:42")
@StaticMetamodel(UsersType.class)
public class UsersType_ { 

    public static volatile SingularAttribute<UsersType, String> nameType;
    public static volatile SingularAttribute<UsersType, Integer> idusersType;
    public static volatile SingularAttribute<UsersType, String> codeType;
    public static volatile CollectionAttribute<UsersType, Users> usersCollection;

}