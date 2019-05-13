package com.cto51.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/jsonpServlet")
public class JsonpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String callback = req.getParameter("callback");
		resp.setCharacterEncoding("UTF-8");
		String json = "{\"code\":\"200\", \"result\":\"remote return value\"}";
		resp.getWriter().print(callback + "(" + json + ");");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}