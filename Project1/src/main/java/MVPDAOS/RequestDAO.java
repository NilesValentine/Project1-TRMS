package MVPDAOS;

import java.util.List;

import MVPModels.Request;

public interface RequestDAO {
	
public Request getRequest(int reqId);
	
	public List<Request> getAllRequests();
	
	public List<Request> getAllRequestsByEmployee(int empId);
	
	public List<Request> getAllRequestsByStatus(String status);
	
	public List<Request> getAllDeptRequests(int superId);
	
	public boolean addRequest(int employeeId, int urgency);
	
	public boolean updateRequest(Request reqChange);
	
	public boolean deleteRequest(Request request);

}
