/***************************
 * Author:		Donald Shallwing
 * Email:		donald_shallwing@foxmail.com
 * Function:	This file is used for GUI module design
 * Date:		24/12/2018
 ***************************/

package Main;
import java.awt.*;
import ProblemField.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton[][] button1 = new JButton[3][6];
	private JButton[][] button2 = new JButton[4][5];
	private JButton button = new JButton("±");
	private JTextField inputField = new JTextField(12);
	private JLabel jl2 = new JLabel
			("                              Constructed by");
	private JLabel jl3 = new JLabel("Donald Shallwing");
	private boolean isEqual;
	private OperatorDouble op;
	
	public GUI(){
		setEqual(true);
		Font font = new Font("Cambria Math",Font.PLAIN,30);
		Font font1 = new Font("Cambria Math",Font.BOLD,70);
		Font font2 = new Font("Comic Sans MS",Font.PLAIN,15);
		Font font3 = new Font("Kunstler Script",Font.BOLD,42);
		String[][] operator1 = 
			{{"X!","exp","/X","MOD","°—rad","%"},{"√","X²","X³","Xⁿ","log","ln"},
			{"sin","cos","tan","arcsin","arccos","arctan"}};
		String[][] operator2 = 
			{{"7","8","9","DEL","AC"},
			{"4","5","6","×","÷"},
			{"1","2","3","+","-"},
			{"0",".","π","e","="}};
		inputField.setFont(font1);
		inputField.setForeground(Color.BLACK);
		inputField.setHorizontalAlignment(SwingConstants.RIGHT);
		button.setFont(font);
		button.addActionListener(this);
		jl2.setFont(font2);
		jl3.setFont(font3);
		inputField.setFont(font1);
		int i,j;
		for(i=0; i<3; i++){
			for(j=0;j<6;j++){
				button1[i][j]=new JButton(operator1[i][j]);
				button1[i][j].setFont(font);
				button1[i][j].addActionListener(this);
			}
			j=0;
		}
		for(i=0; i<4; i++){
			for(j=0; j<5; j++){
				button2[i][j]=new JButton(operator2[i][j]);
				button2[i][j].setFont(font);
				button2[i][j].addActionListener(this);
			}
			j=0;
		}
		JPanel jp[] = new JPanel[8];
		JPanel jpLast = new JPanel(new GridLayout(1,3));
		jp[0] = new JPanel(new GridLayout(1,1));
		jp[0].add(inputField);
		for(i=1;i<8;i++){
			if(i<4){
				jp[i]= new JPanel(new GridLayout(1,6));
			}
			else
			{
				jp[i]= new JPanel(new GridLayout(1,5));
			}
		}
		for(i=0; i<3; i++){
			for(j=0; j<6; j++){
				jp[i+1].add(button1[i][j]);
			}
			j=0;
		}
		for(i=0; i<4; i++){
			for(j=0; j<5; j++){
				jp[i+4].add(button2[i][j]);
			}
			j=0;
		}
		jpLast.add(button);
		jpLast.add(jl2);
		jpLast.add(jl3);
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(9,1));
		for(i=0;i<8;i++){
			c.add(jp[i]);
		}
		c.add(jpLast);
		this.setTitle("Calculator");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {		
		String getButton = e.getActionCommand();
		String text = inputField.getText();
		if("0123456789".indexOf(getButton)!=-1){
			inputField.setText(TextFieldMethod.addNumber
					(getButton, text));
		}
		if(getButton.equals("AC")){
			inputField.setText(TextFieldMethod.
					clearTextField());
		}
		if(getButton.equals("DEL")){
			inputField.setText(TextFieldMethod.deleteChar
					(text));
		}
		if(getButton.equals(".")){
			inputField.setText(TextFieldMethod.addPointer
					(text));
		}
		if(getButton.equals("π")||getButton.equals("e")){
			if(getButton.equals("π"))
				inputField.setText(Math.PI+"");
			else
				inputField.setText(Math.E+"");
		}
		// calculation for OperatorSingle
		if(" X! ± sin cos tan arctan exp °—rad % X² X³ √ arcsin arccos log ln /X"
				.indexOf(getButton)!=-1){
			if(text.equals("")){}
			else{
				char c = text.charAt(text.length()-1);
				double number =0.0;
				
				if("0123456789".indexOf(c)!=-1){
					number = Double.parseDouble(text);
				}
				if(text.equals("π")||text.equals("e")){
					if(text.equals("π")){
						number = Math.PI;
					}
					if(text.equals("e")){
						number = Math.E;
					}
				}
				if("log ln".indexOf(getButton)!=-1){
					if(number<=0)
						inputField.setText("Error");
				}
				if("√".indexOf(getButton)!=-1){
					if(number<0)
						inputField.setText("Error");
				}
				if("X!".indexOf(getButton)!=-1){
					if(text.indexOf(".")!=-1){
						inputField.setText("Error");
					}
				}
				if(getButton.equals("arcsin")){
					if(number<-1||number>1)
						inputField.setText("Error");
				}
				if(getButton.equals("arccos")){
					if(number<-1||number>1)
						inputField.setText("Error");
				}
				else{
					OperatorSingle operator = new 
							OperatorSingle(number);
					double result = operator.calculate(getButton);
					inputField.setText(result+"");
				}
			}
		}
		//Calculation for OperatorDouble
		if("MOD + - ÷ × Xⁿ".indexOf(getButton)!=-1&&text.equals("")==false){
			 op = OperationFactory.createOperate(getButton);
			 op.setNumberA(Double.parseDouble(inputField.getText()));
			 inputField.setText("");
		}
		else if(getButton.equals("=")){
			if(text.equals("")==false)
				op.setNumberB(Double.parseDouble(inputField.getText()));
			if(text.equals("")){
				inputField.setText("");
			}
			if(getButton.equals("MOD")&&op.getNumberB()<1.0){
				JOptionPane.showMessageDialog(null,"MODNumber can't be smaller than 1.0!","提示",3);
				inputField.setText("");
			}
			if(op!=null&&op.getNumberB()==0&&getButton.equals("÷")){
				JOptionPane.showMessageDialog(null,"DivNumber can't be zero!","提示",3);
				inputField.setText("");
			}
			else{
				if(op!=null){
					double result = op.getResult();
					inputField.setText(Double.toString(result));
					setEqual(true);
				}
			}
		}
	}

	public boolean isEqual() {
		return isEqual;
	}

	public void setEqual(boolean isEqual) {
		this.isEqual = isEqual;
	}
}