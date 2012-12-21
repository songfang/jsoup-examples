package net.gosmarter.webcrawler;

import java.io.IOException;
import java.util.List;


public interface AwardMovieManager {
	enum AwardCategory {
		BestPicture, BestDirector, BestActor, BestActress, BestForeignMovie
	};

	List<AwardMovie> getList(AwardYear awardYear) throws IOException;
}
