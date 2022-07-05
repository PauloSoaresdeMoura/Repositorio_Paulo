package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario;

import static org.junit.Assert.*;
import formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest.Retangulo;

import org.junit.Test;

public class RetanguloTest {
    private static final double DIFERENCA_ACEITAVEL = 0;
    private Retangulo retangulo                     = new Retangulo();

    @Test
    public void calcularAreaDoRetangulo(){
        double area_BaseXAltura    = 10;
        double DIFERENCA_ACEITAVEL = 0.0001;

        retangulo.setMedida(0, 5);
        retangulo.setMedida(1, 2);

        double area = retangulo.getMedida(0) * retangulo.getMedida(1);

        assertEquals("A area de uma de um retangulo: " + area_BaseXAltura, area_BaseXAltura,
                area, DIFERENCA_ACEITAVEL);

    }

    @Test
    public void calcularPerimetroRetangulo(){
        double perimetroCalculadoNoPapel              = 14.00;
        final int ARMAZENAR_BASE_NA_PRIMEIRA_POSICAO  = 0;
        final int ARMAZENAR_ALTURA_NA_SEGUNDA_POSICAO = 1;

        retangulo.setMedida(0, 5);
        retangulo.setMedida(1, 2);

        double perimetro = 2 * (retangulo.getMedida(ARMAZENAR_BASE_NA_PRIMEIRA_POSICAO)
                + retangulo.getMedida(ARMAZENAR_ALTURA_NA_SEGUNDA_POSICAO));

        assertEquals("O perimetro de calculo no papel é :" + perimetroCalculadoNoPapel
                , perimetroCalculadoNoPapel
                , perimetro
                , DIFERENCA_ACEITAVEL);
    }
}
