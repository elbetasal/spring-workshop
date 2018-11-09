package org.developer.elbetasal.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/books")
public class BooksServlet extends HttpServlet {

	private BookRepository bookRepository = new BookRepository();

	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Hello World");
	}

	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
		Logger log = LoggerFactory.getLogger(getServletName());
		log.info("Getting all books");
		request.setAttribute("books" , bookRepository.findAllBooks());
		RequestDispatcher dispatcher = request.getRequestDispatcher("books.jsp");
		dispatcher.forward(request , response);
	}
}
