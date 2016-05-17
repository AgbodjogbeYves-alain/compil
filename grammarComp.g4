grammar grammarComp;

expr: additionExpr;

additionExpr: multiplyExpr('+' multiplyExpr | '-' multiplyExpr)* ;

multiplyExpr: atomExpr ('*' atomExpr | '/' atomExpr)* ;

logicExpr: 'and' | 'or' ; 

compExpr: '<' | '<=' | '=' | '!=' | '>=' | '>' ;

atomExpr: Number 
		  |'(' additionExpr  ')'
		  |'-' atomExpr ;

T: 'integer'| 'boolean' | Array;

K: Number | Boolean;

uop: '-' expr | 'not' Boolean;

Array: 'array of' T;

Boolean: 'true' | 'false';
// Le number est un integer

Number:('0'..'9')+;
//Les espaces, sauts de ligne et tabulations sont ignorés

bop: '+' | '-' | '*' | '/' | logicExpr | compExpr;

Phi: 'read' | 'write' | X;

X: [a-z]+ ;

e: K | X | uop e | e bop e | Phi'('e*')' | e'['e']' | 'new' Array'['e']';

i: X '=' e | e'['e']=' e | 'if' e 'then' i 'else' i | 'while' e 'do' i | Phi'('e*')' | 'skip' | i';'i ;

param: X ':' T;

// ? signifie qu'il y a un retour vide ou avec un type
d: X'('param*')'
	|'var' param*
	|i;
	
p: d*
   |i
   |'var' '('param*')';

WS : [ \t\r\n]+ -> skip;
