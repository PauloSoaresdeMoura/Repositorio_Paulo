package moura.soares.paulo.conceitosclassesabstratas;

import static java.lang.Math.*;

public class Circunferencia extends Forma {
	public Circunferencia(double raio) {
		super(1); // uso obrigat�rio do construtor da superclasse
		setRaio(raio); // ajuste da medida do raio
	}

	// implementa��o do m�todo abstrato area()
	@Override
	public double area() {
		return PI * Math.pow(getMedida(0), 2);
	}

	// novo m�todo para ajuste do raio
	public void setRaio(double raio) {
		setMedida(0, raio);
	}

	// Adi��o para exemplo 3.68
	// comparador est�tico
	public static int comparador(Circunferencia a, Circunferencia b) {
		return (int) (a.area() - b.area());
	}

	// comparador n�o-est�tico
	public int comparador2(Circunferencia b) {
		return (int) (this.area() - b.area());
	}
}
