package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Traindao;
import dto.Train;

@WebServlet("/addtrain")
public class AddTrain extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int trainnumber=Integer.parseInt(req.getParameter("tnumber"));
	String trainname=req.getParameter("tname");
	int trainseat=Integer.parseInt(req.getParameter("tseat"));
	String station =req.getParameter("tstation");
	String[] trainstations=station.split(",");
	
	String price =req.getParameter("tprice");
	String[] trainprice=price.split(",");

	String timing =req.getParameter("ttime");
	String[] trainstimings=timing.split(",");
	
	String days =req.getParameter("tdays");
	String[] traindays=days.split(",");

//PrintWriter out=resp.getWriter();
//out.print("<h1>");
//out.print("Train Number: "+trainnumber);
//out.print("<br>");
//out.print("Train Name:"+trainname);
//out.print("<br>");
//out.print("Train Seat:"+trainseat);
//out.print("<br>");
//out.print("Train Stations"+Arrays.toString(trainstations));
//out.print("<br>");
//out.print("Train price"+ Arrays.toString(trainprice));
//out.print("<br>");
//out.print("Train Time:" + Arrays.toString(traintimings);
	//out.print("<br>");
	//out.print("Train Time:" + Arrays.toString(traintimings);
	
	Train train=new Train();
	train.setNumber(trainnumber);
	train.setSeat(trainseat);
	train.setTime(trainstimings);
	train.setDays(traindays);
	train.setName(trainname);
	train.setPrice(trainprice);
	train.setStations(trainstations);
	
	Traindao dao=new Traindao();
	dao.save(train);
	resp.getWriter().print("<h1 style='color:green'>Train details added successfully</h1>");
	req.getRequestDispatcher("ManagementHome.html").include(req, resp);
}
}
