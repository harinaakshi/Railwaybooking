package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Traindao;
import dto.Train;

@WebServlet("/usertraininfo")
public class FetchUserTrain extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Traindao dao=new Traindao();
	List<Train> list=dao.fetchall();
	
	
	if(list.isEmpty()){
		resp.getWriter().print("<h1 style='color:red'>No railway information available</h1>");
		req.getRequestDispatcher("CustomerHome.html").include(req, resp);
		
	}
	else{
		req.setAttribute("list", list);
	req.getRequestDispatcher("UserFetchRailway.jsp").forward(req, resp);
}}
	
}



