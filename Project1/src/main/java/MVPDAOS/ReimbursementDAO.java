package MVPDAOS;

import java.util.List;

import MVPModels.Reimbursement;

public interface ReimbursementDAO {
	
public Reimbursement getReimbursement(int paymentId);
	
	public List<Reimbursement> getAllReimbursementsByEmployee(int empId);
	
	public List<Reimbursement> getAllReimbursements();
	
	public boolean addReimbursement(Reimbursement r);
	
	public boolean updateReimbursement(Reimbursement rChange);
	
	public boolean deleteReimbursement(Reimbursement r);

}
