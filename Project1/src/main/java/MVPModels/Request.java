package MVPModels;

public class Request {
	
	private int requestId;
	private String submitDate;
	private int isUrgent;
	private String status;
	private String lastUpdated;
	private int employeeId;
	private int devResource;

	public Request() {
		super();
	}

	public Request(String submitDate, int isUrgent, String status, String lastUpdated, int employeeId, int devResource) {
		super();
		this.submitDate = submitDate;
		this.isUrgent = isUrgent;
		this.status = status;
		this.lastUpdated = lastUpdated;
		this.employeeId = employeeId;
		this.devResource = devResource;
	}

	public Request(int requestId, String submitDate, int isUrgent, String status, int employeeId, int devResource, String lastUpdated) {
		super();
		this.requestId = requestId;
		this.submitDate = submitDate;
		this.isUrgent = isUrgent;
		this.status = status;
		this.lastUpdated = lastUpdated;
		this.employeeId = employeeId;
		this.devResource = devResource;
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public int getIsUrgent() {
		return this.isUrgent;
	}

	public void setIsUrgent(int isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLastUpdated() {
		return this.lastUpdated;
	}
	
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getDevResource() {
		return this.devResource;
	}

	public void setDevResource(int devResource) {
		this.devResource = devResource;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + this.requestId + ", submitDate=" + this.submitDate + ", isUrgent="
				+ this.isUrgent + ", status=" + this.status + ", lastUpdated=" + this.lastUpdated + ", employeeId=" + this.employeeId + ", devResource="
				+ this.devResource + "]";
	}

}
