package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario;

import org.junit.Test;
import static org.junit.Assert.*;

import formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest.Circunferencia;

public class CircunferenciaTest {
    public static Circunferencia circunferencia = new Circunferencia(1);

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){

        //Posição ZERO porque se trata de circunferencia que precisa de apenas uma informação p/ calcular a área
        Circunferencia circunferencia = new Circunferencia(3);
        Circunferencia.setMedidas(0, 3);

        double raio = circunferencia.getMedida(0);

        boolean area = raio > 0;

        assertTrue(area);
    }

    @Test
    public void deveriaTerUmLimiteDeTamanhoOVetorDeInformacoesDoCalculoDaArea(){
        boolean tamanhoValido = circunferencia.setMedida(0, 3) > circunferencia;
    }

}
