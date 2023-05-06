package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import dto.User;

@WebServlet("/register")
public class Registeruser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName=req.getParameter("first");
		String lastName=req.getParameter("last");
		long mob=Long.parseLong(req.getParameter("mobile"));
		String email=req.getParameter("c");
		String gender=req.getParameter("d");
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");
		Date dob=Date.valueOf(req.getParameter("e"));
//		int age=LocalDate.now().getYear()-dob.toLocalDate().getYear();
		int age=Period.between(dob.toLocalDate(),LocalDate.now()).getYears();
		
		if(password1.equals(password2)){
//			resp.getWriter().print("<h1>"+age+"</h1>");
			if(age>18)
			{
				User user=new User();
				user.setAge(age);
				user.setDob(dob);
				user.setEmail(email);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setGender(gender);
				user.setMob(mob);
				user.setPassword(password1);
				
				Userdao dao=new Userdao();
				dao.save(user);
				
				resp.getWriter().print("<h1 style='color:green'>Account created successfully</h1>");
				
				resp.getWriter().print("<h1 style='color:blue'>Your userid is:"+user.getId()+"</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
				
			}
			else{
				resp.getWriter().print("<h1 style='color:red'>You are not old enough to create account</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
			
		}
		else{
			resp.getWriter().print("<h1 style='color:red'>Password miss match</h1>");
			req.getRequestDispatcher("Register.html").include(req, resp);
		}
		
	}

}
