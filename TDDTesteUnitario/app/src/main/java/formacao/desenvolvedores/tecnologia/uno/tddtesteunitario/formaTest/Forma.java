package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest;

public abstract class Forma {
    private final double[] numeroDeMedida;

    public Forma(int numMedidas) {
        numeroDeMedida = new double[numMedidas];
    }

    public double getMedida(int posicao){

        int TAMANHO_MAXIMO = 3;
        if (posicao >= 0 && posicao < TAMANHO_MAXIMO){

            return numeroDeMedida[posicao];

        }else {
            throw new RuntimeException("Número inválido p/ calculo de área.");
        }
    }

    public void setMedida(int posicao, double medida){

        numeroDeMedida[posicao] = medida;
    }
}
