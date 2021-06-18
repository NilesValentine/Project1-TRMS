package MVPModels;

public class LogisticsAndResources {
	

	private int logresId;
	private String startDate;
	private String Time;
	private String Location;
	private double Cost;
	private String gradingFormat;
	private String Type;
	private String Description;
	private String Justification;
	private double finalGrade;


	public LogisticsAndResources() {
		super();
	}

	public LogisticsAndResources(String startDate, String Time, String Location, double Cost, String gradingFormat, String Type, String Description, String Justification) {
		super();
		this.startDate = startDate;
		this.Time = Time;
		this.Location = Location;
		this.Cost = Cost;
		this.gradingFormat = gradingFormat;
		this.Type = Type;
		this.Description = Description;
		this.Justification = Justification;
	}

	public LogisticsAndResources(int logresId, String startDate, String Time, String Location, double Cost, String gradingFormat, String Type, String Description, String Justification) {
		super();
		this.logresId = logresId;
		this.startDate = startDate;
		this.Time = Time;
		this.Location = Location;
		this.Cost = Cost;
		this.gradingFormat = gradingFormat;
		this.Type = Type;
		this.Description = Description;
		this.Justification = Justification;
	}

	public int getlogresId() {
		return this.logresId;
	}

	public void setResourceId(int logresId) {
		this.logresId = logresId;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getTime() {
		return this.Time;
	}

	public void setResourceTime(String Time) {
		this.Time = Time;
	}

	public String getLocation() {
		return this.Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}

	public double getCost() {
		return this.Cost;
	}

	public void setCost(double Cost) {
		this.Cost = Cost;
	}

	public String getGradingFormat() {
		return this.gradingFormat;
	}

	public void setGradingFormat(String gradingFormatId) {
		this.gradingFormat = gradingFormatId;
	}

	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getJustification() {
		return this.Justification;
	}

	public void setJustification(String Justification) {
		this.Justification = Justification;
	}
	
	public double getFinalGrade() {
		return this.finalGrade;
	}
	
	public double setFinalGrade(double finalGrade) {
		return this.finalGrade;
	}
	
	

	
	public String toString() {
		return "LogisticsResources [resourceId=" + this.logresId + ", startDate=" + this.startDate
				+ ", Time=" + this.Time + ", Location=" + this.Location
				+ ", Cost=" + this.Cost + ", gradingFormatId=" + this.gradingFormat
				+ ", Type=" + this.Type + ", Description=" + this.Description
				+ ", Justification=" + this.Justification + ", finalGrade=" + this.finalGrade + "]";
	}

	

	
	
	
	

}
