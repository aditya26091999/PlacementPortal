package exceptionPack;

public class NameException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -195300364937681722L;
	String str;
	
	public NameException(String str) {
		// TODO Auto-generated constructor stub
		this.str = str;
	}
	
	public String toString() {
		return ("NameException"+str);
	}
}
