package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-06T14:15:42")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Date> horaFin;
    public static volatile SingularAttribute<Prestamo, String> estado;
    public static volatile SingularAttribute<Prestamo, Integer> idUsuario;
    public static volatile SingularAttribute<Prestamo, Date> fechaUso;
    public static volatile SingularAttribute<Prestamo, Integer> id;
    public static volatile SingularAttribute<Prestamo, Integer> idItem;
    public static volatile SingularAttribute<Prestamo, Date> horaInicio;

}