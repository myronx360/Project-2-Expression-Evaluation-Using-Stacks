/**
 * Data file:
	a = 5.;
	b = 3.;
	c = 8.;
	d = 20.;
	e = 18.;
	f = 9.;
	g = 12.;
	h = 7.;
	k = 1.;
	
	ab-c+d-e+g+h+	//a-b+c-d+e-g+h+
	abc*- 			// a - b*c
	efg**  			// e*f*g
	ef/g/  			// e/f/g
	efg/h*-k+  		// e  - f/g * h + k
 */
import java.io.*;
import java.util.*;

import edu.uncc.cs.bridgesV2.base.SLelement;
import edu.uncc.cs.bridgesV2.connect.Bridges;
// postfix expression evaluator
public class Driver23 {
	private static SLStack<String> expressionStack = new SLStack<String>(1);
	private static String ex;
	static int expression;
	static HashMap<String, Double> map = new HashMap();
	static double result;
	static String strResult;
	static Character operator;
	static Character operand;
	static Character z;
	static boolean isOperator;
	static boolean isOperand;
	private static Bridges<String> bridge;
	public static void main(String args[]) throws Exception{
		bridge = new Bridges<String>(0, "509600458590", "mwill320");
		map.put("a", 5.);
		map.put("b", 3.);
		map.put("c", 8.);
		map.put("d", 20.);
		map.put("e", 18.);
		map.put("f", 9.);
		map.put("g", 12.);
		map.put("h", 7.);
		map.put("k", 1.);
	
		console();
		

	
			
		for ( Character c: ex.toCharArray()){
			operand = c;
			operator = c;
			
			if(isOperand()){

				expressionStack.push(c.toString());
				expressionStack.getStackTop().setLabel(map.get(c.toString()).toString());
				expressionStack.getStackTop().getVisualizer().setColor("green");
				connectSLelements();

			}else if(isOperator()){

				String opnd2 = expressionStack.pop();
//			///	connectSLelements();
								
				String opnd1 = expressionStack.pop();
//				expressionStack.print();

				/////connectSLelements();

				
				// happends when the opnd isn't in the map
				if(map.containsKey(opnd1) && map.containsKey(opnd2)){
//					System.out.println(map.get(opnd1) +" : "+getOperator()+" : "+map.get(opnd2));
					if(getOperator() == '*')
						result = (map.get(opnd1) * map.get(opnd2));
					else if(getOperator() == '/')
						result = (map.get(opnd1) / map.get(opnd2));
					else if(getOperator() == '+')
						result = (map.get(opnd1) + map.get(opnd2));
					else if(getOperator() == '-')
						result = ((map.get(opnd1) - map.get(opnd2)));
				}else if(map.containsKey(opnd1) && !map.containsKey(opnd2)){
//					System.out.println(map.get(opnd1) +" : "+getOperator()+" : "+ Double.parseDouble(opnd2));
					if(getOperator() == '*')
						result = (map.get(opnd1) * Double.parseDouble(opnd2));
					else if(getOperator() == '/')
						result = (map.get(opnd1) / Double.parseDouble(opnd2));
					else if(getOperator() == '+')
						result = (map.get(opnd1) + Double.parseDouble(opnd2));
					else if(getOperator() == '-')
						result = (map.get(opnd1) - Double.parseDouble(opnd2));
				}else if(!map.containsKey(opnd1) && map.containsKey(opnd2)){
//					System.out.println(Double.parseDouble(opnd1) +" : "+getOperator()+" : "+map.get(opnd2));
					if(getOperator() == '*')
						result = (Double.parseDouble(opnd1) * map.get(opnd2));
					else if(getOperator() == '/')
						result = (Double.parseDouble(opnd1) / map.get(opnd2));
					else if(getOperator() == '+')
						result = (Double.parseDouble(opnd1) + map.get(opnd2));
					else if(getOperator() == '-')
						result = (Double.parseDouble(opnd1) - map.get(opnd2));
				}else if(!map.containsKey(opnd1) && !map.containsKey(opnd2)){
//					System.out.println(Double.parseDouble(opnd1) +" : "+getOperator()+" : "+Double.parseDouble(opnd2));
					if(getOperator() == '*')
						result = (Double.parseDouble(opnd1) * Double.parseDouble(opnd2));
					else if(getOperator() == '/')
						result = (Double.parseDouble(opnd1) / Double.parseDouble(opnd2));
					else if(getOperator() == '+')
						result = (Double.parseDouble(opnd1) + Double.parseDouble(opnd2));
					else if(getOperator() == '-')
						result = (Double.parseDouble(opnd1) - Double.parseDouble(opnd2));
				}
				
//				System.out.println("result: "+result);

				strResult = Double.toString(result);
				expressionStack.push(strResult);
				expressionStack.getStackTop().getVisualizer().setColor("blue");
				
				expressionStack.getStackTop().setLabel(strResult);
				
				connectSLelements();
			}
		}

		strResult = expressionStack.pop();
//////		connectSLelements();

	}
	
	private static void console() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1. ab-c+d-e+g+h+ \n2.abc*- \n3.efg** \n4. ef/g/ \n5. efg/h*-k+");
		Scanner in = new Scanner(System.in);
		
		switch (in.nextInt()){
		case 1:	ex = "ab-c+d-e+g+h+"; break;
		case 2: ex = "abc*-"; break;
		case 3: ex = "efg**"; break;
		case 4: ex = "ef/g/"; break;
		case 5: ex = "efg/h*-k+"; break;
		default: console(); break;
		}
		in.close();
	}

	public static Character getOperator() {
		return operator;
	}


	public static Character getOperand() {
		return operand;
	}

	
	public static boolean isOperator() {
		
		if(getOperator()=='+' || getOperator()=='-'|| 
		   getOperator()=='*' || getOperator()=='/'){
			isOperator = true;
		}else{
			isOperator = false;
		}
		return isOperator;
	}

	public static boolean isOperand() {
		
		if (getOperand() == 'a'|| getOperand() == 'b'|| getOperand() == 'c'|| getOperand() == 'd'||
			getOperand() == 'e'|| getOperand() == 'f'|| getOperand() == 'g'|| getOperand() == 'h'||
			getOperand() == 'k'){
		
			isOperand = true;
			z=getOperand();
		}else{
			isOperand = false;
		}
		return isOperand;
	}

	/** connect the SLelements
	 * @throws Exception */
	public static void connectSLelements() throws Exception{
		
		bridge.setDataStructure(expressionStack.getStackTop(), "llist");
		bridge.visualize();
	}


}