package trainer.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import trainer.data.Champions;
import trainer.data.GameModes;
import trainer.objects.GameStatsObject;

public class GameStatsController implements Initializable{
	
	static Logger logger = Logger.getLogger(GameStatsController.class.getName());

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
	private CheckBox mVictory, mDefeat;
	
	private Champions champs = new Champions();
	private GameModes gameModes = new GameModes();
	
	GameStatsObject obj;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		obj = new GameStatsObject();
		
		ObservableList<String> gameModeOptions = FXCollections.observableArrayList(gameModes.getAllGameModes());
		ObservableList<String> championOptions = FXCollections.observableArrayList(champs.getAllChampions());
		
		mGameMode.getItems().addAll(gameModeOptions);
		mOpponent.getItems().addAll(championOptions);
		
		mVictory.setSelected(false);
		mDefeat.setSelected(false);
	}
	
	public void onCheckboxChange(ActionEvent event) {
		final Node source = (Node) event.getSource();
		String id = source.getId().toLowerCase();
		
		if(id.contains("victory")) {
			processVictoryCheckbox(mVictory, mDefeat);
		}
		else {
			processDefeatCheckbox(mVictory, mDefeat);
		}
	}
	
	public void processVictoryCheckbox(CheckBox mVictory, CheckBox mDefeat) {
		if(mVictory.isSelected()) {
			mDefeat.setSelected(false);
		}
	}
	
	public void processDefeatCheckbox(CheckBox mVictory, CheckBox mDefeat) {
		if(mDefeat.isSelected()) {
			mVictory.setSelected(false);
		}
	}
	
	public void onAdd(ActionEvent e) {
		final String val = System.getProperty("riotKey");
		System.out.println(val);
	}
	
	public void onClear(ActionEvent e) {
		logger.info("Starting the clearing process");
		
		clearDate(mPlayDate, mPlayDate.getPromptText());
		logger.info("Cleared all dates");
		
		clearText(mGameTime,mGameTime.getPromptText());
		clearText(mFinalLevel,mFinalLevel.getPromptText());
		clearText(mLP,mLP.getPromptText());
		clearText(mKills,mKills.getPromptText());
		clearText(mFirstItemTime,mFirstItemTime.getPromptText());
		clearText(mDeaths,mDeaths.getPromptText());
		clearText(mAssists,mAssists.getPromptText());
		clearText(mTotalGold,mTotalGold.getPromptText());
		clearText(mWards,mWards.getPromptText());
		clearText(mRiotVisionScore,mRiotVisionScore.getPromptText());
		clearText(mCS,mCS.getPromptText());
		logger.info("Cleared all standard Text Stats");
		
		clearText(mGoldShare,mGoldShare.getPromptText());
		clearText(mDamageShare,mDamageShare.getPromptText());
		clearText(mLevelDifference,mLevelDifference.getPromptText());
		clearText(mKillParticipation,mKillParticipation.getPromptText());
		clearText(mUGGVisionScore,mUGGVisionScore.getPromptText());
		clearText(mEfficiency,mEfficiency.getPromptText());
		logger.info("Cleared all U.GG Text Stats");
		
		clearCheckBox(mVictory);
		clearCheckBox(mDefeat);
		logger.info("Cleared all Checkboxes");
		
		clearComboBox(mGameMode);
		clearComboBox(mOpponent);
		logger.info("Cleared all combo boxes");
		
		obj = new GameStatsObject();
	}
	
	public void clearDate(DatePicker picker, String promptText) {
		if(isNotNull(picker.toString())){
			picker.setValue(null);
			picker.setPromptText(promptText);
		}
	}
	
	public void clearText(TextField txt, String promptText) {
		if(isNotNull(txt.getText())) {
			txt.setText("");
			txt.setPromptText(promptText);
		}
	}
	
	public void clearCheckBox(CheckBox chkbox) {
		String value = chkbox.isSelected() ? "true" : "";
		if(isNotNull(value)) {
			chkbox.setSelected(false);
		}
	}
	
	public void clearComboBox(ComboBox<String> comBox) {
		if(isNotNull(comBox.getValue())){
			comBox.getSelectionModel().clearSelection();
		}
	}
	
	private boolean isNotNull(Object value) {
		if(value == null || value.equals("")) {
			return false;
		}
		return true;
	}

	

}
