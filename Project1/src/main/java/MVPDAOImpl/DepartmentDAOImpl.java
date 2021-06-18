package MVPDAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MVPDAOS.DepartmentDAO;
import MVPModels.Department;
import utilities.JDBCConnection;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	public Connection conn = JDBCConnection.getConnection();
	
	public Department getDepartment(int deptId) {
		
		try {
			
			String sql = "select * from departments where department_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(deptId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Department d = new Department();
				
				d.setDepartmentId(rs.getInt("department_id"));
				d.setDepartmentName(rs.getString("department_name"));
				d.setDepartmentHead(rs.getInt("department_head"));
				
				return d;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Department getDepartmentByName(String deptName) {
		
		try {
			
			String sql = "select * from departments where department_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, deptName);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Department d = new Department();
				
				d.setDepartmentId(rs.getInt("department_id"));
				d.setDepartmentName(rs.getString("department_name"));
				d.setDepartmentHead(rs.getInt("department_head"));
				
				return d;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Department> getAllDepartments() {
		List<Department> deptList = new ArrayList<Department>();
		
		try {
			String sql = "select * from departments order by department_id";
			
			PreparedStatement ps  = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Department d = new Department();
				
				d.setDepartmentId(rs.getInt("department_id"));
				d.setDepartmentName(rs.getString("department_name"));
				d.setDepartmentHead(rs.getInt("department_head"));
				
				deptList.add(d);
			}
			return deptList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addDepartment(Department dept) {
		
		try {
			
			String sql= "call add_department(?, ?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(dept.getDepartmentId()));
			cs.setString(2, dept.getDepartmentName());
			cs.setString(3, Integer.toString(dept.getDepartmentHead()));
			
			boolean success = cs.execute();
			
			return success;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateDepartment(Department deptChange) {
		
		try {
			
			String sql = "update departments set department_name = ?, department_head = ? where department_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, deptChange.getDepartmentName());
			ps.setString(2, Integer.toString(deptChange.getDepartmentHead()));
			ps.setString(3, Integer.toString(deptChange.getDepartmentId()));
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteDepartment(Department dept) {
		
		try {
			
			String sql = "delete departments where department_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(dept.getDepartmentId()));
			
			boolean success = ps.execute();
			
			return success;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	
}
