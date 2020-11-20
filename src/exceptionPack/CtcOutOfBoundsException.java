package exceptionPack;

public class CtcOutOfBoundsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1785086832767571290L;
	String str;
	
	public CtcOutOfBoundsException(String str) {
		this.str = str;
	}
	
	public String toString() {
		return ("CtcOutOfBoundsException: "+str);
	}
}
