<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.pactera.dao.*"%>
<%
	MySqlUserDao db = new MySqlUserDao();

	String query = request.getParameter("q");
	
	List<String> empId = db.autoCompleteUser(query);

	Iterator<String> iterator = empId.iterator();
	while(iterator.hasNext()) {
		String id = (String)iterator.next().trim();
		out.println(id);
	}
%>