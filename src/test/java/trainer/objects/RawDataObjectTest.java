package trainer.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		RawDataObject obj = createDefaultTestItem("1/1/2021", "30:00", "30:00", "true", "1");
		
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
		//Test Good Entry
		RawDataObject obj = createDefaultTestItem("2/2/2022", "40:10", "30:20", "true", "1");
		
		assertEquals("Play Date Year", 2022, obj.getPlayDate().getYear());
		assertEquals("Play Date Month", 1, obj.getPlayDate().getMonthOfYear());
		assertEquals("Play Date Day", 2, obj.getPlayDate().getDayOfMonth());
		
		
		assertEquals("Game Time Hour", 0, obj.getGameTime().getHourOfDay());
		assertEquals("Game Time Minute", 40, obj.getGameTime().getMinuteOfHour());
		assertEquals("Game Time Seconds", 10, obj.getGameTime().getSecondOfMinute());
		assertEquals("Game Time Milliseconds", 0, obj.getGameTime().getMillisOfSecond());
		
		assertEquals("First Item Hour", 0, obj.getFirstItemTime().getHourOfDay());
		assertEquals("First Item Minute", 30, obj.getFirstItemTime().getMinuteOfHour());
		assertEquals("First Item Seconds", 20, obj.getFirstItemTime().getSecondOfMinute());
		assertEquals("First Item Milliseconds", 0, obj.getFirstItemTime().getMillisOfSecond());
		
		//Test Bad Entries
		obj = createDefaultTestItem("apple", "apple", "apple", "true", "1");
		assertEquals("Play Date", obj.getDateFormat().parseDateTime("03/31/1996"), obj.getPlayDate());
		assertEquals("Game Time", LocalTime.parse("30:00", obj.getTimeFormat()), obj.getGameTime());
		assertEquals("First Item Time", LocalTime.parse("20:00", obj.getTimeFormat()), obj.getFirstItemTime());
		
		obj = createDefaultTestItem("1-2-3333", "05:02:20", "07:20:30", "true", "1");
		assertEquals("Play Date", obj.getDateFormat().parseDateTime("03/31/1996"), obj.getPlayDate());
		assertEquals("Game Time", LocalTime.parse("30:00", obj.getTimeFormat()), obj.getGameTime());
		assertEquals("First Item Time", LocalTime.parse("20:00", obj.getTimeFormat()), obj.getFirstItemTime());
		
	}
	
	@Test
	public void testFullConstructorWinLP() {
		RawDataObject obj;
		
		//Test Good Win Positive Value
		obj = createDefaultTestItem("1/1/2021", "30:00", "30:00", "true", "10");
		assertTrue("Won", obj.getWonGame());
		assertEquals("Correct LP", Integer.valueOf(10), obj.getLp());
		
		//Test Good Win Negative Value
		obj = createDefaultTestItem("1/1/2021", "30:00", "30:00", "true", "-10");
		assertTrue("Won", obj.getWonGame());
		assertEquals("Correct LP", Integer.valueOf(10), obj.getLp());
	}
	
	@Test
	public void testFullConstructorLossLP() {
		//Test Good Win
		RawDataObject obj;
		
		//Test Good Loss Negative Value
		obj = createDefaultTestItem("1/1/2021", "30:00", "30:00", "false", "-10");
		assertFalse("Lost", obj.getWonGame());
		assertEquals("Correct LP", Integer.valueOf(-10), obj.getLp());
		
		//Test Good Loss Positive Value
		obj = createDefaultTestItem("1/1/2021", "30:00", "30:00", "false", "10");
		assertFalse("Lost", obj.getWonGame());
		assertEquals("Correct LP", Integer.valueOf(-10), obj.getLp());
	}
	
	private RawDataObject createDefaultTestItem(String playDate, String gameTime, String firstItemTime, String wonGame, String lp) {
		String finalLevel = "15";
		String kills = "20";
		String deaths =  "5";
		String assists = "10";
		String totalGold = "21245";
		String totalWards = "15";
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
		
		RawDataObject obj = new RawDataObject(playDate, gameTime, finalLevel, lp, kills, deaths, 
				assists, totalGold, totalWards, firstItemTime, riotVisionScore, cs, goldShare, 
				damageShare, levelDifference, killParticipation, uggVisionScore, efficiency, gameMode, opponent, 
				wonGame);
		
		return obj;
	}
}
