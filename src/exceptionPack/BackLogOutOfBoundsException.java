package exceptionPack;

public class BackLogOutOfBoundsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6440758569748056794L;
	String str;
	
	public BackLogOutOfBoundsException(String str){
		this.str = str;
	}
	
	public String toString() {
		return ("BackLogOutOfBounds: "+str);
	}
}
