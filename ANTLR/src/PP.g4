grammar PP;

E_VAR : 'var' ;
E_DEF : 'def' ;
E_P_GAUCHE : '(' ;
E_P_DROITE : ')' ;
E_DEB_BLOCK : '{' ;
E_FIN_BLOCK : '}' ;
E_FIN_LIGNE : ';' ;
E_AFFECT : ':=' ;
E_DECL_TYPE : ':' ;

E_NON : 'not' ;
E_VRAI : 'true' ;
E_FAUX : 'false' ;
E_ET : 'and' ;
E_OU : 'or' ;
E_EG : '=' ;
E_DIF : '!=' ;
E_INF : '<' ;
E_SUP : '>' ;
E_INFEG : '<=' ;
E_SUPEG : '>=' ;

E_PLUS : '+' ;
E_MOINS : '-' ;
E_FOIS : '*' ;
E_DIV : '/' ;

E_SI : 'if' ;
E_ALORS : 'then' ;
E_SINON : 'else' ;
E_BOUCLE : 'while' ;
E_FAIRE : 'do' ;
E_STOP : 'skip' ;

E_LIRE : 'read' ;
E_ECRIRE : 'write' ;

CONSTANTE : (NUMBER | E_VRAI | E_FAUX) ;
TYPE : ('Int' | 'Bool' | 'Array of' TYPE) ;
NUMBER : ('0'..'9')+ ;
IDENTIFIER : ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;

CARAC_SPE : (' ' | '\t' | '\r' | '\n')+ -> skip ;



prog : variables definitions instructions ;

variables : (E_VAR couple+ E_FIN_LIGNE)? ;
couple : (IDENTIFIER E_DECL_TYPE TYPE) ;
params : couple* ;

definitions : (E_DEF definition)* ;
definition : IDENTIFIER E_P_GAUCHE params E_P_DROITE return_type variables instructions_block ;
return_type : (E_DECL_TYPE TYPE)?;

instructions_block : (E_DEB_BLOCK instructions E_FIN_BLOCK | instruction) ;
instructions : instruction (E_FIN_LIGNE instruction)* ;
instruction : affectation | if_block | while_block | call | E_STOP ;
affectation : IDENTIFIER E_AFFECT expression | IDENTIFIER '[' expression ']' E_AFFECT expression ;
if_block : E_SI expression E_ALORS instructions_block E_SINON instructions_block ;
while_block : E_BOUCLE expression E_FAIRE instructions_block ;
call : (IDENTIFIER | E_ECRIRE | E_LIRE ) E_P_GAUCHE expression* E_P_DROITE ;

expression : bop ;
bop : mul_exp (E_PLUS mul_exp | E_MOINS mul_exp | E_OU mul_exp)* ;
mul_exp : bool_exp (E_FOIS bool_exp | E_DIV bool_exp | E_ET bool_exp)* ;
bool_exp : uop (E_INF uop | E_SUP uop | E_INFEG uop | E_SUPEG uop | E_EG uop | E_DIF uop)* ; 
uop : '-' uop | E_NON uop | call | CONSTANTE | IDENTIFIER | IDENTIFIER '[' expression ']' | '(' expression ')' ;