package moura.soares.paulo.conceitosclassesabstratas;

public class Retangulo extends Forma {
	public Retangulo(double altura, double largura) {
		super(2); // uso obrigat�rio do construtor da superclasse
		setMedida(0, altura); // ajuste da medida da altura
		setMedida(1, largura); // ajuste da medida da largura
	}

	// implementa��o do m�todo abstrato area()
	@Override
	public double area() {
		return getMedida(0) * getMedida(1);
	}

	// implementa��o de opera��o espec�fica extra
	public double perimetro() {
		return 2 * (getMedida(0) + getMedida(1));
	}
}
