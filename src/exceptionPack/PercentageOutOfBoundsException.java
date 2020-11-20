package exceptionPack;

public class PercentageOutOfBoundsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7292633947227757148L;
	String str;
	
	public PercentageOutOfBoundsException(String str) {
		this.str = str;
	}
	
	public String toString() {
		return ("PercentageOutOfBoundsException"+str);
	}
}
