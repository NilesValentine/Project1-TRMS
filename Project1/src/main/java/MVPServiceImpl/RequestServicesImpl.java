package MVPServiceImpl;

import java.util.List;

import MVPDAOImpl.RequestDAOImpl;
import MVPDAOS.RequestDAO;
import MVPModels.Request;
import MVPServices.RequestServices;

public class RequestServicesImpl implements RequestServices {
	
	public RequestDAO rr = new RequestDAOImpl();

	public Request getRequest(int reqId) {
		return rr.getRequest(reqId);
	}

	public List<Request> getAllRequests() {
		return rr.getAllRequests();
	}

	public List<Request> getAllRequestsByEmployee(int empId) {
		return rr.getAllRequestsByEmployee(empId);
	}

	public List<Request> getAllRequestsByStatus(String status) {
		return rr.getAllRequestsByStatus(status);
	}
	
	public List<Request> getAllDeptRequests(int superId) {
		return rr.getAllDeptRequests(superId);
	}

	public boolean addRequest(int employeeId, int urgency) {
		return rr.addRequest(employeeId, urgency);
	}

	public boolean updateRequest(Request reqChange) {
		return rr.updateRequest(reqChange);
	}

	public boolean deleteRequest(Request request) {
		return rr.deleteRequest(request);
	}

}
