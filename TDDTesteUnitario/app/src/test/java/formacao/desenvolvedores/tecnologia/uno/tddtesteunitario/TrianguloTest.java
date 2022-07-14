package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest.Triangulo;

public class TrianguloTest {

    private static final int POSICAO_ZERO_TRIANGULO_LADO1 = 0;
    private static final int POSICAO_UM_TRIANGULO_LADO2   = 1;
    private static final int POSICAO_DOIS_TRIANGULO_LADO3 = 2;
    private static final double DIFERENCA_ACEITAVEL       = 3;
    private Triangulo triangulo;

    public TrianguloTest() {
    }

    @Before
    public void instanciarObjeto(){

        triangulo = new Triangulo();
    }

    @Test
    public void deveriaCalcularAreaDoTriangulo(){//L1=5, L2=7, L3=9

        //Lados (L1, L2, L3) do triangulo
        triangulo.setMedida(POSICAO_ZERO_TRIANGULO_LADO1, 5);
        triangulo.setMedida(POSICAO_UM_TRIANGULO_LADO2, 5);
        triangulo.setMedida(POSICAO_DOIS_TRIANGULO_LADO3, 5);

        double area = (triangulo.getMedida(POSICAO_ZERO_TRIANGULO_LADO1)
                + triangulo.getMedida(POSICAO_UM_TRIANGULO_LADO2)
                + triangulo.getMedida(POSICAO_DOIS_TRIANGULO_LADO3)) / 2;

        double perimetro = area * (area - triangulo.getMedida(POSICAO_ZERO_TRIANGULO_LADO1))
                * (area - triangulo.getMedida(POSICAO_UM_TRIANGULO_LADO2))
                * (area - triangulo.getMedida(POSICAO_DOIS_TRIANGULO_LADO3));

        double area1 = Math.sqrt(perimetro);

        double areaDoTrianguloCalculadaNoPapel = 10;

        assertEquals("A área calculada no papel é : " + areaDoTrianguloCalculadaNoPapel
                , areaDoTrianguloCalculadaNoPapel
                , area1
                , DIFERENCA_ACEITAVEL);
    }
}
