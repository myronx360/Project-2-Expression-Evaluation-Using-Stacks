import java.util.ArrayList;

import edu.uncc.cs.bridgesV2.base.SLelement;

public class SLStack<String> implements Stack<String>{
	private SLelement<String> top; // Pointer to first element
	private int size; // Number of elements
	private ArrayList<String> al = new ArrayList<>();
	
	/**Constructors*/
	public SLStack() { top = null; size = 0; }
	public SLStack(int size) { top = null; size = 0; }
	
	/**Reinitialize stack*/
	public void clear() { top = null; size = 0; al.clear();}
	/**Put "it" on stack*/
	public void push(String it) {
		top = new SLelement<String>(it, top);
		//top.setLabel(it.toString());
		//top.setNext(new SLelement<String>(it, top.getNext()));	
		al.add(it);
		size++;
	}

//	public String read(){
//		String it = top.getValue();
//		String label = top.getLabel();
//		return label;
//	}

//	@Override
//	public String toString() {
//		String newString="";
//		for(int i = 0; i < al.size(); i++){
//			newString = newString.concat(al.get(i).toString());
//			newString = newString.concat("; ");
//		}
//		return newString;
//	}

	/**Remove "it" from stack*/
	public String pop() {
		assert top != null : "Stack is empty";

		String it = top.getValue();
		al.remove(it);
		top = top.getNext();
		size--;
		return it;
	}

	/**@return Top value*/
	public String topValue() {
		assert top != null : "Stack is empty";
		return top.getValue();
	}
	
	public SLelement getStackTop() {
		assert top != null : "Stack is empty";
		return top;//(SLelement) al.get(length()-1);
	}
	
	/**@return Stack length*/
	public int length() { return size; }
	public void print(){
		
		try {
			for(int i = 0; i < length(); i++){
				System.out.print( al.get(i)+ "; ");
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("topValue is null");
		}
		System.out.println();
	}

	/**
	 * @return the al
	 */
	public String getAl(int index) {
		return al.get(index);
	}
	/**
	 * @param al the al to set
	 */
	public void setAl(ArrayList<String> al) {
		this.al = al;
	}
	
}
