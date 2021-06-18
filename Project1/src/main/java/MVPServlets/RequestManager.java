package MVPServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import MVPController.DepartmentController;
import MVPController.LogResController;
import MVPController.EmployeeController;
import MVPController.GradeRefController;
import MVPController.ReimbursementController;
import MVPController.RequestController;
import MVPControllerImpl.DepartmentControllerImpl;
import MVPControllerImpl.LogResControllerImpl;
import MVPControllerImpl.EmployeeControllerImpl;
import MVPControllerImpl.GradeRefControllerImpl;
import MVPControllerImpl.ReimbursementControllerImpl;
import MVPControllerImpl.RequestControllerImpl;
import MVPModels.LogisticsAndResources;
import MVPModels.Employee;
import MVPModels.Request;

public class RequestManager {
	
public Gson gson = new Gson();
	

	public EmployeeController ec = new EmployeeControllerImpl();
	public RequestController rc = new RequestControllerImpl();
	public DepartmentController dc = new DepartmentControllerImpl();
	public LogResController lrc = new LogResControllerImpl();
	public ReimbursementController rbs = new ReimbursementControllerImpl();
	public GradeRefController grc = new GradeRefControllerImpl();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		
		HttpSession session = request.getSession();

		
		switch (uri) {

		case "/Project-1-TRMS/test.do": {
			response.getWriter().append("Test Success!");
			break;
		}
		
		case "/Project-1-TRMS/html/home.html": {
			System.out.println("home page now?");
			break;
		}
		
		case "/Project-1-TRMS/session.do": {
			Employee e = (Employee) session.getAttribute("loggedInUser");
			response.getWriter().append(gson.toJson(e));
			break;
		}

		case "/Project-1-TRMS/getEmployee.do": {
			System.out.println("get employee case");
			
			
			if (request.getParameter("employeeId") == null) {
				Employee e = ec.getEmployeeByEmail(request, response);
				if (e != null) {
					session.setAttribute("loggedInUser", e);
					System.out.println(session.getAttribute("loggedInUser"));
				}else {
					response.sendError(400, "Email parameter improperly formatted.");
				}
			
			} else {
				Employee e = ec.getEmployee(request, response);
				session.setAttribute("loggedInUser", e);
				System.out.println(session.getAttribute("loggedInUser"));
			}
			break;
		}

		case "/Project-1-TRMS/addEmployee.do": {
			System.out.println("add employee case");
			ec.addEmployee(request, response);
			break;
		}
		
		case "/Project-1-TRMS/updateEmployee.do": {
			System.out.println("update employee case");
			ec.updateEmployee(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getRequest.do": {
			Request r = rc.getRequest(request, response);
			session.setAttribute("request", r);
			break;
		}
		
		case "/Project-1-TRMS/getEmpRequests.do": {
			Employee e = (Employee) session.getAttribute("loggedInUser");
			rc.getAllRequestsByEmployee(request, response, e);
			break;
		}
		
		case "/Project-1-TRMS/getAllRequests.do": {
			System.out.println("get all requests case");
			rc.getAllRequests(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getAllDeptRequests.do": {
			System.out.println("get all dept requests case");
			Employee e = (Employee) session.getAttribute("loggedInUser");
			rc.getAllRequestsByDept(request, response, e);
			break;
		}
		
		case "/Project-1-TRMS/addRequest.do": {
			System.out.println("adding request");
			Employee e = (Employee) session.getAttribute("loggedInUser");
			rc.addRequest(request, response, e);
			break;
		}
		
		case "/Project-1-TRMS/getEmpReimbursements.do": {
			Employee e = (Employee) session.getAttribute("loggedInUser");
			rbs.getAllReimbursementsByEmployee(request, response, e);
			break;
		}
		
		case "/Project-1-TRMS/getAllReimbursements.do": {
			rbs.getAllReimbursements(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getDepartment.do": {
			System.out.println("getting department");
			dc.getDepartment(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getDepartmentByName.do": {
			System.out.println("getting department");
			if (request.getParameter("departmentName").equals("all")) {
				dc.getAllDepartments(request, response);
			}else {
				dc.getDepartmentByName(request, response);
			}
			break;
		}
		
		case "/Project-1-TRMS/getLogistics.do": {
			System.out.println("getting logistics");
			lrc.getLogistics(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getAllLogistics.do": {
			System.out.println("getting logistics");
			lrc.getAllLogistics(request, response);
			break;
		}
		
		case "/Project-1-TRMS/addlogres.do": {
			System.out.println("adding logistic");
			lrc.addLogistics(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getlogisticsDetails.do": {
			LogisticsAndResources l = lrc.getLogistics(request, response);;
			session.setAttribute("logistic", l);
			break;
		}
		
		case "/Project-1-TRMS/resSession.do": {
			LogisticsAndResources lr = (LogisticsAndResources) session.getAttribute("resource");
			response.getWriter().append(gson.toJson(lr));
			break;
		}
		
		case "/Project-1-TRMS/reqSession.do": {
			Request r = (Request) session.getAttribute("request");
			System.out.println(r);
			response.getWriter().append(gson.toJson(r));
			break;
		}
		
		case "/Project-1-TRMS/updateStatus.do": {
			Request r = (Request) session.getAttribute("request"); 
			rc.updateRequest(request, response, r);
			break;
		}
		
		case "/Project-1-TRMS/getGrade.do": {
			grc.getGradeRefByGrade(request, response);
			break;
		}
		
		case "/Project-1-TRMS/updateLogisticsGrade.do": {
			lrc.updateLogisticsGrade(request, response);
			break;
		}
		
		case "/Project-1-TRMS/logout.do": {
			session.invalidate();
			break;
		}
		default: {
			response.sendError(418, "Reached Default Case - Going to get some MTN dew!");
			break;
		}
		}

	}

}
