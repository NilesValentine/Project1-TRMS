package MVPControllerImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import MVPController.LogResController;
import MVPModels.LogisticsAndResources;
import MVPServiceImpl.LogResServicesImpl;
import MVPServices.LogResServices;

public class LogResControllerImpl implements LogResController {
	
	public LogResServices lrs = new LogResServicesImpl();
	public Gson gson = new Gson();

	public LogisticsAndResources getLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		LogisticsAndResources d = gson.fromJson(request.getReader(), LogisticsAndResources.class);
		
		d = lrs.getLogistics(d.getlogresId());
		
		response.getWriter().append((d != null) ? gson.toJson(d) : "{}");
		
		return d;
	}

	public void getAllLogRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<LogisticsAndResources> resList = lrs.getAllLogistics();
		
		response.getWriter().append(gson.toJson(resList));

	}

	public void getAllLogisticsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("Type");
		
		String type;
		try {
			type = input.toString();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "Logistics Type parameter improperly formatted.");
			return;
		}
		
		List<LogisticsAndResources> resList = lrs.getAllLogisticsByType(type);
		
		response.getWriter().append(gson.toJson(resList));
		

	}

	public void addLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		LogisticsAndResources dr = gson.fromJson(request.getReader(), LogisticsAndResources.class);
		
		lrs.addLogistics(lrs);
		
		response.getWriter().append(gson.toJson(dr));

	}

	public void updateLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LogisticsAndResources dr = gson.fromJson(request.getReader(), LogisticsAndResources.class);
		
		lrs.updateLogistics(dr);
		
		response.getWriter().append(gson.toJson(dr));

	}
	
	public boolean updateLogisticsGrade(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		LogisticsAndResources dr = gson.fromJson(request.getReader(), LogisticsAndResources.class);
		int resourceId = dr.getlogresId();
		double finalGrade = dr.getFinalGrade();
		
		LogisticsAndResources LR = lrs.getLogistics(resourceId);
		
		LR.setFinalGrade(finalGrade);
		
		lrs.updateLogistics(LR);
		
		response.getWriter().append(gson.toJson(LR));
		
		return true;
	}

	public void deletelogistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LogisticsAndResources dr = gson.fromJson(request.getReader(), LogisticsAndResources.class);
		
		lrs.deleteLogistics(dr);
		
		response.getWriter().append("Logistic Deleted");
	}

	@Override
	public void getAllLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLogistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
	}

	

	
	}

	




