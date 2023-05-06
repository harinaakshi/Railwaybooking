<%@page import="java.util.Arrays"%>
<%@page import="dto.Train"%>
<%@page import="dao.Traindao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Traindao dao=new Traindao();
Train train=dao.fetch(Integer.parseInt(request.getParameter("number")));
%>
<form action="updatetrain" method="post">
Train Number: <input type="number" name="tnumber" value="<%=train.getNumber()%>" readonly="readonly"><br>
Train Name: <input type="text" name="tname" value="<%=train.getName()%>"><br>
Number of seats: <input type="number" name="tseat" value="<%=train.getSeat()%>"><br>
Stations: <textarea rows="5" cols="30" name="tstation" >

<%for(String station:train.getStations())
{
out.print(station+",");
}%></textarea><br>
Ticket Price: <textarea rows="5" cols="30" name="tprice">
<% for(String price:train.getPrice()) 
{
out.print(price+",");
}%></textarea><br>
Time: <textarea rows="5" cols="30" name="ttime" ><%
for(String time:train.getTime()){
	out.print(time+",");
}
%></textarea><br>
Days: <textarea rows="5" cols="30" name="tdays" ><%
for(String days:train.getDays())
{
out.print(days+",");
}%></textarea><br>
<button type="reset">Cancel</button>
<button>Update</button>
</form>

</body>
</html>
<%!//to print array values without brackets we should not give Arrays.toString() we should give for loop%>