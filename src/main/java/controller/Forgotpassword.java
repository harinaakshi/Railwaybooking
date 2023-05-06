package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import dto.User;

@WebServlet("/forgotpassword")
public class Forgotpassword extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int userid=Integer.parseInt(req.getParameter("id"));
	Userdao dao=new Userdao();
	User user=dao.find(userid);
	if(user==null){
		resp.getWriter().print("<h1 style='color:red'>Invalid id</h1>");
		req.getRequestDispatcher("Forgotpassword.html").include(req, resp);

	}
	else{
		long mobile=Long.parseLong(req.getParameter("mobile"));
		Date dob=Date.valueOf(req.getParameter("dob"));
		
		if(mobile==user.getMob() && dob.equals(user.getDob()))
		{
			user.setPassword(req.getParameter("new"));
			dao.update(user);
			resp.getWriter().print("<h1 style='color:=red'>Password has been changed</h1> ");
			req.getRequestDispatcher("Login.html").include(req, resp);
		
		}
		else{
			resp.getWriter().print("<h1 style='color:=red'>Invalid details so can not set new password</h1> ");
			req.getRequestDispatcher("Forgotpassword.html").include(req, resp);
		}
	}
}
}
