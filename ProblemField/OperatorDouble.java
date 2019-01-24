/****************************
 * Author:			Donald Shallwing
 * Email:			donald_shallwing@foxmail.com
 * Function:		This file is used for process the double operators
 * Date:			24/12/2018
 ****************************/


package ProblemField;

public abstract class OperatorDouble{
	protected double numberA,numberB;
	public void setNumberA(double numberA){
		this.numberA = numberA;
	}
	public double getNumberB() {
		return numberB;
	}
	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}
	public double getNumberA() {
		return numberA;
	}
	public abstract double getResult();
}

class Add extends OperatorDouble{
	public double getResult(){
		return this.numberA+this.numberB;
	}
}
class Mins extends OperatorDouble{
	public double getResult(){
		return this.numberA-this.numberB;
	}
}
class Time extends OperatorDouble{
	public double getResult(){
		return this.numberA*this.numberB;
	}
}
class Divide extends OperatorDouble{
	public double getResult(){
		return this.numberA/this.numberB;
	}
}
class Power extends OperatorDouble{
	public double getResult(){
		return Math.pow(this.numberA, this.numberB);
	}
}
class MOD extends OperatorDouble{
	public double getResult(){
		if(numberB<1.0)
			return numberB/0.0;
		else
			return (int)this.numberA%(int)this.numberB;
	}
}