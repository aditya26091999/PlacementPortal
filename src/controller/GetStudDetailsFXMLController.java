package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

public class GetStudDetailsFXMLController implements Initializable {
	@FXML
	private AnchorPane rootStudDetPane;
	@FXML
	private TextField fnameFiels;
	@FXML
	private TextField lnameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField msnField;
	@FXML
	private TextArea drivesAppliedArea;
	@FXML
	private Button backBtn;

	List<String> compList;

	// Event Listener on Button[#backBtn].onAction
	@FXML
	public void backToDash(ActionEvent event) throws Exception {
		ScreenPackClass.showAdminDashScreen(rootStudDetPane);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		int cnt = 1;
		compList = AdminDashBoardFXMLController.compList;
		fnameFiels.setText(DatabaseOperations.getFname);
		lnameField.setText(DatabaseOperations.getLname);
		emailField.setText(DatabaseOperations.getEmail);
		msnField.setText(Integer.toString(DatabaseOperations.getMsn));
		for (String iter : compList) {
			drivesAppliedArea.appendText(cnt + " " + iter + "\n");
			cnt++;
		}
	}
}
