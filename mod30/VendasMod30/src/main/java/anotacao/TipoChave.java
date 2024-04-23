package anotacao;

import java.lang.annotation.*;

/**
 * @author vitoria.vitoria
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
