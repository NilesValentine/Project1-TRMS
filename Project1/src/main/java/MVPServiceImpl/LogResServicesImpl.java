package MVPServiceImpl;

import java.util.List;

import MVPDAOImpl.LogResDAOImpl;
import MVPDAOS.LogResDAO;
import MVPModels.LogisticsAndResources;
import MVPServices.LogResServices;

public class LogResServicesImpl implements LogResServices {
	
	public LogResDAO lrDAO = new LogResDAOImpl();

	public LogisticsAndResources getLogistics(int lrId) {
		return lrDAO.getResource(lrId);
	}

	public List<LogisticsAndResources> getAllResources() {
		return lrDAO.getAllResources();
	}

	public List<LogisticsAndResources> getAllResourcesByType(String type) {
		return lrDAO.getAllResourcesByType(type);
	}

	public boolean addDevelopmentResource(LogisticsAndResources r) {
		return lrDAO.addDevelopmentResource(r);
	}

	public boolean updateDevelopmentResource(LogisticsAndResources r) {
		return lrDAO.updateDevelopmentResource(r);
	}
	public boolean updateDevelopmentResourceGrade(LogisticsAndResources r) {
		return lrDAO.updateDevelopmentResourceGrade(r);
	}

	public boolean deleteDevelopmentResource(LogisticsAndResources r) {
		return lrDAO.deleteDevelopmentResource(r);
	}

	@Override
	public List<LogisticsAndResources> getAllLogistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogisticsAndResources> getAllLogisticsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addLogistics(LogisticsAndResources l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLogistics(LogisticsAndResources l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLogisticsGrade(LogisticsAndResources l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLogistics(LogisticsAndResources l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LogisticsAndResources getLogistic(int getlogresId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addLogistics(LogResServices lrs) {
		// TODO Auto-generated method stub
		return false;
	}

	



}
