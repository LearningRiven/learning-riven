package trainer.controllers;

import java.awt.Checkbox;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RawDataEntryController implements Initializable{

	@FXML
	private DatePicker mPlayDate;
	
	@FXML
	private TextField
	mGameTime, mFinalLevel, mLP, 
	mKills, mFirstItemTime, mDeaths, mAssists, mTotalGold, mWards, mRiotVisionScore, mCS, 
	mGoldShare, mDamageShare, mLevelDifference, mKillParticipation, mUGGVisionScore, mEfficiency;
	
	@FXML
	private ComboBox<String> mGameMode, mOpponent;
	
	@FXML
	private Checkbox mVictory, mDefeat;
	

	//Initialization
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
	public void onAdd(ActionEvent e) {
		System.out.println("adding");
	}
	
	@FXML
	public void onClear(ActionEvent e) {
		System.out.println("clearing");
	}


}
