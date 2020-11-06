package model;

public class GeneratePasswordClass {
	public static String generatePassword(int sizeOfpass) {
		String alphaNum = "1234567890" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";

		StringBuilder sb = new StringBuilder(sizeOfpass);
		for (int i = 0; i < sizeOfpass; i++) {
			int index = (int) (alphaNum.length() * Math.random());
			sb.append(alphaNum.charAt(index));
		}
		return sb.toString();
	}
}
