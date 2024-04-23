
package anotacao;

import java.lang.annotation.*;

/**
 * @author vitoria.vitoria
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

	String value();
}
