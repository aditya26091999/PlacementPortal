package exceptionPack;

public class EmptyFieldsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5286953219088231323L;
	String str;
	
	public EmptyFieldsException(String str) {
		this.str = str;
	}
	
	public String toString() {
		return ("EmptyFieldsException: "+str);
	}
}
