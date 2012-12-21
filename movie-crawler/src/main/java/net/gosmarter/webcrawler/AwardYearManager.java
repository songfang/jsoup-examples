package net.gosmarter.webcrawler;

import java.io.IOException;
import java.util.List;


public interface AwardYearManager {
	List<AwardYear> getList() throws IOException;
}
