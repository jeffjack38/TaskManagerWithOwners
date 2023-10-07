package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTask;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editTaskServlet")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListTaskHelper dao = new ListTaskHelper();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListTask taskToUpdate = dao.searchForTaskById(tempId);
		taskToUpdate.setTitle(title);
		taskToUpdate.setDescription(description);
		taskToUpdate.setStatus(status);
		
		dao.updateTask(taskToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllServlet").forward(request, response);
	}

}