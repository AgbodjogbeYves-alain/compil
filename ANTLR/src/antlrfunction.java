//Expression Arithmetiques
abstract class ExpressionArithm {
	
}

abstract class Constante extends ExpressionArithm{
	Constante p;
}

class integer extends Constante {
	
	int valeur;
	
	integer (int k) {
		valeur = k;
	}
}

class bool extends Constante {
	boolean valeur;
	
	bool (boolean bool) {
		valeur = bool;
	}
}
//Fin Constantes