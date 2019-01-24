/****************************
 * Author:				Donald Shallwing
 * Email: 				donald_shallwing@foxmail.com
 * Function: 			This file is used for processing the whole external events
 * Date:				24/12/2018
 ****************************/

package Main;

public class TextFieldMethod {
	
	 public static String addPointer(String text){
		if(text.equals("")==false){
			for(int i=0;i<text.length();i++){
				if(text.charAt(i)=='.')
					return text;
			}
		}
		else
			return text;
		return text+".";
	}//Add pointer '.'
	
	public static String addNumber(String number,String text){
		if(text.equals("")){}
		else{
			if(text.charAt(text.length()-1)=='e'||
					text.charAt(text.length()-1)=='π'){
				return text;
			}
		}
		return text+number;
		
	}//Add number "0123456789"
	
	public static String deleteChar(String test){
		if(test.equals("")){}
		else{
			test = test.substring(0, test.length()-1);
		}
		return test;
	}//Delete a char
	
	public static String clearTextField(){
		return "";
	}//Clean the TextField
	
}

