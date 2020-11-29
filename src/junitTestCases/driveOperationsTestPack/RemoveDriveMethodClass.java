package junitTestCases.driveOperationsTestPack;

import java.util.Scanner;

import model.DatabaseOperations;

public class RemoveDriveMethodClass {
	static Scanner sc;
	static int driveID;
	
	public static boolean RemoveDrive() {
		sc = new Scanner(System.in);
		System.out.print("Enter drive ID to remove that drive: ");
		driveID = sc.nextInt();
		return DatabaseOperations.removeSelectedDrive(driveID);
	}
}
