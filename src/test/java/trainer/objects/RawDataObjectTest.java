package trainer.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.joda.time.LocalTime;
import org.junit.Test;

public class RawDataObjectTest {
	
	@Test
	public void testDefault() {
		RawDataObject test = new RawDataObject();
	
		assertEquals("Final Level", Integer.valueOf(0), test.getFinalLevel());
		assertEquals("Kills", Integer.valueOf(0), test.getKills());
		assertEquals("Deaths", Integer.valueOf(0), test.getDeaths());
		assertEquals("Assists", Integer.valueOf(0), test.getAssists());
		assertEquals("Total Gold", Integer.valueOf(0), test.getTotalGold());
		assertEquals("Total Wards", Integer.valueOf(0), test.getTotalWards());
		assertEquals("Riot Vision Score", Integer.valueOf(0), test.getRiotVisionScore());
		assertEquals("CS", Integer.valueOf(0), test.getCs());
		assertEquals("Gold Share", Integer.valueOf(0), test.getGoldShare());
		assertEquals("Damage Share", Integer.valueOf(0), test.getDamageShare());
		assertEquals("Level Difference", Integer.valueOf(0), test.getLevelDifference());
		assertEquals("Kill Participation", Integer.valueOf(0), test.getKillParticipation());
		assertEquals("UGG Vision Score", Integer.valueOf(0), test.getUggVisionScore());
		assertEquals("Efficiency", Integer.valueOf(0), test.getEfficiency());
		assertEquals("Game Mode", "N/A", test.getGameMode());
		assertEquals("Opponent", "N/A", test.getOpponent());
		assertFalse("Won Game", test.getWonGame());
		assertEquals("Play Date", test.getDateFormat().parseDateTime("03/31/1996"), test.getPlayDate());
		assertEquals("Game Time", LocalTime.parse("30:00", test.getTimeFormat()), test.getGameTime());
		assertEquals("First Item Time", LocalTime.parse("20:00", test.getTimeFormat()), test.getFirstItemTime());
	}
	
	@Test
	public void testFullConstructorSimple() {
		RawDataObject obj = createDefaultTestItem();
		
		assertEquals("Final Level", Integer.valueOf(15), obj.getFinalLevel());
		assertEquals("Kills", Integer.valueOf(20), obj.getKills());
		assertEquals("Deaths", Integer.valueOf(5), obj.getDeaths());
		assertEquals("Assists", Integer.valueOf(10), obj.getAssists());
		assertEquals("Total Gold", Integer.valueOf(21245), obj.getTotalGold());
		assertEquals("Total Wards", Integer.valueOf(15), obj.getTotalWards());
		assertEquals("Riot Vision Score", Integer.valueOf(21), obj.getRiotVisionScore());
		assertEquals("CS", Integer.valueOf(200), obj.getCs());
		assertEquals("Gold Share", Integer.valueOf(81), obj.getGoldShare());
		assertEquals("Damage Share", Integer.valueOf(82), obj.getDamageShare());
		assertEquals("Level Difference", Integer.valueOf(83), obj.getLevelDifference());
		assertEquals("Kill Participation", Integer.valueOf(84), obj.getKillParticipation());
		assertEquals("UGG Vision Score", Integer.valueOf(85), obj.getUggVisionScore());
		assertEquals("Efficiency", Integer.valueOf(86), obj.getEfficiency());
		assertEquals("Game Mode", "Ranked Solo/Duo", obj.getGameMode());
		assertEquals("Opponent", "Renekton", obj.getOpponent());
	}
	
	@Test
	public void testFullConstructorDates() {
		//TODO
	}
	
	@Test
	public void testFullConstructorLP() {
		//TODO
	}
	
	@Test
	public void testFullConstructorBadNumberFormats() {
		//TODO
	}
	
	private RawDataObject createDefaultTestItem() {
		String playDate = "03/25/2021";
		String gameTime = "23:45";
		String finalLevel = "15";
		String lp = "12";
		String kills = "20";
		String deaths =  "5";
		String assists = "10";
		String totalGold = "21245";
		String totalWards = "15";
		String firstItemTime = "11:25";
		String riotVisionScore = "21";
		String cs = "200";
		String goldShare = "81";
		String damageShare = "82";
		String levelDifference = "83";
		String killParticipation = "84";
		String uggVisionScore = "85";
		String efficiency = "86";
		String gameMode = "Ranked Solo/Duo";
		String opponent = "Renekton";
		String wonGame = "true";
		
		RawDataObject obj = new RawDataObject(playDate, gameTime, finalLevel, lp, kills, deaths, 
				assists, totalGold, totalWards, firstItemTime, riotVisionScore, cs, goldShare, 
				damageShare, levelDifference, killParticipation, uggVisionScore, efficiency, gameMode, opponent, 
				wonGame);
		
		return obj;
	}
}
