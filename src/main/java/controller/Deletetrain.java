package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Traindao;
import dto.Train;

@WebServlet("/delete")
public class Deletetrain extends HttpServlet {
;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("number"));
	
	Traindao dao=new Traindao();
	dao.delete(id);
	
	List<Train> list=dao.fetchall();
	if(list.isEmpty()){
		resp.getWriter().print("<h1 style='color:red'>Railway info available</h1>");
		req.getRequestDispatcher("ManagementHome.html").include(req, resp);
	}
	else{
	resp.getWriter().print("<h1 style='color:green'>Deleted successfully");
	req.setAttribute("list",list);
	req.getRequestDispatcher("FetchrailwayInfo.jsp").include(req, resp);
	}
	
}
}
