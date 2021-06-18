package MVPDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MVPDAOS.GradingRefDAO;
import MVPModels.GradeReference;
import utilities.JDBCConnection;

public class GradeRefDAOImpl implements GradingRefDAO {
	
	Connection conn = JDBCConnection.getConnection();

	public GradeReference getGradingReference(int gradeId) {
		
		try {
			
			String sql = "select * from grading_references where grade_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(gradeId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				GradeReference gr = new GradeReference();
				
				gr.setGradeId(rs.getInt("grade_id"));
				gr.setGrade(rs.getString("grade"));
				gr.setPassing(rs.getInt("passing"));
				gr.setGradeFormat(rs.getString("grade_format"));
				
				return gr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public GradeReference getGradeRefByGrade(String grade) {
		
			try {
			
			String sql = "select * from grading_references where grade = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, grade);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				GradeReference gr = new GradeReference();
				
				gr.setGradeId(rs.getInt("grade_id"));
				gr.setGrade(rs.getString("grade"));
				gr.setPassing(rs.getInt("passing"));
				gr.setGradeFormat(rs.getString("grade_format"));
				
				return gr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<GradeReference> getAllGradingReferences() {
		List<GradeReference> grList = new ArrayList<GradeReference>();
		try {
			
			String sql = "select * from grading_references";
			
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				GradeReference gr = new GradeReference();
				
				gr.setGradeId(rs.getInt("grade_id"));
				gr.setGrade(rs.getString("grade"));
				gr.setPassing(rs.getInt("passing"));
				gr.setGradeFormat(rs.getString("grade_format"));
				
				grList.add(gr);
			}
			return grList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean addGradingReference(GradeReference r) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateGradingReference(GradeReference rChange) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteGradingReference(GradeReference r) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
