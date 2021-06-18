package MVPController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import MVPModels.Employee;
import MVPModels.GradeReference;
import MVPModels.Request;

public interface GradeRefController {
	
public GradeReference getGradingReference(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public GradeReference getGradeRefByGrade(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllGradingReference(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	
	
    public void addRequest(HttpServletRequest request, HttpServletResponse response, Employee e) throws JsonSyntaxException, JsonIOException, IOException;
	
	public void updateRequest(HttpServletRequest request, HttpServletResponse response, Request r) throws JsonSyntaxException, JsonIOException, IOException;
	
	public void deleteRequest(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException;


}
