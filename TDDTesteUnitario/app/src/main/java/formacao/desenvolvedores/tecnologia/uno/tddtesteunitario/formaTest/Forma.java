package formacao.desenvolvedores.tecnologia.uno.tddtesteunitario.formaTest;

public abstract class Forma {
    private double[] numeroDeMedida;
    private int TAMANHO_MAXIMO = 3;

    public Forma(int numMedidas) {
        numeroDeMedida = new double[][numMedidas];
    }

    public double getMedida(int i){

        if (i > 0 && i <= TAMANHO_MAXIMO){

            return numeroDeMedida[i];

        }else {
            throw new RuntimeException("Número inválido p/ calculo de área.");

        }
    }

    public void setMedida(int posicao, double medida){
        numeroDeMedida[posicao] = medida;
    }

    public abstract double area();

}
