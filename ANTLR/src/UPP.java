// UPP.java

import java.util.*;

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class UPPExpr {}//UPPExpr

class UPPCte extends UPPExpr {

    int val;

    UPPCte (int val) {
        this.val = val;
    }//UPPCte
    public String toString(){
    	return Integer.toString(val);
    }

}//UPPCte

class UPPTrue extends UPPExpr {}//UPPTrue

class UPPFalse extends UPPExpr {}//UPPFalse

class UPPVar extends UPPExpr {

    String name;

    UPPVar (String name) {
        this.name = name;
    }//UPPVar
    public String toString(){
    	return this.name;
    }
}//UPPVar

class UPPGVar extends UPPExpr {

    String name;

    UPPGVar (String name) {
        this.name = name;
    }//UPPGVar
    public String toString(){
    	return this.name;
    }
}//UPPGVar

abstract class UPPUnOp extends UPPExpr {

    UPPExpr e;
    
}//UPPUnOp

class UPPNot extends UPPUnOp {

    UPPNot (UPPExpr e) {
        this.e = e;
    }//UPPNot
    public String toString(){
    	String str = "not " + this.e.toString();
    	return str;
    }
}//UPPNot

abstract class UPPBinOp extends UPPExpr {

    UPPExpr e1, e2;

}//UPPBinOp

class UPPAdd extends UPPBinOp {

    UPPAdd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAdd
    public String toString(){
    	String str = this.e1.toString() + " + " + this.e2.toString();
    	return str;
	}

}//UPPAd

class UPPSub extends UPPBinOp {

    UPPSub (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPSub
    public String toString(){
    	String str = this.e1.toString() + " - " + this.e2.toString();
    	return str;
	}
}//UPPSub

class UPPMul extends UPPBinOp {

    UPPMul (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPMul
    public String toString(){
    	String str = this.e1.toString() + " * " + this.e2.toString();
    	return str;
	}
}//UPPMul

class UPPDiv extends UPPBinOp {

    UPPDiv (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPDiv
    public String toString(){
    	String str = this.e1.toString() + " / " + this.e2.toString();
    	return str;
	}
}//UPPDiv

class UPPAnd extends UPPBinOp {

    UPPAnd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAnd
    public String toString(){
    	String str = this.e1.toString() + " and " + this.e2.toString();
    	return str;
	}
}//UPPAnd

class UPPOr extends UPPBinOp {

    UPPOr (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPOr
    public String toString(){
    	String str = this.e1.toString() + " or " + this.e2.toString();
    	return str;
	}
}//UPPOr

class UPPLe extends UPPBinOp {

    UPPLe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLe
    public String toString(){
    	String str = this.e1.toString() + " < " + this.e2.toString();
    	return str;
	}
}//UPPLe

class UPPLeq extends UPPBinOp {

    UPPLeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLeq
    public String toString(){
    	String str = this.e1.toString() + " <= " + this.e2.toString();
    	return str;
	}
}//UPPLeq

class UPPEq extends UPPBinOp {

    UPPEq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPEq
    public String toString(){
    	String str = this.e1.toString() + " = " + this.e2.toString();
    	return str;
	}
}//UPPEq

class UPPNeq extends UPPBinOp {

    UPPNeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPNeq
    public String toString(){
    	String str = this.e1.toString() + " != " + this.e2.toString();
    	return str;
	}
}//UPPNeq

class UPPGeq extends UPPBinOp {

    UPPGeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGeq
    public String toString(){
    	String str = this.e1.toString() + " >= " + this.e2.toString();
    	return str;
	}
}//UPPGeq

class UPPGe extends UPPBinOp {

    UPPGe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGe
    public String toString(){
    	String str = this.e1.toString() + " > " + this.e2.toString();
    	return str;
	}
}//UPPGe

abstract class Callee {}//Callee

class Read extends Callee {}//Read

class Write extends Callee {}//Write

class User extends Callee {

    String name;

    User (String name) {
        this.name = name;
    }//User

}//User

class Alloc extends Callee {}//Alloc

class UPPFunCall extends UPPExpr {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPFunCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall
    public String toString() {
    	String str = this.callee.toString() + " ( ";
    	for(UPPExpr arg : args) {
    		str = str + arg.toString();
    		str = str + ", ";
    	}
    	str = str + ")";
    	return str;
    }
}//FunCall

class UPPLoad extends UPPExpr {

    UPPExpr addr;

    UPPLoad (UPPExpr addr) {
        this.addr = addr;
    }//UPPLoad
    public String toString(){
		String str = ""+this.addr.toString();
		return str;
	}
}//UPPLoad

/****************/
/* Instructions */
/****************/

abstract class UPPInst {}//UPPInst

class UPPAssign extends UPPInst {

    String name;
    UPPExpr val;

    UPPAssign (String name, UPPExpr val) {
        this.name = name;
        this.val = val;
    }//UPPAssign
    public String toString(){
    	String str = this.name + " := " + this.val.toString();
    	return str;
	}
}//UPPAssign

class UPPStore extends UPPInst {

    UPPExpr addr, val;

    UPPStore (UPPExpr addr, UPPExpr val) {
        this.addr = addr;
        this.val = val;
    }//UPPStore
    public String toString(){
    	String str = this.addr.toString() + " <- " + this.val.toString();
		return str;
	}
}//UPPStore

class UPPCond extends UPPInst {

    UPPExpr cond;
    UPPInst i1, i2;

    UPPCond (UPPExpr cond, UPPInst i1, UPPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//UPPCond
    public String toString(){
    	String str = "if" + this.cond.toString() + " then " + this.i1.toString() + "else" + this.i2.toString();
    	return str;
	}
}//UPPCond

class UPPWhile extends UPPInst {

    UPPExpr cond;
    UPPInst i;

    UPPWhile (UPPExpr cond, UPPInst i) {
        this.cond = cond;
        this.i = i;
    }//UPPWhile
    public String toString(){
    	String str = "while" + this.cond.toString() + "do" + this.i.toString();
    	return str;
	}
}//UPPWhile

class UPPProcCall extends UPPInst {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPProcCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//UPPProcCall
    public String toString(){
    	String str = this.callee.toString()+"(";
    	for (UPPExpr e : args){
    		str = str + e.toString();
    		str = str + ", ";
    	}
    	str = str + ")";
    	return str;
	}
}//UPPProcCall
    
class UPPSkip extends UPPInst {
	public String toString(){
		return "skip";
	}
}//UPPSkip

class UPPSeq extends UPPInst {

    UPPInst i1, i2;

    UPPSeq (UPPInst i1, UPPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//UPPSeq
    public String toString(){
		String str = this.i1.toString() + " ; " + this.i2.toString();
		return str;
	}
}//UPPSeq

/***************************************/
/* Definitions of functions/procedures */
/***************************************/

class Pair<L,R> {

    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }//Pair

    static <L,R> Pair<L,R> of(L left, R right){
        return new Pair<L,R>(left, right);
    }//of

}//Pair

abstract class UPPDef {

    String name;
    ArrayList<String> args, locals;
    UPPInst code;
}//UPPDef

class UPPFun extends UPPDef {

    UPPFun (String name, ArrayList<String> args, ArrayList<String> locals,
            UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPFun
    public String toString(){
    	String str = this.name + " ( ";
    	for(String arg : args) {
    		str = str + arg;
    		str = str + ", ";
    	}
    	for(String local : locals) {
    		str = str + "var " + local;
    		str = str + "\n";
    	}
    	str = str + this.code.toString();
    	return str;
	}
}//UPPFun

class UPPProc extends UPPDef {

    UPPProc (String name, ArrayList<String> args, ArrayList<String> locals,
             UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPProc
    public String toString(){
    	String str = this.name + " ( ";
    	for(String arg : args) {
    		str = str + arg;
    		str = str + ", ";
    	}
    	for(String local : locals) {
    		str = str + "var " + local;
    		str = str + "\n";
    	}
    	str = str + this.code.toString();
    	return str;
	}
}//UPPProc

/************/
/* Programs */
/************/

class UPPProg {

    ArrayList<String> globals;
    ArrayList<UPPDef> defs;
    UPPInst code;

    UPPProg (ArrayList<String> globals, ArrayList<UPPDef> defs, UPPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }//UPPProg
    public String toString(){
    	String str = "";
    	for(String glob : globals) {
    		str = str + "var " + glob;
    		str = str + "\n";
    	}
    	for(UPPDef def : defs) {
    		str = str + def.toString();
    		str = str + "\n";
    	}
    	str = str + this.code.toString();
    	return str;
	}
}//UPPProg