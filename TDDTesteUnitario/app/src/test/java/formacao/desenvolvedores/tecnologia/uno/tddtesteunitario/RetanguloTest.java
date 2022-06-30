package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest.Circunferencia;

public class RetanguloTest {
    private RetanguloTest retanguloTest = new RetanguloTest();

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){

        retanguloTest.deveriaTerUmLimiteDeTamanhoOVetorDeInformacoesDoCalculoDaArea();

    }

    @Test
    public void deveriaTerUmLimiteDeTamanhoOVetorDeInformacoesDoCalculoDaArea(){
        final int TAMANHO = 1;

        assertEquals(TAMANHO, retanguloTest);
    }

    @Test
    public void deveriaCalcularAreaDoRetangulo(){
        double base = 2;
        double altura = 3;

        double area = base * altura;

        double tamanhoDaArea = (base * altura);

        assertTrue(area);

    }

    private void assertTrue(double area) {
    }

    @Test
    public void deveriaCalcularOPerimetroDoRetangulo(){
        double base = 2;
        double altura = 3;

        double perimetro = 2 * (base + altura);

        double tamanhoDoPerimetro = (2*(base + altura));

        assertTrue(perimetro);
    }
}
