package controllers.admin.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BaseServlet;
import models.BO.PostBO;
import models.BO.StatisticBO;
import models.BO.UserBO;
import models.Bean.Post;
import models.Bean.StateStatistic;
import models.Bean.Statistic;

@WebServlet(urlPatterns = "/admin")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private PostBO postBO;
	private StatisticBO statisticBO;
	public HomeServlet() {
		postBO = new PostBO();
		statisticBO = new StatisticBO();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String sortBy = request.getParameter("sortBy") != null ? (String)request.getParameter("sortBy") : "";
		String keyword = request.getParameter("keyword") != null ? (String)request.getParameter("keyword") : "";
		int state = request.getParameter("state") != null ? Integer.parseInt(request.getParameter("state")) : -1;
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -7);
		
		Date now = new Date();
		
		ArrayList<Statistic> userStatistic = statisticBO.getNewUserInRange(calendar.getTime(), now);
		ArrayList<StateStatistic> stateStatistic = statisticBO.getStateInRange(calendar.getTime(), now);
		ArrayList<Post> posts = postBO.getByFilter(keyword, null, state, sortBy);
		
		request.setAttribute("stateStatistic", stateStatistic);
		request.setAttribute("userStatistic", userStatistic);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/views/admin/home/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
