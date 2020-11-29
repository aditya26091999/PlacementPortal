package junitTestCases.driveOperationsTestPack;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

import exceptionPack.BackLogOutOfBoundsException;
import exceptionPack.CtcOutOfBoundsException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import exceptionPack.PercentageOutOfBoundsException;
import model.DatabaseOperations;

public class AddDriveMethodClass {
	static Scanner sc;
	static String cname;
	static String cdate = "11/30/2020";
	static String xthMin;
	static String xIIthMin;
	static String BEMin;
	static String deadBack;
	static String liveBack;
	static String ctc;
	static String branch = "CS";

	public static int addDriveMethod() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException,
			SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException,
			BackLogOutOfBoundsException, NameException {
		
		sc = new Scanner(System.in);
		System.out.println("Enter company Name: ");
		cname = sc.nextLine();
		System.out.print("Enter 10th minimum percentage: ");
		xthMin = sc.nextLine();
		System.out.print("Enter 12th minimum percentage: ");
		xIIthMin = sc.nextLine();
		System.out.print("Enter BE minimum percentage: ");
		BEMin = sc.nextLine();
		System.out.print("Enter maximum live backlogs: ");
		liveBack = sc.nextLine();
		System.out.print("Enter maximum Dead backlogs: ");
		deadBack = sc.nextLine();
		System.out.println("Enter company CTC: ");
		ctc = sc.nextLine();
		
		return DatabaseOperations.addDriveToDatabase(cname, cdate, xthMin, xIIthMin, BEMin, deadBack, liveBack, branch,
				ctc);
	}
}
