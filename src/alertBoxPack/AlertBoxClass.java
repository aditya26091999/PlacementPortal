package alertBoxPack;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import screenPack.ScreenPackClass;

public class AlertBoxClass {
	public static void ErrBox(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText("ERROR");
		alert.setContentText(msg);
		alert.showAndWait();
	}

	public static void Notify(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText("NOTIFY");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public static void Amber(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText("WARNING");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public static void logOutConfirmation(AnchorPane rootpane) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Alert");
	    alert.setHeaderText("LOGOUT");
	    alert.setContentText("Are you sure you want to LOGOUT?");
	    
	    Optional<ButtonType> option = alert.showAndWait();
	    if(option.get() == ButtonType.OK) {
	    	ScreenPackClass.showLoginPage(rootpane);
	    }
	    else if(option.get() == ButtonType.CANCEL) {
	    	ScreenPackClass.showAdminDashScreen(rootpane);
	    }
	}
}
