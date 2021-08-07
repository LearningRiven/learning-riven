package trainer.objects;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.gson.Gson;

import trainer.processing.Champions;
import trainer.processing.GameModes;

public class RawDataObject {

	private DateTime playDate;
	private LocalTime gameTime;
	private Integer finalLevel;
	private Integer lp;
	private Integer kills;
	private LocalTime firstItemTime;
	private Integer deaths;
	private Integer assists;
	private Integer totalGold;
	private Integer totalWards;
	private Integer riotVisionScore;
	private Integer cs;
	private Integer goldShare;
	private Integer damageShare;
	private Integer levelDifference;
	private Integer killParticipation;
	private Integer uggVisionScore;
	private Integer efficiency;
	private String gameMode;
	private String opponent;
	private Boolean wonGame;
	
	private GameModes gameModes;
	private Champions champions;
	
	DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("MM/DD/YYYY");
	DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("mm:ss");
	
	public RawDataObject() {
		this.playDate = dateTimeFormatter.parseDateTime("03/31/1996");
		this.gameTime = LocalTime.parse("30:00", timeFormatter);
		this.firstItemTime = LocalTime.parse("20:00", timeFormatter);
		this.finalLevel = 0;
		this.kills = 0;
		this.deaths = 0;
		this.assists = 0;
		this.totalGold = 0;
		this.totalWards = 0;
		this.riotVisionScore = 0;
		this.cs = 0;
		this.goldShare = 0;
		this.damageShare = 0;
		this.levelDifference = 0;
		this.killParticipation = 0;
		this.uggVisionScore = 0;
		this.efficiency = 0;
		this.gameMode = new String("N/A");
		this.opponent = new String("N/A");
		this.lp = 0;
		this.wonGame = false;
		this.gameModes = populateGameModes("listOfGameModes.json");
		this.champions = populateChampions("listOfChampions.json");
	}
	
	public RawDataObject(String playDate, String gameTime, String finalLevel, String lp, String kills,
			String deaths, String assists, String totalGold, String totalWards, String firstItemTime, 
			String riotVisionScore, String cs, String goldShare, String damageShare, String levelDifference,
			String killParticipation, String uggVisionScore, String efficiency, String gameMode, String opponent,
			String wonGame) {
		super();
		
		//Play Date
		try {
			this.playDate = dateTimeFormatter.parseDateTime(playDate);
		}
		catch(Exception e){
			e.printStackTrace();
			this.playDate = dateTimeFormatter.parseDateTime("03/31/1996");
		}
		
		//Game Time
		try {
			this.gameTime = LocalTime.parse(gameTime, timeFormatter);
		}
		catch(Exception e){
			e.printStackTrace();
			this.gameTime =LocalTime.parse("30:00", timeFormatter);
		}
		
		//First Item Time
		try {
			this.gameTime = LocalTime.parse(firstItemTime, timeFormatter);
		}
		catch(Exception e){
			e.printStackTrace();
			this.gameTime =LocalTime.parse("20:00", timeFormatter);
		}
		
		this.finalLevel = Integer.parseInt(finalLevel);
		this.kills = Integer.parseInt(kills);
		this.deaths = Integer.parseInt(deaths);
		this.assists = Integer.parseInt(assists);
		this.totalGold = Integer.parseInt(totalGold);
		this.totalWards = Integer.parseInt(totalWards);
		this.riotVisionScore = Integer.parseInt(riotVisionScore);
		this.cs = Integer.parseInt(cs);
		this.goldShare = Integer.parseInt(goldShare);
		this.damageShare = Integer.parseInt(damageShare);
		this.levelDifference = Integer.parseInt(levelDifference);
		this.killParticipation = Integer.parseInt(killParticipation);
		this.uggVisionScore = Integer.parseInt(uggVisionScore);
		this.efficiency = Integer.parseInt(efficiency);
		this.gameMode = new String(gameMode);
		this.opponent = new String(opponent);
		
		if(wonGame.equals("true")) {
			this.wonGame = true;
			this.lp = Integer.parseInt(lp);
		}
		else {
			this.wonGame = false;
			this.lp = Integer.parseInt(lp) * -1;
		}
		
		this.gameModes = populateGameModes("listOfGameModes.json");
		this.champions = populateChampions("listOfChampions.json");
	}

	public DateTime getPlayDate() {
		return playDate;
	}

	public void setPlayDate(DateTime playDate) {
		this.playDate = playDate;
	}

	public LocalTime getGameTime() {
		return gameTime;
	}

	public void setGameTime(LocalTime gameTime) {
		this.gameTime = gameTime;
	}

	public Integer getFinalLevel() {
		return finalLevel;
	}

	public void setFinalLevel(Integer finalLevel) {
		this.finalLevel = finalLevel;
	}

	public Integer getLp() {
		return lp;
	}

	public void setLp(Integer lp) {
		this.lp = lp;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}

	public LocalTime getFirstItemTime() {
		return firstItemTime;
	}

	public void setFirstItemTime(LocalTime firstItemTime) {
		this.firstItemTime = firstItemTime;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = assists;
	}

	public Integer getTotalGold() {
		return totalGold;
	}

	public void setTotalGold(Integer totalGold) {
		this.totalGold = totalGold;
	}

	public Integer getTotalWards() {
		return totalWards;
	}

	public void setTotalWards(Integer totalWards) {
		this.totalWards = totalWards;
	}

	public Integer getRiotVisionScore() {
		return riotVisionScore;
	}

	public void setRiotVisionScore(Integer riotVisionScore) {
		this.riotVisionScore = riotVisionScore;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}

	public Integer getGoldShare() {
		return goldShare;
	}

	public void setGoldShare(Integer goldShare) {
		this.goldShare = goldShare;
	}

	public Integer getDamageShare() {
		return damageShare;
	}

	public void setDamageShare(Integer damageShare) {
		this.damageShare = damageShare;
	}

	public Integer getLevelDifference() {
		return levelDifference;
	}

	public void setLevelDifference(Integer levelDifference) {
		this.levelDifference = levelDifference;
	}

	public Integer getKillParticipation() {
		return killParticipation;
	}

	public void setKillParticipation(Integer killParticipation) {
		this.killParticipation = killParticipation;
	}

	public Integer getUggVisionScore() {
		return uggVisionScore;
	}

	public void setUggVisionScore(Integer uggVisionScore) {
		this.uggVisionScore = uggVisionScore;
	}

	public Integer getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(Integer efficiency) {
		this.efficiency = efficiency;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public Boolean getWonGame() {
		return wonGame;
	}

	public void setWonGame(Boolean wonGame) {
		this.wonGame = wonGame;
	}

	public GameModes getGameModes() {
		return gameModes;
	}

	public void setGameModes(GameModes gameModes) {
		this.gameModes = gameModes;
	}

	public Champions getOpponents() {
		return champions;
	}

	public void setOpponents(Champions champions) {
		this.champions = champions;
	}

	private Champions populateChampions(String fileName){
		Champions champs = null;
		try {
		    // create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get("data/" + fileName));

		    // convert JSON file to map
		    Champions c = gson.fromJson(reader, Champions.class);

		    // close reader
		    reader.close();
		    
		    return c;

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return champs;
	}
	
	private GameModes populateGameModes(String fileName){
		GameModes modes = null;
		try {
		    // create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get("data/" + fileName));

		    // convert JSON file to map
		    GameModes gm = gson.fromJson(reader, GameModes.class);

		    // close reader
		    reader.close();
		    
		    return gm;

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return modes;
	}
	
	//For Testing
	public DateTimeFormatter getDateFormat() {
		return dateTimeFormatter;
	}
	
	public DateTimeFormatter getTimeFormat() {
		return timeFormatter;
	}
}
