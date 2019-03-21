package com.srijan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srijan.model.Doctor;
import com.srijan.model.User;
import com.srijan.service.DoctorService;
import com.srijan.service.UserService;

public class LoginServlet extends HttpServlet {

	private UserService userService;
	private DoctorService doctorService;

	@Override
	public void init() {
		userService = new UserService();
		doctorService = new DoctorService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		if(action.equals("/login")){
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}else if(action.equals("/login_check")){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();

			String email = req.getParameter("email");
			String pass = req.getParameter("password");
			try {
				User user = userService.getUserByEmailId(email);
				if (user != null && user.getPassword().equals(pass)) {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					// setting session to expiry in 30 mins
					session.setMaxInactiveInterval(30 * 60);
					listDoctors(req, resp);
				} else {

					out.println("Username or Password incorrect");
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);

				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new ServletException(e);
			}
		}else if(action.equals("/logout")){
			try {
				logout(req, resp);
			}catch (ClassNotFoundException | SQLException e) {
				throw new ServletException(e);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		// invalidate the session if exists
		HttpSession session = request.getSession(false);
		System.out.println("User=" + session.getAttribute("user"));
		if (session != null) {
			session.setAttribute("user", null);
			session.invalidate();
		}
		response.sendRedirect("index.jsp");

		/*
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		 * dispatcher.forward(request, response);
		 */
	}

	private void listDoctors(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		List<Doctor> listDoctors = doctorService.getAll();
		request.setAttribute("listDoctors", listDoctors);
		RequestDispatcher dispatcher = request.getRequestDispatcher("hospital_galaxy.jsp");
		dispatcher.forward(request, response);
	}

}