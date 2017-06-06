package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T13:51:48")
@StaticMetamodel(UsersType.class)
public class UsersType_ { 

    public static volatile SingularAttribute<UsersType, String> nameType;
    public static volatile SingularAttribute<UsersType, Integer> idusersType;
    public static volatile SingularAttribute<UsersType, String> codeType;
    public static volatile CollectionAttribute<UsersType, Users> usersCollection;

}