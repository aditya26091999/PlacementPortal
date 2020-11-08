package testPackage;

import alertBoxPack.AlertBoxClass;
import application.Main;
import model.DatabaseOperations;

class LogOutAndDriveEntryTestClass {
	public boolean getLogOut() {
		boolean res = false;
		Main.main(null);
		res = AlertBoxClass.loggedOut;
		return res;
	}
}

class DriveAddToDB {
	public boolean driveToDB() {
		boolean res = false;
		Main.main(null);
		res = DatabaseOperations.returnRes;
		return res;
	}
}
