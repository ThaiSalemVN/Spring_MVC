<%
 	String view = request.getParameter("view");
	if(view.startsWith("user/")){
		pageContext.forward("user-layout.jsp");
	}
	else if(view.startsWith("admin/")){
		pageContext.forward("admin-layout.jsp");
	}

%>