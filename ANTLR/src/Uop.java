// Operateurs Unaires

abstract class Uop extends ExpressionArithm{
	ExpressionArithm express;
}
class Negatif extends Uop {
	Negatif(ExpressionArithm exp) 
	{
			express = exp;
	}		
}
class Inverse extends Uop {
	Inverse(ExpressionArithm exp) 
	{
			express = exp;

	}		
}
// Fin Operateurs Unaires

