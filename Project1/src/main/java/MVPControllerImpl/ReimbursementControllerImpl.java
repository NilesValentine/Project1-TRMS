package MVPControllerImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import MVPController.ReimbursementController;
import MVPModels.Employee;
import MVPModels.Reimbursement;
import MVPServiceImpl.ReimbursementsServicesImpl;
import MVPServices.ReimbursementServices;

public class ReimbursementControllerImpl implements ReimbursementController {
	
	public Gson gson = new Gson();
	public ReimbursementServices rs = new ReimbursementsServicesImpl();

	public Reimbursement getReimbursement(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	public List<Reimbursement> getAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Reimbursement> allRems = rs.getAllReimbursements();
		
		response.getWriter().append(gson.toJson(allRems));
		return null;
	}

	public List<Reimbursement> getAllReimbursementsByEmployee(HttpServletRequest request,
			HttpServletResponse response, Employee e) throws IOException {
		List<Reimbursement> remList = rs.getAllReimbursementsByEmployee(e.getEmployeeId());
		
		response.getWriter().append(gson.toJson(remList));
		return null;
	}

	public boolean addReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
