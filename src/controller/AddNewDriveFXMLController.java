package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

import java.sql.SQLException;
import alertBoxPack.AlertBoxClass;
import exceptionPack.BackLogOutOfBoundsException;
import exceptionPack.CtcOutOfBoundsException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import exceptionPack.PercentageOutOfBoundsException;
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
	public void addDriveToDatabase(ActionEvent event)
			throws NumberFormatException, ClassNotFoundException, SQLException {
//		boolean addedToDatabase;
		String department = "";
		try {
			String company = companyName.getText();
			String date = dateOfDrive.getValue().toString();
			String XthMinPerc = TenthMinPerc.getText();
			String XIIthMinPerc = TwelthMinPerc.getText();
			String BeMinPerc = BEMinPerc.getText();
			String MaxLiveBack = MaxActiveBacks.getText();
			String MaxDeadBack = MaxDeadBacks.getText();
			String ctc = ctcOfCompany.getText();

			if (!((csRbtn.isSelected() || ITRbtn.isSelected() || MechRbtn.isSelected() || ENTCRbtn.isSelected()
					|| CivilRbtn.isSelected()) || (AllRbtn.isSelected()))) {
				System.out.println("Select a Department!");
				AlertBoxClass.ErrBox("ERROR", "Select eligible departments!");
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
			}

			int i = DatabaseOperations.addDriveToDatabase(company, date, XthMinPerc, XIIthMinPerc, BeMinPerc, MaxDeadBack,
					MaxLiveBack, department, ctc);
			if(i>0) {
				AlertBoxClass.Notify("SUCCESS", company+" added to placement drive");
			}
		} catch (EmptyFieldsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "You left some fields empty!");
		} catch (PercentageOutOfBoundsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "You entered invalid percentage!");
		} catch (CtcOutOfBoundsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "You entered invalid CTC!");
		} catch (BackLogOutOfBoundsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "You entered invalid Active OR Dead Backlog!");
		} catch (NameException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "Invalid Company name entered!");
		} catch (Exception e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "Empty fields!");
		}
	}

	// Event Listener on Button[#cancelDriveBtn].onAction
	@FXML
	public void backToAdminDash(ActionEvent event) throws Exception {
		ScreenPackClass.showAdminDashScreen(newDriveRootPane);
	}
}
