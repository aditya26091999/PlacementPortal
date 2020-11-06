package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DataEntryValidation;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

import alertBoxPack.AlertBoxClass;
import javafx.event.ActionEvent;

import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

public class AddNewDriveFXMLController {
	@FXML
	private TextField companyName;
	@FXML
	private AnchorPane newDriveRootPane;
	@FXML
	private TextField TenthMinPerc;
	@FXML
	private TextField TwelthMinPerc;
	@FXML
	private TextField BEMinPerc;
	@FXML
	private TextField MaxActiveBacks;
	@FXML
	private RadioButton csRbtn;

	@FXML
	private RadioButton ITRbtn;

	@FXML
	private RadioButton MechRbtn;

	@FXML
	private RadioButton ENTCRbtn;

	@FXML
	private RadioButton CivilRbtn;

	@FXML
	private RadioButton AllRbtn;
	@FXML
	private TextField MaxDeadBacks;
	@FXML
	private TextField ctcOfCompany;
	@FXML
	private DatePicker dateOfDrive;
	@FXML
	private Button addDriveBtn;
	@FXML
	private Button cancelDriveBtn;

	// Event Listener on Button[#addDriveBtn].onAction
	@FXML
	public void addDriveToDatabase(ActionEvent event) {
		boolean addedToDatabase;
		String department = "";
		try {
			//
			boolean isEmptyFields = DataEntryValidation.checkEmptyFields(companyName.getText(),
					dateOfDrive.getValue().toString(), TenthMinPerc.getText(), TwelthMinPerc.getText(),
					BEMinPerc.getText(), MaxDeadBacks.getText(), MaxActiveBacks.getText(), ctcOfCompany.getText());

			if (isEmptyFields) {
				AlertBoxClass.Amber("Missing Fields", "You Left some fields empty!");
			} else if (!((csRbtn.isSelected() || ITRbtn.isSelected() || MechRbtn.isSelected() || ENTCRbtn.isSelected()
					|| CivilRbtn.isSelected()) || (AllRbtn.isSelected()))) {
				System.out.println("Select a Department!");
			} else {
				if (AllRbtn.isSelected()) {
					department = "All";
					csRbtn.setSelected(false);
					ITRbtn.setSelected(false);
					MechRbtn.setSelected(false);
					ENTCRbtn.setSelected(false);
					CivilRbtn.setSelected(false);
				} else {
					if (csRbtn.isSelected())
						department = department + csRbtn.getText() + "/";
					if (ITRbtn.isSelected())
						department = department + ITRbtn.getText() + "/";
					if (MechRbtn.isSelected())
						department = department + MechRbtn.getText() + "/";
					if (ENTCRbtn.isSelected())
						department = department + ENTCRbtn.getText() + "/";
					if (CivilRbtn.isSelected())
						department = department + CivilRbtn.getText() + "/";
					if ((csRbtn.isSelected() && ITRbtn.isSelected() && MechRbtn.isSelected() && ENTCRbtn.isSelected()
							&& CivilRbtn.isSelected())) {
						AllRbtn.setSelected(true);
						department = "All";
						csRbtn.setSelected(false);
						ITRbtn.setSelected(false);
						MechRbtn.setSelected(false);
						ENTCRbtn.setSelected(false);
						CivilRbtn.setSelected(false);
					} else {
						department = department.substring(0, department.length() - 1);
					}
				}
				System.out.println("Departments selected: " + department);
				addedToDatabase = DatabaseOperations.addDriveToDatabase(companyName.getText(),
						dateOfDrive.getValue().toString(), TenthMinPerc.getText(), TwelthMinPerc.getText(),
						BEMinPerc.getText(), MaxDeadBacks.getText(), MaxActiveBacks.getText(), department,
						ctcOfCompany.getText());
				if (addedToDatabase) {
					System.out.println("Drive added to database");
					AlertBoxClass.Notify("SUCCESS", "Drive added to database!");
				} else
					System.out.println("Error! Failed to add drive to database!");
			}
		} catch (Exception e) {
			AlertBoxClass.Amber("Missing Date", "You Left Date field empty!");
		}
	}

	// Event Listener on Button[#cancelDriveBtn].onAction
	@FXML
	public void backToAdminDash(ActionEvent event) throws Exception {
		ScreenPackClass.showAdminDashScreen(newDriveRootPane);
	}
}
