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
@WebServlet("/updatetrain")
public class Updatetrain extends HttpServlet{
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
	
	Train train=new Train();
	train.setNumber(trainnumber);
	train.setName(trainname);
	train.setSeat(trainseat);
	train.setStations(trainstations);
	train.setPrice(trainprice);
	train.setTime(trainstimings);
	train.setDays(traindays);
	
	
	Traindao dao=new Traindao();
	dao.update(train);
	
	
	List<Train> list=dao.fetchall();
	
	resp.getWriter().print("<h1 style='color:blue'>Railway information updated successfully</h1>");
	req.setAttribute("list", list);
	req.getRequestDispatcher("FetchrailwayInfo.jsp").include(req, resp);
}}