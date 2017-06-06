package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.UsersType;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-06T14:15:42")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, UsersType> idusersType;
    public static volatile SingularAttribute<Users, Boolean> isActived;
    public static volatile SingularAttribute<Users, Integer> usersId;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, String> passwordUser;

}