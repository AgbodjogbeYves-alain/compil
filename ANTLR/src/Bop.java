
//Operateurs Binaires

abstract class Bop extends ExpressionArithm{
	ExpressionArithm express1, express2;
}

class Ajouter extends Bop {
	Ajouter(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
			express1 = exp1;
			express2 = exp2;
	}			
}
class Supprimer extends Bop {
	Supprimer(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class Multiplier extends Bop {
	Multiplier(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class Diviser extends Bop {
	Diviser(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class Et extends Bop {
	Et(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class Ou extends Bop {
	Ou(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class PlusPetit extends Bop {
	PlusPetit(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class PlusPetitEgal extends Bop {
	PlusPetitEgal(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class Egal extends Bop {
	Egal(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class PlusGrand extends Bop {
	PlusGrand(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class PlusGrandEgal extends Bop {
	PlusGrandEgal(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
class Different extends Bop {
	Different(ExpressionArithm exp1, ExpressionArithm exp2) 
	{
		express1 = exp1;
		express2 = exp2;
	}		
}
//Fin Operateurs Binaires

