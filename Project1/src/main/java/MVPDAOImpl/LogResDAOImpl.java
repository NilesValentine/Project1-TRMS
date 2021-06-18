package MVPDAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MVPDAOS.LogResDAO;
import MVPModels.LogisticsAndResources;
import utilities.JDBCConnection;

public class LogResDAOImpl implements LogResDAO {
	
	public Connection conn = JDBCConnection.getConnection();
	
	public LogisticsAndResources getResource(int lrId) {
		
		try {
			
			String sql = "select * from logistics where logresid = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(lrId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				LogisticsAndResources lr = new LogisticsAndResources();
				
				lr.setResourceId(rs.getInt("logresid"));
				lr.setStartDate(rs.getString("startdate"));
				lr.setResourceTime(rs.getString("logrestime"));
				lr.setLocation(rs.getString("logreslocation"));
				lr.setCost(rs.getInt("logrescost"));
				lr.setGradingFormat(rs.getString("gradeformat"));
				lr.setType(rs.getString("logrestype"));
				lr.setDescription(rs.getString("description"));
				lr.setJustification(rs.getString("justification"));
				
				return lr;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LogisticsAndResources> getAllResources() {
		
		List<LogisticsAndResources> resList = new ArrayList<LogisticsAndResources>();
		
		try {
			
			String sql = "select * from logistics";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
             LogisticsAndResources lr = new LogisticsAndResources();
				
				lr.setResourceId(rs.getInt("logresid"));
				lr.setStartDate(rs.getString("startdate"));
				lr.setResourceTime(rs.getString("logrestime"));
				lr.setLocation(rs.getString("logreslocation"));
				lr.setCost(rs.getInt("logrescost"));
				lr.setGradingFormat(rs.getString("gradeformat"));
				lr.setType(rs.getString("logrestype"));
				lr.setDescription(rs.getString("description"));
				lr.setJustification(rs.getString("justification"));
				
				resList.add(lr);
			}
			return resList;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LogisticsAndResources> getAllResourcesByType(String type) {
	
		List<LogisticsAndResources> resList = new ArrayList<LogisticsAndResources>();
		
		try {
			
			String sql = "select * from logistics where status = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
            LogisticsAndResources lr = new LogisticsAndResources();
				
				lr.setResourceId(rs.getInt("logresid"));
				lr.setStartDate(rs.getString("startdate"));
				lr.setResourceTime(rs.getString("logrestime"));
				lr.setLocation(rs.getString("logreslocation"));
				lr.setCost(rs.getInt("logrescost"));
				lr.setGradingFormat(rs.getString("gradeformat"));
				lr.setType(rs.getString("logrestype"));
				lr.setDescription(rs.getString("description"));
				lr.setJustification(rs.getString("justification"));
				
				resList.add(lr);
			}
			return resList;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addDevelopmentResource(LogisticsAndResources r) {
		
		try {
			
			String sql = "call add_logistics(?, ?, ?, ?, ?, ?, ?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, r.getStartDate());
			cs.setString(2, r.getTime());
			cs.setString(3, r.getLocation());
			cs.setString(4, Double.toString(r.getCost()));
			cs.setString(5, r.getGradingFormat());
			cs.setString(6, r.getType());
			cs.setString(7, r.getDescription());
			cs.setString(8, r.getJustification());
			
			boolean success = cs.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateDevelopmentResource(LogisticsAndResources r) {
		
		try {
			
			String sql = "update logistics set startdate = ?, logrestime = ?, logreslocation = ?, logrescost = ?, graeformat = ?, logresType = ?, description = ?, justification = ?, finalgrade = ? where logresid = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, r.getStartDate().toString());
			ps.setString(2, r.getTime().toString());
			ps.setString(3, r.getLocation());
			ps.setString(4, Double.toString(r.getCost()));
			ps.setString(5, r.getGradingFormat());
			ps.setString(6, r.getType());
			ps.setString(7, r.getDescription());
			ps.setString(8, r.getJustification());
			ps.setString(9, Double.toString(r.getFinalGrade()));
			ps.setString(10, Integer.toString(r.getlogresId()));
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateDevelopmentResourceGrade(LogisticsAndResources r) {
		
		try {
			
			String sql = "update logistics set finalgrade = ? where logresid = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Double.toString(r.getFinalGrade()));
			ps.setString(2, Integer.toString(r.getlogresId()));
			
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteDevelopmentResource(LogisticsAndResources r) {
		
		try {
			
			String sql = "delete logistics where logresid = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(r.getlogresId()));
			
			boolean success = ps.execute();
			
			return success;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
