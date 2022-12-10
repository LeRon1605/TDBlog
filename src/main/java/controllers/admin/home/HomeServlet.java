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
import core.Cache.InMemoryCache;
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
		String sortBy = request.getParameter("sortBy") != null ? (String)request.getParameter("sortBy") : "";
		String keyword = request.getParameter("keyword") != null ? (String)request.getParameter("keyword") : "";
		int state = request.getParameter("state") != null ? Integer.parseInt(request.getParameter("state")) : -1;
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -7);
		
		Date now = new Date();
		
		ArrayList<Statistic> userStatistic;
		if (InMemoryCache.getInstance().get("userStatistic") != null)
			userStatistic = InMemoryCache.getInstance().get("userStatistic");
		else
		{
			userStatistic = statisticBO.getNewUserInRange(calendar.getTime(), now);
			InMemoryCache.getInstance().put("userStatistic", userStatistic, 60 * 3);
		}
		ArrayList<StateStatistic> stateStatistic;
		if (InMemoryCache.getInstance().get("stateStatistic") != null)
			stateStatistic = InMemoryCache.getInstance().get("stateStatistic");
		else
		{
			stateStatistic = statisticBO.getStateInRange(calendar.getTime(), now);
			InMemoryCache.getInstance().put("stateStatistic", stateStatistic, 60 * 3);
		}
		ArrayList<Post> posts = postBO.getByFilter(keyword, null, state, sortBy);
		
		request.setAttribute("stateStatistic", stateStatistic);
		request.setAttribute("userStatistic", userStatistic);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/views/admin/home/index.jsp").forward(request, response);
	}

}
