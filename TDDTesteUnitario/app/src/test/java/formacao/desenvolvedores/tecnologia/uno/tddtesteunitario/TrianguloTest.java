package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest.Triangulo;

public class TrianguloTest {
    private boolean area;

    private Triangulo triangulo;
    public TrianguloTest() {

    }

    @Before
    public void instanciarObjeto(){
        triangulo = new Triangulo();
    }

    @Test
    public void deveriaSomarOsLadosDoTriangulo() {
        double lado1     = l1;
        double lado2     = l2;
        double lado3     = l3;
        double somaLados = 43;
    }

    @Test
    public void calcularAreaDoTriangulo(){
        double somaLados  = 43 / 2;
    }
}
