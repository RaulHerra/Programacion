package mockExam;

import java.util.Set;

public class Boleto extends Combinacion {

	public Boleto(Set<Integer> numeros, Set<Integer> estrellas) throws CombinacionException {
		super(numeros, estrellas);
	}

	public Boleto(int num1, int num2, int num3, int num4, int num5, int estrella1, int estrella2)
			throws CombinacionException {
		super(num1, num2, num3, num4, num5, estrella1, estrella2);
	}

//No sé bien que hay que hacer en este método y en el enunciado no aparece
	@Override
	public int comprobarCombinacion(Combinacion combinacion) {
		return 0;
	}

}
