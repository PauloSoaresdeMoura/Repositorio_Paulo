package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario;

import org.junit.Test;
import static org.junit.Assert.*;

import formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest.Circunferencia;

public class CircunferenciaTest {
    private static final double PRECISAO_4_CASAS_DECIMAIS = 3;
    private final Circunferencia circunferencia = new Circunferencia();

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){

        //Posição ZERO porque se trata de circunferencia que precisa de apenas uma informação p/ calcular a área
        circunferencia.setMedida(0, 3);

        double raio = circunferencia.getMedida(0);

        boolean area = raio > 0;

        assertTrue(area);
    }

    @Test
    public void deveriaTerUmLimiteDeTamanhoOVetorDeInformacoesDoCalculoDaArea(){
        final int TAMANHO = 1;

        assertEquals(TAMANHO, circunferencia.getTamanhoArrayInfoCalculoArea());
    }

    @Test
    public void deveriaCalcularAreaDaCircunferencia(){
        final int POSICAO_ZERO = 0;
        final int EXPOENTE_2 = 2;

        /*Cálculos feitos no papel*/
        double area_raio5 = 78.5398;

        //Raio armazenado na estrutura de dados da classe Pai (Forma)
        circunferencia.setMedida(POSICAO_ZERO, 5);

        double area = Math.PI * Math.pow(circunferencia.getMedida(POSICAO_ZERO), EXPOENTE_2);

        assertEquals("A área de uma circunferencia de raio 3 é 28,2743"
                , area_raio5, area, PRECISAO_4_CASAS_DECIMAIS);
    }
}
