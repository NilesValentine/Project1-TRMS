package MVPServiceImpl;

import java.util.List;

import MVPDAOImpl.GradeRefDAOImpl;
import MVPDAOS.GradingRefDAO;
import MVPModels.GradeReference;
import MVPServices.GradeRefServices;

public class GradeRefServicesImpl implements GradeRefServices {
	
	public GradingRefDAO grr = new GradeRefDAOImpl();

	public GradeReference getGradingReference(int gradeId) {
		return grr.getGradingReference(gradeId);
	}
	
	public GradeReference getGradeRefByGrade(String grade) {
		return grr.getGradeRefByGrade(grade);
	}

	public List<GradeReference> getAllGradingReferences() {
		return grr.getAllGradingReferences();
	}

	public boolean addGradingReference(GradeReference r) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateGradingReference(GradeReference rChange) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteGradingReference(GradeReference r) {
		// TODO Auto-generated method stub
		return false;
	}

}
