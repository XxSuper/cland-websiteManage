package com.maiyajf.base.healthcheck;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/healthCheck", asyncSupported = false)
public class HealthCheckServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338090140362594340L;

	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print("success");
    }
}
