/****************************
 * Author:			Donald Shallwing
 * Email:			donald_shallwing@foxmail.com
 * Function:		This file is used when events happen, create a new factory class for respond the events.
 * Date:			24/12/2018
 ****************************/

package ProblemField;

public class OperationFactory {
	public static OperatorDouble createOperate(String operate){
		OperatorDouble operation = null;
		if(operate.equals("+")){
			operation = new Add();
		}
		if(operate.equals("-")){
			operation = new Mins();
		}
		if(operate.equals("×")){
			operation = new Time();
		}
		if(operate.equals("÷")){
			operation = new Divide();
		}
		if(operate.equals("Xⁿ")){
			operation = new Power();
		}
		if(operate.equals("MOD")){
			operation = new MOD();
		}
		return operation;
	}
}
