package org.developer.elbetasal.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet" , urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {



	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Hello World");
	}

	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
		Logger log = LoggerFactory.getLogger(getServletName());
		log.info("Running our first servlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Hello World!</h3>");
	}
}
