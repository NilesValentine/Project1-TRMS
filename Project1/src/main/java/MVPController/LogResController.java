package MVPController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVPModels.LogisticsAndResources;

public interface LogResController {

	public LogisticsAndResources getLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllLogisticsByType(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void addLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void updateLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public boolean updateLogisticsGrade(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void deleteLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
