package trainer.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import trainer.testrunners.JfxTestRunner;

@RunWith(JfxTestRunner.class)
public class GameStatsControllerTest{

	GameStatsController test;
	
	@Before
	public void setup() {
		test = new GameStatsController();
	}
	
	@Test
	public void processVictoryCheckboxTest() {
		CheckBox v = new CheckBox();
		CheckBox d = new CheckBox();
		
		//Test base condition, nothing selected
		test.processVictoryCheckbox(v, d);
		assertFalse("Victory not checked", v.isSelected());
		assertFalse("Defeat not checked", d.isSelected());
		
		//Test when defeat was selected
		d.setSelected(true);
		test.processVictoryCheckbox(v, d);
		assertFalse("Victory not selected", v.isSelected());
		assertTrue("Defeat is selected", d.isSelected());
		
		//Test when defeat was selected and victory was selected
		v.setSelected(true);
		test.processVictoryCheckbox(v, d);
		assertTrue("Victory is selected", v.isSelected());
		assertFalse("Defeat not selected", d.isSelected());
		
	}
	
	@Test
	public void processDefeatCheckboxTest() {
		CheckBox v = new CheckBox();
		CheckBox d = new CheckBox();
		
		//Test base condition, nothing selected
		test.processDefeatCheckbox(v, d);
		assertFalse("Victory not checked", v.isSelected());
		assertFalse("Defeat not checked", d.isSelected());
		
		//Test when victory was selected
		v.setSelected(true);
		test.processDefeatCheckbox(v, d);
		assertFalse("Defeat not selected", d.isSelected());
		assertTrue("Victory is selected", v.isSelected());
		
		//Test when victory was selected and defeat was selected
		d.setSelected(true);
		test.processDefeatCheckbox(v, d);
		assertTrue("Defeat is selected", d.isSelected());
		assertFalse("Victory not selected", v.isSelected());
	}
	
	@Test
	public void clearDateTest() {
		DatePicker date = new DatePicker();
		date.setPromptText("test");
		
		//Check that its empty
		assertNull("Date Empty At Start", date.getValue());
		
		//Test null not crashing
		boolean crashed = false;
		try {
			test.clearDate(date, date.getPromptText());
		}
		catch(Exception e){
			e.printStackTrace();
			crashed = true;
		}
		assertFalse("No value doesnt crash", crashed);
		assertEquals("Correct Prompt Text", "test", date.getPromptText());
		
		//Check the process of clearing
		date.setValue(LocalDate.of(2020, Month.JANUARY, 8));
		assertEquals("Date exists and is correct", "2020/01/08", date.getValue().format(DateTimeFormatter.ofPattern("YYYY/MM/DD")));
		test.clearDate(date, date.getPromptText());
		assertNull("Date Empty Again", date.getValue());
		assertEquals("Correct Prompt Text", "test", date.getPromptText());
	}
	
	@Test
	public void clearTextTest() {
		TextField text = new TextField();
		text.setPromptText("test");
		
		//Check that its empty
		assertEquals("Text Empty At Start", "", text.getText());

		//Test null not crashing
		boolean crashed = false;
		try {
			test.clearText(text, text.getPromptText());
		}
		catch(Exception e){
			e.printStackTrace();
			crashed = true;
		}
		assertFalse("No value doesnt crash", crashed);
		assertEquals("Correct Prompt Text", "test", text.getPromptText());
		
		
		//Check the process of clearing
		text.setText("Testing");
		assertEquals("Text exists and is correct", "Testing", text.getText());
		test.clearText(text, text.getPromptText());
		assertEquals("Text Empty Again", "", text.getText());
		assertEquals("Correct Prompt Text", "test", text.getPromptText());
	}
	
	@Test
	public void clearCheckBoxTest() {
		CheckBox chkBox = new CheckBox();
		
		//Check that its not selected
		assertFalse("CheckBox not selected at start", chkBox.isSelected());
		
		//Test null not crashing
		boolean crashed = false;
		try {
			test.clearCheckBox(chkBox);
		}
		catch(Exception e){
			e.printStackTrace();
			crashed = true;
		}
		assertFalse("No value doesnt crash", crashed);
		
		//Check the process of clearing
		chkBox.setSelected(true);
		assertTrue("CheckBox is now selected", chkBox.isSelected());
		test.clearCheckBox(chkBox);
		assertFalse("CheckBox not selected again", chkBox.isSelected());
	}
	
	@Test
	public void clearComboBoxTest() {
		ComboBox<String> cBox = new ComboBox<String>();
		
		List<String> testList = new ArrayList<String>();
		testList.add("apple");
		testList.add("orange");
		
		ObservableList<String> options = FXCollections.observableArrayList(testList);
		cBox.getItems().addAll(options);
		
		//Check that its empty
		assertEquals("ComboBox has nothing selected", null, cBox.getSelectionModel().getSelectedItem());
		
		//Test null not crashing
		boolean crashed = false;
		try {
			test.clearComboBox(cBox);
		}
		catch(Exception e){
			e.printStackTrace();
			crashed = true;
		}
		assertFalse("No value doesnt crash", crashed);
		
		//Check the process of clearing
		cBox.getSelectionModel().select("orange");
		assertEquals("ComboBox exists and is correct", "orange", cBox.getSelectionModel().getSelectedItem());
		test.clearComboBox(cBox);
		assertEquals("ComboBox Empty", null, cBox.getSelectionModel().getSelectedItem());
	}
}
