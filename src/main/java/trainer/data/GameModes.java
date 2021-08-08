package trainer.data;

import java.util.Arrays;
import java.util.List;

public class GameModes {
	
	static final String BLIND = "Blind Pick";
	static final String DRAFT = "Draft Pick";
	static final String SOLO  = "Ranked Solo/Duo";
	static final String FLEX  = "Ranked Flex";
	
	public List<String> getAllGameModes(){
		List<String> allGameModes = Arrays.asList(
			BLIND,DRAFT,SOLO,FLEX
		);
		
		return allGameModes;
	}
}
