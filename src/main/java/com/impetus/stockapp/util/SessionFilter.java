package com.impetus.stockapp.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 */
public class SessionFilter implements Filter {

    private final String[] validURLS = { "/profile.do", "/login.do", "/contact.do", "/deleteStock.do", "/addStock.do",
	    "/updateStock.do", "/updateInesterStock.do", "/getPassword.do", "/logout.do", "/welcome.do",
	    "/register.do", "/changepassword.do", "/checkemailexist.do", "/getInvesterstock.do", "/getStockCSV.do",
	    "/getStockByStockSymbolOrCompanyname.do", "/getStockChart.do", "/getStockCSV2.do", "/getChart.do",
	    "/getLiveStock.do", "/getDayStockChart.do", "/userNameExist.do" };

    /**
     * Method doFilter.
     * 
     * @param req
     *            ServletRequest
     * @param res
     *            ServletResponse
     * @param chain
     *            FilterChain
     * @throws IOException
     * @throws ServletException
     * @see javax.servlet.Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
	    ServletException {

	HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;
	String url = request.getServletPath();
	boolean isSessionCheck = false;
	if (!shouldExclude(request)) {
	    if (isValidURLS(url)) {
		if (!url.contains("login.do") && !url.contains("register.do") && !url.contains("changepassword.do")
			&& !url.contains("checkemailexist.do") && !url.contains("getPassword.do")
			&& !url.contains("contact.do") && !url.contains("userNameExist.do")) {
		    if (url.contains(".do")) {
			isSessionCheck = true;
		    }
		}

	    }
	}

	if (isSessionCheck) {
	    HttpSession session = request.getSession();
	    if (null == session.getAttribute("invster")) {
		response.sendRedirect("login.do");
	    }
	}
	chain.doFilter(req, res);

    }

    /**
     * Method shouldExclude.
     * 
     * @param req
     *            ServletRequest
     * @return boolean
     */
    private boolean shouldExclude(ServletRequest req) {
	if (req instanceof HttpServletRequest) {
	    HttpServletRequest hreq = (HttpServletRequest) req;
	    return (hreq.getRequestURI().endsWith(".css") || hreq.getRequestURI().endsWith(".png")
		    || hreq.getRequestURI().endsWith(".jpg") || hreq.getRequestURI().endsWith(".gif")
		    || hreq.getRequestURI().endsWith(".ico") || hreq.getRequestURI().endsWith(".js"));
	}
	return false;
    }

    /**
     * Method isValidURLS.
     * 
     * @param URL
     *            String
     * @return boolean
     */
    private boolean isValidURLS(String URL) {
	boolean contains = false;
	for (String url : validURLS) {
	    if (url.equalsIgnoreCase(URL)) {
		contains = true;
		break; // No need to look further.
	    }
	}
	return contains;
    }

    /**
     * Method destroy.
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
	// TODO Auto-generated method stub

    }

    /**
     * Method init.
     * 
     * @param arg0
     *            FilterConfig
     * @throws ServletException
     * @see javax.servlet.Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub

    }

}
