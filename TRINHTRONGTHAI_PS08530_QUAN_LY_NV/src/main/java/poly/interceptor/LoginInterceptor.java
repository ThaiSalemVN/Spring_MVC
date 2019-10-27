package poly.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter  {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response
						,Object handler) throws Exception{
		HttpSession session = request.getSession();
		if (session.getAttribute("User")== null) {
			
			response.sendRedirect(request.getContextPath()+"/admin/login.htm");
			return false;
		}
	
		return true;
	}
}
