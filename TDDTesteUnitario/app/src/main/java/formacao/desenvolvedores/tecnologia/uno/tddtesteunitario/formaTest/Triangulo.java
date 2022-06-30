package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest;

public class Triangulo extends Forma{
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA = 1;

    public Triangulo(){
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA);

    }

    @Override
    public double area(){

        return 0;
    }

    public int getTamanhoArrayInfoCalculoArea(){
        return TAMANHO_ARRAY_INFO_CALCULO_AREA;
    }

}
