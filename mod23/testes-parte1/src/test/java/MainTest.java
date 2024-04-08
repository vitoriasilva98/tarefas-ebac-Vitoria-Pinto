import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    @Test
    public void testDeNomesFemininos() {
        String listaDeNomesEGeneros = "Ana-F, Pedro-M, Maria-F, Larissa-F, Mariana-F, João-M, Luís-M, Bruno-M, Jesus-M, Beatriz-F";

        String[] nomesEhGeneroSeparadosPorVirgula = listaDeNomesEGeneros.split(",");

        List<String> listaFemininaComGenero = Arrays.stream(nomesEhGeneroSeparadosPorVirgula).filter(nomesEGeneros -> nomesEGeneros.contains("-F")).collect(Collectors.toList());

        List<String> listaFemininaSemGenero = listaFemininaComGenero.stream().map(nome -> nome.replace("-F", "")).collect(Collectors.toList());

        assertEquals(Arrays.asList("Ana",  "Maria",  "Larissa",  "Mariana",  "Beatriz"), listaFemininaSemGenero);
    }
}
