package MVPModels;

public class GradeReference {
	
	private int gradeId;
	private String grade;
	private int	passing;
	private String gradeFormat;
	
	public GradeReference() {
		super();
	}

	public GradeReference(String grade, int passing, String gradeFormat) {
		super();
		this.grade = grade;
		this.passing = passing;
		this.gradeFormat = gradeFormat;
	}

	public GradeReference(int gradeId, String grade, int passing, String gradeFormat) {
		super();
		this.gradeId = gradeId;
		this.grade = grade;
		this.passing = passing;
		this.gradeFormat = gradeFormat;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	@Override
	public String toString() {
		return "GradingReferences [gradeId=" + gradeId + ", grade=" + grade + ", passing=" + passing
				+ ", gradeFormat=" + gradeFormat + "]";

}
	
}
