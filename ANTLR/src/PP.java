// PP.java

import java.util.ArrayList;
/*********/
/* Types */
/*********/

abstract class Type {}//Type

class Int extends Type {}//Int

class Bool extends Type {}//Bool

class Array extends Type {

    Type elements;

    Array (Type elements) {
        this.elements = elements;
    }//Array

}//Array

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class PPExpr {
	abstract UPPExpr toUPP(ArrayList<String> locals);
}//PPExpr


class PPCte extends PPExpr {

    int val;

    PPCte (int val) {
        this.val = val;
    }//PPCte

	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPCte(val);
	}


}//PPCte


class PPTrue extends PPExpr {

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPTrue();
	}}//PPTrue

class PPFalse extends PPExpr {

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPFalse();
	}}//PPFalse

class PPVar extends PPExpr {

    String name;

    PPVar (String name) {
        this.name = name;
    }//PPVar

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPVar(name);
	}

}//PPVar

abstract class PPUnOp extends PPExpr {

    PPExpr e;

}//PPUnOp

class PPInv extends PPUnOp {

    PPInv (PPExpr e) {
        this.e = e;
    }//PPInv

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPCte x = new UPPCte(0);
		UPPExpr ne = e.toUPP(locals);
		return new UPPSub(x,ne);
	}

}//PPInv

class PPNot extends PPUnOp {

    PPNot (PPExpr e) {
        this.e = e;
    }//PPNot

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne = e.toUPP(locals);
		return new UPPNot(ne);
	}

}//PPNot

abstract class PPBinOp extends PPExpr {

    PPExpr e1, e2;

}//PPBinOp

class PPAdd extends PPBinOp {

    PPAdd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAdd

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPAdd(ne1,ne2);
	}

}//PPAd

class PPSub extends PPBinOp {

    PPSub (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPSub

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPSub(ne1,ne2);
	}
    
    

}//PPSub

class PPMul extends PPBinOp {

    PPMul (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPMul

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPMul(ne1,ne2);
	}

}//PPMul

class PPDiv extends PPBinOp {

    PPDiv (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPDiv

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPDiv(ne1,ne2);
	}

}//PPDiv

class PPAnd extends PPBinOp {

    PPAnd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAnd

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPAnd(ne1,ne2);
	}

}//PPAnd

class PPOr extends PPBinOp {

    PPOr (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPOr

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPOr(ne1,ne2);
	}

}//PPOr

class PPLe extends PPBinOp {

    PPLe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLe

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPLe(ne1,ne2);
	}

}//PPLe

class PPLeq extends PPBinOp {

    PPLeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLeq

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPLeq(ne1,ne2);
	}

}//PPLeq

class PPEq extends PPBinOp {

    PPEq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPEq

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPEq(ne1,ne2);
	}

}//PPEq

class PPNeq extends PPBinOp {

    PPNeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPNeq

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPNeq(ne1,ne2);	}

}//PPNeq

class PPGeq extends PPBinOp {

    PPGeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGeq

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPGeq(ne1,ne2);
	}

}//PPGeq

class PPGe extends PPBinOp {

    PPGe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGe

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = e1.toUPP(locals);
		UPPExpr ne2 = e2.toUPP(locals);
		return new UPPGe(ne1,ne2);
	}

}//PPGe

abstract class Callee {}//Callee

class Read extends Callee {}//Read

class Write extends Callee {}//Write

class User extends Callee {

    String name;

    User (String name) {
        this.name = name;
    }//User

}//User

class PPFunCall extends PPExpr {

    Callee callee;
    ArrayList<PPExpr> args;

    PPFunCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		ArrayList<UPPExpr> argsUPP = new ArrayList<UPPExpr>();
		for(PPExpr arg : args){
			argsUPP.add(arg.toUPP(locals));
		}
		return new UPPFunCall(callee,argsUPP);
	}

}//FunCall

class PPArrayGet extends PPExpr {

    PPExpr arr, index;

    PPArrayGet (PPExpr arr, PPExpr index) {
        this.arr = arr;
        this.index = index;
    }//PPArrayGet

	@Override
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = arr.toUPP(locals);
		UPPExpr ne2 = index.toUPP(locals);
		return new UPPAdd(ne1,ne2);
	}

}//PPArrayGet

class PPArrayAlloc extends PPExpr {

    Type type;
    PPExpr size;

    PPArrayAlloc (Type type, PPExpr size) {
        this.type = type;
        this.size = size;
    }//PPArrayAlloc
    
	UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne1 = size.toUPP(locals);
		ArrayList<UPPExpr> array = new ArrayList<UPPExpr>();
		Callee c = new Alloc();
		UPPExpr chiffre = new UPPCte(4);
		UPPExpr mul = new UPPMul(chiffre,ne1);
		array.add(mul);
		return new UPPFunCall(c,array);
	}

}//PPArrayAlloc

/****************/
/* Instructions */
/****************/

abstract class PPInst {
	abstract UPPInst toUPP(ArrayList<String> locals);
}//PPInst

class PPAssign extends PPInst {

    String name;
    PPExpr val;

    PPAssign (String name, PPExpr val) {
        this.name = name;
        this.val = val;
    }//PPAssign
    UPPInst toUPP(ArrayList<String> locals){
    	UPPExpr nval = val.toUPP(locals);
    	return new UPPAssign(name, nval);
    }
}//PPAssign

class PPArraySet extends PPInst {

    PPExpr arr, index, val;

    PPArraySet (PPExpr arr, PPExpr index, PPExpr val) {
        this.arr = arr;
        this.index = index;
        this.val = val;
    }//PPArraySet
    UPPInst toUPP(ArrayList<String> locals){
    	UPPExpr narr = arr.toUPP(locals);
    	UPPExpr nindex = index.toUPP(locals);
    	UPPExpr nval = val.toUPP(locals);
    	UPPExpr offset = new UPPMul(new UPPCte(4),nindex);
    	UPPExpr nsize = new UPPAdd(narr,offset);
    	return new UPPStore(narr,new UPPMul(nsize,nval));
    }
}//PPArraySet

class PPCond extends PPInst {

    PPExpr cond;
    PPInst i1, i2;

    PPCond (PPExpr cond, PPInst i1, PPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//PPCond
    UPPInst toUPP(ArrayList<String> locals){
    	UPPExpr ncond = cond.toUPP(locals);
    	UPPInst ni1 = i1.toUPP(locals);
    	UPPInst ni2 = i2.toUPP(locals);
    	return new UPPCond(ncond, ni1,ni2);
    }
}//PPCond

class PPWhile extends PPInst {

    PPExpr cond;
    PPInst i;

    PPWhile (PPExpr cond, PPInst i) {
        this.cond = cond;
        this.i = i;
    }//PPWhile
    UPPInst toUPP(ArrayList<String> locals){
    	UPPExpr ncond = cond.toUPP(locals);
    	UPPInst ni = i.toUPP(locals);
    	return new UPPWhile(ncond,ni);
    }
}//PPWhile

class PPProcCall extends PPInst {

    Callee callee;
    ArrayList<PPExpr> args;

    PPProcCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//PPProcCall
    UPPInst toUPP(ArrayList<String> locals){
    	ArrayList<UPPExpr> nargs = new ArrayList<UPPExpr>();
    	for (PPExpr e: args){
    		UPPExpr x = e.toUPP(locals);
    		nargs.add(x);
    	}
    	return new UPPProcCall(callee,nargs);
    }
}//PPProcCall
    
class PPSkip extends PPInst {

	@Override
	UPPInst toUPP(ArrayList<String> locals) {
		// TODO Auto-generated method stub
		return null;
	}}//PPSkip

class PPSeq extends PPInst {

    PPInst i1, i2;

    PPSeq (PPInst i1, PPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//PPSeq
    UPPInst toUPP(ArrayList<String> locals){
    	UPPInst ni1 = i1.toUPP(locals);
    	UPPInst ni2 = i2.toUPP(locals);
    	return new UPPSeq(ni1, ni2);
    }
}//PPSeq

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

abstract class PPDef {

    String name;
    ArrayList<Pair<String,Type>> args, locals;
    PPInst code;
    
    abstract  UPPDef toUPP();

}//PPDef

class PPFun extends PPDef {

    Type ret;

    PPFun (String name, ArrayList<Pair<String,Type>> args,
         ArrayList<Pair<String,Type>> locals, PPInst code, Type ret) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
        this.ret = ret;
    }//PPFun
    UPPDef toUPP(){
    	ArrayList<String> nargs = new ArrayList<String>();
    	ArrayList<String> nlocals = new ArrayList<String>();
    	ArrayList<String> nall = new ArrayList<String>();
    	UPPInst ncode;
    	for(Pair <String,Type> e : args){
    		nargs.add(e.left);
    		nall.add(e.left);
    	}
    	
    	for(Pair <String,Type> e : locals){
    		nlocals.add(e.left);
    		nall.add(e.left);
    	}
    	
    	ncode = code.toUPP(nall);
    	return new UPPFun(name,nargs,nlocals,ncode);

}//PPFun

class PPProc extends PPDef {

    PPProc (String name, ArrayList<Pair<String,Type>> args,
            ArrayList<Pair<String,Type>> locals, PPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//PPProc
    UPPDef toUPP(){
    	ArrayList<String> nargs = new ArrayList<String>();
    	ArrayList<String> nlocals = new ArrayList<String>();
    	for (Pair<String,Type> e: args){
    		nargs.add(e.left);
    	}
    	for (Pair<String,Type> e: locals){
    		nlocals.add(e.left);
    	}
    	UPPInst ncode = code.toUPP(new ArrayList<String>());
    	return new UPPProc(name, nargs, nlocals,ncode);
    }
}//PPProc

/************/
/* Programs */
/************/

class PPProg {

    ArrayList<Pair<String,Type>> globals;
    ArrayList<PPDef> defs;
    PPInst code;

    PPProg (ArrayList<Pair<String,Type>> globals, ArrayList<PPDef> defs,
          PPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }//PPProg
    UPPProg toUPP(){
    	ArrayList<String> nglobals = new ArrayList<String>();
    	ArrayList<UPPDef> ndefs = new ArrayList<UPPDef>();
    	UPPInst ncode = code.toUPP(new ArrayList<String>());
    	for  (Pair<String,Type> e : globals){
    		nglobals.add(e.left);
    	}
    	for (PPDef e : defs){
    		ndefs.add(e.toUPP());
    	}
    	return new UPPProg(nglobals, ndefs,ncode);
    }
}
}
