package junitTestCases.applyForDrivePack;

import java.util.Scanner;

import model.DatabaseOperations;

public class ApplyForDriveClass {
	static int driveid;
	static int studMSN;
	static Scanner sc;
	
	public static boolean applyToDriveMethod() {
		sc = new Scanner(System.in);
		System.out.println("Enter Drive's ID for application: ");
		driveid = sc.nextInt();
		System.out.println("Enter Student's MSN who'll be applying: ");
		studMSN = sc.nextInt();
		
		return DatabaseOperations.applyForDrive(driveid, studMSN);
	}
}
