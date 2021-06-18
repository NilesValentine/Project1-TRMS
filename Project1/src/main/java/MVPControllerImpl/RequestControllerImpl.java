package MVPControllerImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import MVPController.RequestController;
import MVPModels.Employee;
import MVPModels.Request;
import MVPServiceImpl.RequestServicesImpl;
import MVPServices.RequestServices;

public class RequestControllerImpl implements RequestController {
	
	private RequestServices rs = new RequestServicesImpl();
	private static Gson gson = new Gson();

	public Request getRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Request r = gson.fromJson(request.getReader(), Request.class);
		
		Request req = rs.getRequest(r.getRequestId());
		System.out.println(req);
		
		response.getWriter().append(gson.toJson(req));
		
		if (req != null) {
			return req;
		}else {
			return null;
		}
	}

	public void getAllRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Request> reqList = rs.getAllRequests();
		
		response.getWriter().append(gson.toJson(reqList));
	}

	public void getAllRequestsByEmployee(HttpServletRequest request, HttpServletResponse response, Employee e) throws IOException {
		int id = e.getEmployeeId();
		
		System.out.println(id);

		List<Request> reqList = rs.getAllRequestsByEmployee(id);
		System.out.println(reqList);
		
		response.getWriter().append(gson.toJson(reqList));
	}

	public void getAllRequestsByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("status");
		
		System.out.println(input);
		
		String status;
		
		try {
			status = input.toString();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID paramter incorrectly formatted.");
			return;
		}
		
		List<Request> reqList = rs.getAllRequestsByStatus(status);
		System.out.println(reqList);
		
		response.getWriter().append(gson.toJson(reqList));
	}
	
	public void getAllRequestsByDept(HttpServletRequest request, HttpServletResponse response, Employee e) throws JsonSyntaxException, JsonIOException, IOException {
		int superId = e.getEmployeeId();
		
		List<Request> reqList= rs.getAllDeptRequests(superId);
		
		response.getWriter().append(gson.toJson(reqList));
		
	}

	public void addRequest(HttpServletRequest request, HttpServletResponse response, Employee e) throws JsonSyntaxException, JsonIOException, IOException {
		
		Request r = gson.fromJson(request.getReader(), Request.class);
		
		rs.addRequest(e.getEmployeeId(), r.getIsUrgent());
		
		response.getWriter().append("Request Added");
		
	}

	public void updateRequest(HttpServletRequest request, HttpServletResponse response, Request r) throws JsonSyntaxException, JsonIOException, IOException {
		Request req = gson.fromJson(request.getReader(), Request.class);
		
		// Set session request to request body's updatedStatus
		r.setStatus(req.getStatus());
		
		rs.updateRequest(r);
		
		response.getWriter().append(gson.toJson(r));
	}

	public void deleteRequest(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		Request r = gson.fromJson(request.getReader(), Request.class);
		
		rs.deleteRequest(r);
		
		response.getWriter().append("Request Deleted");
		
	}
	


}
