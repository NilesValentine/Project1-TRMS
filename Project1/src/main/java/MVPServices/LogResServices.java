package MVPServices;

import java.util.List;

import MVPModels.LogisticsAndResources;

public interface LogResServices {
	
public LogisticsAndResources getLogistics(int lrId);
	
	public List<LogisticsAndResources> getAllLogistics();
	
	public List<LogisticsAndResources> getAllLogisticsByType(String type);
	
	public boolean addLogistics(LogResServices lrs);
	
	public boolean updateLogistics(LogisticsAndResources l);
	
	public boolean updateLogisticsGrade(LogisticsAndResources l);
	
	public boolean deleteLogistics(LogisticsAndResources l);

	public LogisticsAndResources getLogistic(int getlogresId);

	

}
