package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import alertBoxPack.AlertBoxClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import model.Drive;
import model.DriveDataAccessClass;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentDashBoardFXMLController implements Initializable {
	@FXML
	private AnchorPane studDashRootPane;
	@FXML
	private TableColumn<Drive, Integer> driveID;

	@FXML
	private TableColumn<Drive, String> compName;

	@FXML
	private TableColumn<Drive, String> driveDate;

	@FXML
	private TableColumn<Drive, String> driveCTC;

	@FXML
	private TableColumn<Drive, String> driveBranch;

	@FXML
	private TableColumn<Drive, String> xthPerc;

	@FXML
	private TableColumn<Drive, String> xiiPerc;

	@FXML
	private TableColumn<Drive, String> beAvgPerc;

	@FXML
	private TableColumn<Drive, String> maxDeadbacks;

	@FXML
	private TableView<Drive> upComingDriveTabView;

	@FXML
	private TableColumn<Drive, String> maxLiveBacks;
	@FXML
	private Button applyForDriveBtn;

	@FXML
	private TableColumn<Drive, String> yourCompName;
	@FXML
	private TableColumn<Drive, String> yourDateOfDrive;
	@FXML
	private TableColumn<Drive, String> yourDriveCTC;
	@FXML
	private Button logoutbtn;
	@FXML
	private TableView<Drive> yourDriveTabView;
	private int msn;
	ObservableList<Drive> driveList;

	@FXML
	public void applyForSelectedDrive(ActionEvent event) {
		Drive drive = upComingDriveTabView.getSelectionModel().getSelectedItem();

		msn = LoginPageFXMLController.Intmsn;
		System.out.println(msn);
		boolean appliedForDrive = DatabaseOperations.applyForDrive(drive.getDID(), msn);
		if (appliedForDrive) {
			AlertBoxClass.Notify("SUCCESS", "Applied for " + drive.getDname() + " drive");
		} else {
			AlertBoxClass.Amber("ALERT", "Already applied to the drive!");
		}
		refresh();
	}

	@FXML
	public void logOut(ActionEvent event) throws Exception {
		AlertBoxClass.logOutConfirmation(studDashRootPane);
	}

	void refresh() {
		driveID.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_ID));
		compName.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_NAME));
		driveDate.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_DATE));
		driveCTC.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_CTC));
		driveBranch.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_BRANCH));
		xthPerc.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_X_MIN));
		xiiPerc.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_XII_MIN));
		beAvgPerc.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_BE_MIN));
		maxDeadbacks.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_MAX_DEAD_BACK));
		maxLiveBacks.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_MAX_LIVE_BACK));
		driveList = DatabaseOperations.getCompanyDetails();
		upComingDriveTabView.setItems(driveList);

		yourCompName.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_NAME));
		yourDateOfDrive.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_DATE));
		yourDriveCTC.setCellValueFactory(new PropertyValueFactory<>(DriveDataAccessClass.Constants.COMP_CTC));
		driveList = DatabaseOperations.getYourDriveDetails(LoginPageFXMLController.Intmsn);
		yourDriveTabView.setItems(driveList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refresh();
	}
}
