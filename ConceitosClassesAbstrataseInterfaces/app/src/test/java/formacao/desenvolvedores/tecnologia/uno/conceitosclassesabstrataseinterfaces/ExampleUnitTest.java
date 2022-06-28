package formacao.desenvolvedores.tecnologia.uno.conceitosclassesabstrataseinterfaces;

import org.junit.Test;

import static org.junit.Assert.*;

import formacao.desenvolvedores.tecnologia.uno.conceitosclassesabstrataseinterfaces.formas.Circunferencia;
import formacao.desenvolvedores.tecnologia.uno.conceitosclassesabstrataseinterfaces.formas.Retangulo;
import formacao.desenvolvedores.tecnologia.uno.conceitosclassesabstrataseinterfaces.formas.Triangulo;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        assertEquals(4, 2 + 2);

    }

    //valida se o tamanho da area do triangulo é maior que zero, ou seja um valor positivo
    @Test
    public void areaTrianguloTest(){

        Triangulo triangulo = new Triangulo(5, 6, 7);
        boolean x = triangulo.area() > 0;
        assertTrue(x);

    }

    @Test
    public void areaCircunferenciaTest(){

        Circunferencia circunferencia = new Circunferencia( 7);
        boolean x = circunferencia.area() > 0;
        assertTrue(x);

    }

    @Test
    public void areaRetanguloTest(){

        Retangulo retangulo = new Retangulo(6, 7);
        boolean x = retangulo.area() > 0;
        assertTrue(x);

    }
}