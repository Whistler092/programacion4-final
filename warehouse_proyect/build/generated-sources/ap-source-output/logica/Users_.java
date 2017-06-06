package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.UsersType;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T15:07:19")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, UsersType> idusersType;
    public static volatile SingularAttribute<Users, Boolean> isActived;
    public static volatile SingularAttribute<Users, Integer> usersId;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, String> passwordUser;

}