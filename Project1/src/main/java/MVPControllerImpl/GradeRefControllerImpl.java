package MVPControllerImpl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import MVPController.GradeRefController;
import MVPModels.Employee;
import MVPModels.GradeReference;
import MVPModels.Request;
import MVPServiceImpl.GradeRefServicesImpl;
import MVPServices.GradeRefServices;

public class GradeRefControllerImpl implements GradeRefController{
	
	public GradeRefServices grs = new GradeRefServicesImpl();
	public Gson gson = new Gson();

	public GradeReference getGradingReference(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return null;
	}

	public GradeReference getGradeRefByGrade(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String grade = gson.fromJson(request.getReader(), String.class);
	
		
		GradeReference gR = grs.getGradeRefByGrade(grade);
		
		response.getWriter().append(gson.toJson(gR));
		
		return gR;
		
	}
	public void getAllGradingReference(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

	public void addRequest(HttpServletRequest request, HttpServletResponse response, Employee e)
			throws JsonSyntaxException, JsonIOException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void updateRequest(HttpServletRequest request, HttpServletResponse response, Request r)
			throws JsonSyntaxException, JsonIOException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void deleteRequest(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		// TODO Auto-generated method stub
		
	}


}
