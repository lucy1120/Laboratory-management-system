package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "adminloginFilter", urlPatterns = { "/*" })
//@WebFilter("/*")
public class AdminLoginFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
//		resp.setCharacterEncoding("UTF-8");
		// 得到用户请求的URI
		String request_uri = req.getRequestURI();
		// 得到web应用程序的上下文路径
		String ctxPath = req.getContextPath();
		// 去除上下文路径，得到剩余部分的路径
		String uri = request_uri.substring(ctxPath.length());
		// 登录页面或Servlet不拦截
//		System.out.println(uri);
		if(uri.contains("AdminLogin.jsp")|| uri.contains("servlet") || uri.contains("fonts")|| uri.contains("Servlet") || uri.endsWith(".js") ||  uri.contains(".css") || uri.endsWith(".jpg") ||  uri.endsWith(".gif")  ||  uri.endsWith(".png")){
			chain.doFilter(request, response);
		}else{
			// 判断用户是否已经登录
			if (!session.getAttribute("adminid").equals("")) {
				chain.doFilter(request, response);
			}
		}
	}
}

