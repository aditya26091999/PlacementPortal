package exceptionPack;

public class EmailFormatException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6243667273532795736L;
	String str;
	
	public EmailFormatException(String str) {
		// TODO Auto-generated constructor stub
		this.str = str;
	}
	
	public String toString() {
		return ("EmailFormatException: "+str);
	}
}
