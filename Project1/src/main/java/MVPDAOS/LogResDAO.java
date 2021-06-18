package MVPDAOS;

import java.util.List;

import MVPModels.LogisticsAndResources;

public interface LogResDAO {
public LogisticsAndResources getResource(int rId);
	
	public List<LogisticsAndResources> getAllResources();
	
	public List<LogisticsAndResources> getAllResourcesByType(String type);
	
	public boolean addDevelopmentResource(LogisticsAndResources r);
	
	public boolean updateDevelopmentResource(LogisticsAndResources r);
	
	public boolean deleteDevelopmentResource(LogisticsAndResources r);

	boolean updateDevelopmentResourceGrade(LogisticsAndResources r);

}
