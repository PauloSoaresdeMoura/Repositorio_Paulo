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
        double lado1 = 2;
        double lado2 = 3;
        double tamanhoDaArea = Math.(lado1 * lado2);


    }
}
