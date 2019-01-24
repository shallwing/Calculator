/****************************
 * Author:			Donald Shallwing
 * Email:			donald_shallwing@foxmail.com
 * Function:		This file is used for process the single operators
 * Date:			24/12/2018
 ****************************/

package ProblemField;

public class OperatorSingle {
	
	private double number;
	
//Constructor
	public OperatorSingle(double number) {
		this.number = number;
	}
	public void setNumber(double number ){
		this.number = number;
	}
	public OperatorSingle(){}
	
	

	public int factorial(){
		int time = 1;
		for(int i=(int)number; i!=1.0; i--){
			time = time*i;
		}
		if(number==0)
			return 1;
		return time;
	}	
	public double calculate(String operator){
		if(operator.equals("sin")){
			if(number%Math.PI==0)
				return 0.0;
			else
				return Math.sin(number);
		}
		if(operator.equals("cos")){
			if(number%(0.5*Math.PI)==0)
				return 0.0;
			else
				return Math.cos(number);
		}
		if(operator.equals("tan")){
			if(number%Math.PI==0)
				return 0;
			else{
				if(number%(Math.PI/2.0)!=0)
					return Math.tan(number);
				else
					return number/0.0;
			}
		}
		if(operator.equals("/X")){
			if(number==0)
				return 1.0/0.0;
			else
				return 1.0/number;
		}
		
		if(operator.equals("arcsin"))
			return Math.asin(number);
		if(operator.equals("arccos"))
			return Math.acos(number);
		if(operator.equals("arctan"))
			return Math.atan(number);
		if(operator.equals("log"))
			return Math.log10(number);
		if(operator.equals("ln"))
			return Math.log(number);
		if(operator.equals("√"))
			return Math.sqrt(number);
		if(operator.equals("X²"))
			return number*number;
		if(operator.equals("X³"))
			return number*number*number;
		if(operator.equals("X!"))
			return this.factorial();
		if(operator.equals("°—rad"))
			return number*Math.PI/180.0;
		if(operator.equals("exp"))
			return Math.exp(number);
		if(operator.equals("%"))
			return number/100.0;
		if(operator.equals("±"))
			return number*(-1.0);
		else
			return 0.0;
	}
}