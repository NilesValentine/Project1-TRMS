package MVPServiceImpl;

import java.util.List;

import MVPDAOImpl.ReimbursementDAOImpl;
import MVPDAOS.ReimbursementDAO;
import MVPModels.Reimbursement;
import MVPServices.ReimbursementServices;

public class ReimbursementsServicesImpl implements ReimbursementServices {
	
	public ReimbursementDAO rr = new ReimbursementDAOImpl();

	public Reimbursement getReimbursement(int paymentId) {
		return rr.getReimbursement(paymentId);
	}

	public List<Reimbursement> getAllReimbursements() {
		return rr.getAllReimbursements();
	}

	public List<Reimbursement> getAllReimbursementsByEmployee(int empId) {
		return rr.getAllReimbursementsByEmployee(empId);
	}

	public boolean addReimbursement(Reimbursement r) {
		return rr.addReimbursement(r);
	}

	public boolean updateReimbursement(Reimbursement reqChange) {
		return rr.updateReimbursement(reqChange);
	}

	public boolean deleteReimbursement(Reimbursement request) {
		return rr.deleteReimbursement(request);
	}

}
