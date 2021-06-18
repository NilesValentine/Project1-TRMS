package MVPDAOS;

import java.util.List;

import MVPModels.GradeReference;

public interface GradingRefDAO {
	
public GradeReference getGradingReference(int gradeId);
	
	public GradeReference getGradeRefByGrade(String grade);
	
	public List<GradeReference> getAllGradingReferences();
	
	public boolean addGradingReference(GradeReference r);
	
	public boolean updateGradingReference(GradeReference rChange);
	
	public boolean deleteGradingReference(GradeReference r);

}
