<%
 	String view = request.getParameter("view");
	if(view.startsWith("blank/")){
		pageContext.forward("blank-layout.jsp");
	}
	else if(view.startsWith("admin/")){
		pageContext.forward("admin-layout.jsp");
	}
	else{
		pageContext.forward("user-layout.jsp");
	}

%>