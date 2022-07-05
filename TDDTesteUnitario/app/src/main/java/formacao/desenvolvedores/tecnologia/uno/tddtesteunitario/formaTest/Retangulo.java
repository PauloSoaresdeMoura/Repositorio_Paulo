package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest;

public class Retangulo extends Forma {
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA = 2;
    public static final int POSICAO_ZERO_BASE                = 0;
    private static final int POSICAO_UM_ALTURA               = 1;

    public Retangulo(){
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA);

    }

    @Override
    public double area(){

        return getMedida(POSICAO_ZERO_BASE) * getMedida(POSICAO_UM_ALTURA);
    }

}
